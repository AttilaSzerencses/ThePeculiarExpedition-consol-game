package ThePeculiarExpedition.Kezdes;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Inventory.Slot;
import ThePeculiarExpedition.Tarsak.Tarsak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Ez az osztaly felelos a felfedoz adatainak tarolasaert, illetve a felfedohoz kapcsolodo metodusokert.
 * @author Szerencsés Attila
 */
public class Felfedezo {

    public static double energia = 100;
    public static double arany = 250;
    public static int slotszam = 8;
    public static int viszony = 3;
    public static int hirnev = 0;
    public static int latokor = 1;
    public static double mozgas = 1;
    public static int kuldetes = 1;
    public static String[] fuggoseg = new String[]{" ", " "}; //Ebben tárolom az előző 2 elfogyatott dolgot, ha whisky vagy kábítószer mind2 akkor függöség
    public static int fuggoseglepes = 0;
    public static List<Tarsak> csapattarsak = new ArrayList<>();

    public static List<Tarsak> getCsapattarsak() {
        return csapattarsak;
    }

    /**
     * Ez a metodus felelos a felfedo altal vegzett eves cselekvesert. A parameterben kapott targyrol leelenorzi, hogy mi, es ez alapjan noveli az energiat.
     * Tovabba itt tarolodik el az elfogyasztott fuggoseget okozo elelmiszer, es ha bekovetkezik 15% eselyel a fuggoseg, itt tortenik meg ennek kiiratasa.
     * @param elelmiszer A kapott parameter alapjan allapitja meg, hogy milyen targyrol van szo, es azok milyen tulajdonsaggal rendelkeznek.(+energia, fuggoseg, kivalto)
     */
    public static void eszik(String elelmiszer) {
        int jenergia = 0;
        switch (elelmiszer) {
            case "gyumolcs":
                jenergia += 15;
                break;
            case "hus":
                jenergia += 25;
                break;
            case "csokolade": //kiváltó
                jenergia += 20;
                if (fuggoseg[0].equals("whiskey")&&fuggoseg[1].equals("whiskey") || fuggoseg[0].equals("kabitoszer")&&fuggoseg[1].equals("kabitoszer")){
                    System.out.println("Ettél a kiváltó élelmiszerből, elmúlt a függőséged!");
                }
                if (fuggoseg[0].equals("csokolade")) {
                    fuggoseg[1] = "csokolade";
                } else {
                    fuggoseg[0] = "csokolade";
                }
                break;
            case "kabitoszer":
                if (Tarsak.vaneilyen("saman")) {
                    jenergia += 20 * 1.2;
                } else {
                    jenergia += 20;
                }
                if (fuggoseg[0].equals("kabitoszer")) {
                    fuggoseg[1] = "kabitoszer";
                } else {
                    fuggoseg[0] = "kabitoszer";
                }
                if (Lepesenkent.fuggosege()) {
                    Random szam = new Random();
                    int random = szam.nextInt(100) + 1;
                    if (random <= 15) {
                        System.out.println("AJAJ! FÜGGŐ LETTÉL! HA NEM FOGYASZTASZ A KIVÁLTÓ ÉLELMISZERBŐL(CSOKOLÁDÉ), 30 LÉPÉS UTÁN 10% ESÉLLYEL VESZÍTHETSZ!");
                    }
                }
                    break;
                    case "whiskey":
                        if (Tarsak.vaneilyen("katona")) {
                            jenergia += 20 * 1.2;
                        } else {
                            jenergia += 20;
                        }
                        if (fuggoseg[0].equals("whiskey")) {
                            fuggoseg[1] = "whiskey";
                        } else {
                            fuggoseg[0] = "whiskey";
                        }
                        if (Lepesenkent.fuggosege()) {
                            Random szam2 = new Random();
                            int random2 = szam2.nextInt(100) + 1;
                            if (random2 <= 15) {
                                System.out.println("AJAJ! FÜGGŐ LETTÉL! HA NEM FOGYASZTASZ A KIVÁLTÓ ÉLELMISZERBŐL(CSOKOLÁDÉ), 30 LÉPÉS UTÁN 10% ESÉLLYEL VESZÍTHETSZ!");
                            }
                            break;
                        }
        }
                        if (energia + jenergia > 100) {
                            energia = 100;
                        } else {
                            energia += jenergia;
                        }

        }

    /**
     * Ez a metodus felelos a kuldetesek elloti vasarlasok megvalositasaert.
     * Bekeri a konzolrol, hogy szeretnenk e vasarolni, vagy nem, tovabba bekeri a megvasarolni kivant termeket is.
     * A termekek arat levonja a felfedezo aranyabol, illetve hozzadja az inventoryjahoz.
     * Ha hibas adatot kap, ujra keri a felhasznalotol, illetve azt is ellenorzi, hogy van e kereskedonk, ennek fuggvenyeben csokkenti a levont arany mennyiseget.
     */
    public static void vasarol() {
        Inventory.inventorykiir();
        System.out.println("A küldetés megkezdése előtt van lehetőséged vásárolni. Szeretnél vásárolni? i/n");
        Scanner sc = new Scanner(System.in);
        String szeretne = sc.nextLine();
        if (szeretne.equals("i")) {
            System.out.println("Következő termékekből tudsz vásárolni:");
            System.out.print("Kötél : 5 arany, Bozótvágó: 10 arany, Fáklya: 7 arany, Üveggolyó: 5 arany, Hús: 10 arany, Whiskey: 9 arany, Csokoladé: 8 arany");
            System.out.println();
            System.out.println("Kérlek add meg, hogy mit szeretnél vásárolni! (kisbetűvel, ékezet nélkül!)");
            String vasarlas = sc.nextLine();
            int ar = 0;
            boolean vantargy = true;
            switch (vasarlas) {
                case "kotel":
                    ar = 5;
                    break;
                case "bozotvago":
                    ar = 10;
                    break;
                case "faklya":
                    ar = 7;
                    break;
                case "uveggolyo":
                    ar = 5;
                    break;
                case "hus":
                    ar = 10;
                    break;
                case "whiskey":
                    ar = 9;
                    break;
                case "csokolade":
                    ar = 8;
                    break;
                case "kincs":
                    ar = 0;
                    break;
                default:
                    System.out.println("Nem létezik ilyen tárgy!");
                    vantargy = false;
                    vasarol();
            }

            if (vantargy) {
                if (Tarsak.vaneilyen("kereskedo")) {
                    ar = (int) (ar * 0.85);
                }
                if (Felfedezo.arany < ar) {
                    System.out.println("Nincs elég aranyad, hogy megvásárold!");
                } else {
                    Felfedezo.arany -= ar;
                    boolean sikerult = false;
                    for (int i = 0; i < Inventory.inventory.size(); i++) {
                        if (Inventory.inventory.get(i).hozzaad(vasarlas)) {
                            sikerult = true;
                            break;
                        }
                    }
                    if (!sikerult) {
                        Inventory.inventory.add(new Slot());
                        Inventory.inventory.get(Inventory.inventory.size() - 1).hozzaad(vasarlas);
                    }
                }
                vasarol();
            }
        } else if(szeretne.equals("n")){

        } else{
            System.out.println("NINCS ILYEN LEHETŐSÉG!");
            vasarol();
        }
    }

    /**
     * Ez a metodus felelos a kuldetes vegen torteno kincs eladasaert. Bekeri a felhasznalotol, hogy eladni, vagy eladomanyozni szeretne.
     * Eladas eseten 50aranyat ad a felfedezo aranyahoz, eladomanyozas eseten pedig +80 hirnevet.
     */
    public static void kincselad() {
        System.out.println("Küldetésed végére értél, mielőtt tovább lépsz eladhatod vagy eladományozhatod kincseid!");
        System.out.println("Ha eladod 50 aranyal leszel gazdagabb, ha elajándékozod a múzeumnak, akkor pedig +80 hírnevet kapsz.");
        System.out.println("Melyiket szeretnéd? eladni/eladomanyozni");
        Scanner sc = new Scanner(System.in);
        String valasztas = sc.nextLine();
        switch (valasztas) {
            case "eladni":
                System.out.println("Sikeresen eladtad!");
                Felfedezo.arany+=50;
                Inventory.torles("kincs");
                break;
            case "eladomanyozni":
                System.out.println("Sikeresen eladományoztad!");
                Felfedezo.hirnev+=80;
                Inventory.torles("kincs");
                break;
            default:
                System.out.println("NINCS ILYEN LEHETŐSÉG!");
                kincselad();
                break;
        }
    }

    /**
     * Ez a metodus felelos a felfedezo tarsainak kiiratasaert.
     */
    public static void tarsakkiir(){
        System.out.print("Társaid: ");
        if (Felfedezo.csapattarsak.size()!=0){
            for (int i = 0; i < Felfedezo.csapattarsak.size() ; i++) {
                System.out.print(Felfedezo.csapattarsak.get(i).nev+" ");
            }
        }else{
            System.out.print("Nincsenek!");
        }
        System.out.println();
    }

    /**
     * Ez a metodus felelos a felfedezo aranyanak kiiratasaert.
     */
    public static void aranykiir(){
        System.out.println("Aranyad: "+Felfedezo.arany);
    }

    /**
     * Ez a metodus felelos a felfedezo energiajanak kiiratasaert.
     */
    public static void energiakiir(){
        System.out.format("Energiád: %.2f", Felfedezo.energia);
        System.out.println("");
    }

    }

