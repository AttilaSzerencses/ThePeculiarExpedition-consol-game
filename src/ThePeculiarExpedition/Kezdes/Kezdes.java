package ThePeculiarExpedition.Kezdes;

import ThePeculiarExpedition.Tarsak.Kereskedo;
import ThePeculiarExpedition.Tarsak.Szamar;
import ThePeculiarExpedition.Tarsak.Katona;

import java.util.Random;
import java.util.Scanner;

/**
 * Ez az osztaly felelos a jatek kezdesenek megvalositasaert.
 * Itt tortenik a palyabekeres, (szeretne sajatot, vagy alappalya)
 * Itt tortenik a kezdo szoveg kiiratasa, ellenfelek szamanak bekerese, illetve a kuldetes elotti tarsvalasztas megvalositasa.
 * @author Szerencsés Attila
 */
public class Kezdes {
    public static boolean sajate=false;
    public static String palyanev="";
    public static int ellenfeldb=0;
    public static int[] versenythirnev;
    public static int kisorsolt=0;

    /**
     * Ez a metodus felelos a jatek kezdeten megjeleno szoveg kiiratasaert.
     */
    public static void startszoveg(){
        System.out.println("Üdvözöllek a játékomban!");
        System.out.println("A játék során küldetéseket kell elvégezned, és hirnevet szerezned, ezzel versenyezni a többi ellenfeled ellen.");
        System.out.println("Legfőbb célód megtalálni az arany piramist!");
        System.out.println("Jó játékot kívánok!");
        System.out.println("A jelölések a pályán:");
        System.out.println("Aranypiramis: ◬ , Barlang: \uD83E\uDD87 , Bozot: \uD83C\uDF3E , Dzsungel: \uD83C\uDF34 , Expedíciós hajó: ⛵ , Falu: \uD83C\uDFE0 , Fű: ⬜ , Hegy: \uD83C\uDF04 , Oltár: ۩ , Tenger: \uD83C\uDF0A , To: ■ , Vizestalaj: ▩ ");
    }

    /**
     * Ez a metodus felelos a palyabekeresert. Bekeri a felhasznalotol, hogy sajatpalyan szeretne jatszani, vagy alapon.
     */
    public static void palyavalasztas(){
        int beolvasott=0;
        System.out.println("Alap pályával vagy salyát pályával szeretnél játszani?");
        System.out.println("1 : Alap pálya");
        System.out.println("2 : Saját pálya");
            System.out.println("1-es vagy 2-es lehetőséget válaszd!");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()){
                beolvasott = sc.nextInt();
                switch(beolvasott) {
                    case 1:
                        sajate=false;
                        break;
                    case 2:
                        sajate=true;
                        break;
                    default:
                        System.out.println("NINCS ILYEN LEHETŐSÉG!");
                        palyavalasztas();
                        break;
                }
            } else{
                System.out.println("NINCS ILYEN LEHETŐSÉG!");
                palyavalasztas();
            }
        }

    /**
     * Ez a metodus felelos a ellenfelek szamanak bekereseert. 3-5 ellenfelre van lehetoseg.
     * Ellenuk fog versengeni, a jatek vegeig. Akinek a legtobb hirneve lesz, az nyer.
     */
    public static void ellenfelbeker(){
        System.out.println("Hány darab ellenfelet szeretnél a játék során?(min 3, max 5)");
        System.out.println("Ellenük kell versengened, akinek több hírneve lesz az utolsó küldetés végére, ő fogy győzni.");
        System.out.println("Kérlek adj meg egy 3-5 közöttti számot.");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            ellenfeldb = sc.nextInt();
           if (ellenfeldb<3 || ellenfeldb>5){
                    System.out.println("NINCS ILYEN LEHETŐSÉG!");
                    ellenfelbeker();
           }
        } else{
            System.out.println("NINCS ILYEN LEHETŐSÉG!");
            ellenfelbeker();
        }
        versenythirnev = new int[ellenfeldb];
    }

    /**
     * Ez a metodus felelos a sajat palya nevenek bekereseert.
     */
    public static void palyabeker() {
        if (sajate) {
            System.out.println("A mappába csatolt fájlok neve előtt sorra add meg melyik küldetéshez tartozó pálya! (1-5)");
            System.out.println("Ha nem jó fájlnevet adsz meg az alap pálya fog betöltődni!");
            System.out.println("Add meg a saját fájlod nevét a számot lehagyva:(sajat.txt)");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLine()) {
                palyanev ="1"+sc.nextLine();
            }
        } else{
            palyanev="alappalya1.txt";
        }
    }

    /**
     * Ez a metodus felelos a jatek elejen felajanlott tarsaknak a sorsolasaert.
     * 3 tars kozul veletlenszeruen valaszt egyet.
     */
    public static void tarssorolas(){
        Random szam = new Random();
        int random = szam.nextInt(3) + 1;
        System.out.println("Szeretnéd elfogadni társként(150 aranyadba fog kerülni): ");
        switch (random) {
            case 1:
                System.out.println("Kereskedő (mindent kicsivel olcsóbban vehetsz és drágábban adhatsz el)");
                kisorsolt=1;
                ;
                break;
            case 2:
                System.out.println("Katona (a Whiskey +20% energia)");
                kisorsolt=2;
                break;
            case 3:
                System.out.println("Szamár (+2 Inventory slot)");
                kisorsolt=3;
                break;
        }
        tarsvalasztas();
    }

    /**
     * Ez a metodus felelos a kisorsolt tars valasztasaert. A felhasznalo elfogadhatja, illetve elutasithatja.
     * Itt adodik hozza a kisorsolt tars a felfedezo tarsaihoz, es levonasra kerul a 150 arany.(tars ara)
     */
    public static void tarsvalasztas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("i/n -el válaszolj.");
        String szeretne = sc.nextLine();
            if (szeretne.equals("i")){
                if (Felfedezo.arany>=150) {
                    Felfedezo.arany -= 150;
                    switch (kisorsolt) {
                        case 1:
                            new Kereskedo();
                            for (int i = 0; i < Felfedezo.csapattarsak.size() ; i++) {
                                Felfedezo.csapattarsak.get(i).setNev("kereskedo");
                            }
                            break;
                        case 2:
                            new Katona();
                            for (int i = 0; i < Felfedezo.csapattarsak.size() ; i++) {
                                Felfedezo.csapattarsak.get(i).setNev("katona");
                            }
                            break;
                        case 3:
                            new Szamar();
                            for (int i = 0; i < Felfedezo.csapattarsak.size() ; i++) {
                                Felfedezo.csapattarsak.get(i).setNev("szamar");
                            }
                            break;
                    }
                }
                else{
                    System.out.println("Sajnos nincs elég aranyad, hogy elfogadd a társat.");
                }
        } else if(szeretne.equals("n")){

            } else {
                System.out.println("NINCS ILYEN LEHETŐSÉG!");
                tarsvalasztas();
            }
    }

}
