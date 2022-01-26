package ThePeculiarExpedition.Menu;

import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Palya.Palya;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Ez az osztaly felelos a jatek soran hasznalatos menu-ert.
 * @author Szerencsés Attila
 */
public class Menu {
    /**
     * Ez a metodus felelos a menu megvalositasaert.
     * Megjeleniti a jelenlegi lehetosegeket a menube, es bekeri a felhasznalotol, hogy mit szeretne tenni.
     * Lehetoseg van mozgasra, evesre, adatkiirasra, kilepesre.
     * Mozgas: Belép a mozgás metodusba, kiirodik a palya, elkezdodik a jatek.
     * Eves: Itt van lehetosege a felhasznalonak elfogyasztani a kulonbozo fogyaszthato targyait az inventoryjabol.
     * Adatkiiras: A jatek soran folyamatosan nem megjeleno adatokat irja ki. Pl. viszony, slotszam, hirnev, latoker
     * Kilepes: A jatekbol valo teljes kilepesert felelos. Leallitja a program futasat.
     */
    public static void menu() throws FileNotFoundException {
        System.out.println("Mit szeretnél csinálni? Kérlek add meg:");
        System.out.println("mozgas || eves || adatkiiras || kilepes");
        Scanner sc = new Scanner(System.in);
        String feladat = sc.nextLine();
        switch(feladat) {
            case "mozgas":
                    Palya.mozgas();
                break;
            case "eves":
                System.out.println("Azokat a dolgokat tudod elfogyasztani amik az inventorydban vannak!");
                if (Inventory.inventory!=null) {
                    for (int i = 0; i < Inventory.inventory.size(); i++) {
                        System.out.print(Inventory.inventory.get(i).slot + ", ");
                    }
                } else{
                    System.out.print("Üres");
                }
                System.out.println("Mit szeretnél elfogyasztani?");
                Scanner sc2 = new Scanner(System.in);
                String fogyasztando = sc.nextLine();
                if (Inventory.vanenala(fogyasztando)){
                    if (fogyasztando.equals("kotel") || fogyasztando.equals("bozotvago") || fogyasztando.equals("faklya") || fogyasztando.equals("uveggolyo") || fogyasztando.equals("kincs") || fogyasztando.equals("aranypiramis")  ){
                        System.out.println("NEM FOGYASZTHATÓ EL A(Z) "+fogyasztando+" !");
                        menu();
                    }
                    System.out.println("Elfogyasztva: "+fogyasztando);
                    Felfedezo.eszik(fogyasztando);
                    System.out.format("Energiád: %.2f", Felfedezo.energia);
                    System.out.println();
                    Inventory.torles(fogyasztando);
                    menu();
                } else{
                    System.out.println("NINCS NÁLAD: "+fogyasztando);
                    menu();
                }
                break;
            case "adatkiiras":
                System.out.println("Viszonyod: "+Felfedezo.viszony);
                System.out.println("Slotjaid száma: "+Felfedezo.slotszam);
                System.out.println("Hírneved:"+Felfedezo.hirnev);
                System.out.println("Jelenlegi látóköröd lépésenként: "+Felfedezo.latokor);
                menu();
                break;
            case "kilepes":
                System.out.println("Kiléptél a játékból!");
                System.exit(0);
                break;
            default:
                System.out.println("NINCS ILYEN LEHETŐSÉG!");
                break;
        }

    }

}
