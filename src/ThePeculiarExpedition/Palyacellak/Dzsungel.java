package ThePeculiarExpedition.Palyacellak;

import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Palya.Palya;

import java.util.Scanner;

/**
 * Ez a gyerek osztaly felelos az dzsungel ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Dzsungel extends Cellak{

    public Dzsungel() {
        ertek=7;
        nev="dzsungel";
        jarhatoe=true;
        vanekincs=false;
        pihenhete=false;
        kijelzes="\uD83C\uDF34";
    }

    /**
     * Ez a metodus felelos a dzsungelhez tartozo mozgaskoltseg szamolsara.
     * Ellenorzi, hogy van e bozotvagonk. Amennyiben igen, megkerdezi a felhasznalot, hogy szeretne e elhasznalni.
     * Ha elhasznalja, akkor kitorlodik az inventorybol, tovabba a dzsungel fuves talaja valtozik.
     * Ha nem használja el vagy nincs, akkor noveli a mozgaskoltseget 100%-al.
     */
    public static void dzsungelmozgas(){
        if (Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].ertek == 7){
            if (!Inventory.vanenala("bozotvago")){
                Felfedezo.mozgas*=2;
            } else{
                System.out.println("Van nálad bozótvágó!");
                System.out.println("Ezáltal könyebben tudsz áthaladni a terepen, nem fog nőni a mozgásköltséged 2x-re.");
                System.out.println("Szeretnéd elhasználni? i/n");
                Scanner sc = new Scanner(System.in);
                String szeretne = sc.nextLine();
                switch (szeretne) {
                    case "i":
                        System.out.println("Elhasználtad a bozótvágód, a dzsungel pedig füves területté alakult!");
                        Inventory.torles("bozotvago");
                        Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].kijelzes = "⬜";
                        break;
                    case "n":
                        break;
                    default:
                        System.out.println("NINCS ILYEN LEHETŐSÉG!");
                        dzsungelmozgas();
                        break;
                }
            }
        }
    }

}
