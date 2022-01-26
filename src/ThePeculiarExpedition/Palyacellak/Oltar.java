package ThePeculiarExpedition.Palyacellak;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Inventory.Slot;
import ThePeculiarExpedition.Kezdes.Felfedezo;

import java.util.Random;
/**
 * Ez a gyerek osztaly felelos az oltar ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * Tovabba az oltaron torteno esemenyek metodusat tarolja.
 * @author Szerencsés Attila
 */
public class Oltar extends Cellak{

    public Oltar() {
        ertek=6;
        nev="oltar";
        jarhatoe=true;
        vanekincs=true;
        pihenhete=false;
        kijelzes="۩";
    }

    /**
     * A metodus feladata az oltaron torteno esemenyek lekezelese.
     * Ha az oltar cellan vagyunk, mindenkeppen talalni fog a felfedezo kincset, ezt eltarolja az inventorynkba.
     * Ha az oltarra lepunk, csokkeni fog a felfedezo viszonya 2-vel.
     * Tovabba azert felel, hogy 80% valoszinuseggel átok érje a felfedezot.
     */
    public static void oltaron(){
        if (Lepesenkent.oltare()) {
            System.out.println("Találtál egy kincset!");
            Inventory.inventory.add(new Slot());
            Inventory.inventory.get(Inventory.inventory.size() - 1).hozzaad("kincs");
            System.out.println("Csökkent a viszonyod 2-vel.");
            if (Felfedezo.viszony - 2 < 0) {
                Felfedezo.viszony = 0;
            } else {
                Felfedezo.viszony -= 2;
            }
            Random szam = new Random();
            int random = szam.nextInt(100) + 1;
            if (random <= 80) {
                System.out.println("Átok ért!");
            }
        }
    }
}

