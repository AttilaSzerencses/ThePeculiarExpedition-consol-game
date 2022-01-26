package ThePeculiarExpedition.Palyacellak;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Inventory.Slot;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Palya.Palya;
import ThePeculiarExpedition.Tarsak.*;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Ez a gyerek osztaly felelos az falu ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * Tovabba a falun vegezheto tevekenysegek metodusait tarolja.
 * @author Szerencsés Attila
 */
public class Falu extends Cellak {
    public static String felajanlott = "";
    public Falu() {
        ertek=98;
        nev="falu";
        jarhatoe=true;
        vanekincs=false;
        pihenhete=true;
        kijelzes="\uD83C\uDFE0";
    }

    /**
     * Ez a metodus felel a falutars felajanlasaert.
     * 20 szazalek eselyel felajanl egy tarsat, a tarsat is 3 tars kozul sorsolja ki, es ezt kiirja a felhasznalo fele.
     */
    public static void falutars() {
        if (Lepesenkent.falue()) {
            System.out.println("Faluba érkeztél.");
            if (Felfedezo.viszony >= 2) {
                Random szam = new Random();
                int random = szam.nextInt(100) + 1;
                if (random <= 20 ) {
                    System.out.println("Szerencséd volt! Választhatsz egy társat 150 aranyért!");
                    String felajanlott = "";
                    Random szam2 = new Random();
                    int random2 = szam2.nextInt(3) + 1;
                    switch (random2) {
                        case 1:
                            System.out.println("Felderítő (+1 látókört ad a pályán való mozgáskor)");
                            felajanlott = "felderito";
                            break;
                        case 2:
                            System.out.println("Sámán (a kábítószer fogyasztása +20% energia, az eddigihez képest)");
                            felajanlott = "saman";
                            break;
                        case 3:
                            System.out.println("Bölcs (+3 viszony új térképen)");
                            felajanlott = "bolcs";
                            break;
                    }
                    falutarsvalasztas();
                }
            }
        }
    }
    /**
     * Ez a metodus felel a kisorsolt falutars elfogadasert, elutasitasaert.
     * Bekeri a felhasznalotol, hogy szeretne-e az uj tarsat, ha igen, megtortenik a peldanyositas, levonodik a 150 arany, es hozza adodik a tarsaihoz.
     * Amennyiben nem szeretne elfogadni, nem valtozik semmi.
     * Tovabba ellenorzi, hogy rendelkezunk e megfelelo aranymennyiseggel.
     */
    public static void falutarsvalasztas(){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Szeretnéd elfogadni a társat? 150 aranyadba fog kerülni! i/n");
                    String kelle = sc.nextLine();
                        if (kelle.equals("i")) {
                            if (Felfedezo.arany >= 150) {
                                Felfedezo.arany -= 150;
                                switch (felajanlott) {
                                    case "felderito":
                                        new Felderito();
                                        for (int i = 0; i < Felfedezo.csapattarsak.size(); i++) {
                                            Felfedezo.csapattarsak.get(i).setNev("felderito");
                                        }
                                        break;
                                    case "saman":
                                        new Saman();
                                        for (int i = 0; i < Felfedezo.csapattarsak.size(); i++) {
                                            Felfedezo.csapattarsak.get(i).setNev("saman");
                                        }
                                        break;
                                    case "bolcs":
                                        new Bolcs();
                                        for (int i = 0; i < Felfedezo.csapattarsak.size(); i++) {
                                            Felfedezo.csapattarsak.get(i).setNev("bolcs");
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                System.out.println("Sajnos nincs elég aranyad, hogy elfogadd a társat!");
                            }
                        } else if(kelle.equals("n")){

                        } else{
                            System.out.println("NINCS ILYEN LEHETŐSÉG!");
                            falutarsvalasztas();
                        }
                }

    /**
     * Ez a metodus felel a faluban torteno vasarlas megvalositasaert.
     * Ha falu cellan allunk, felajanlja a jatek a vasarlas lehetoseget. Ha elfogadjuk, kilistazza a megveheto targyakat, arral egyutt.
     * Bekeri a felhasznalotol mit szeretne venni, majd levonja a megfelelo arany mennyiseget, es eltarolja a megvasarolt targyat az inventoryba.
     * Azt is ellenorzi, hogy rendelkezunk-e eleg arannyal a vasarlashoz.
     * Tovabba figyelembe veszi, hogy van e kereskedo tarsunk, ilyenkor mindent olcsobban vasarolunk meg.
     */
    public static void faluvasarlas() throws FileNotFoundException {
        if (Lepesenkent.falue()) {
            System.out.println("Van lehetőséged vásárolni. Szeretnél? i/n");
            Scanner sc = new Scanner(System.in);
            String szvasarolni = sc.nextLine();
            if (szvasarolni.equals("i")) {
                System.out.println("Vásárolhatsz: ");
                System.out.print("Kötél : 5 arany, Fáklya: 7 arany, Gyümölcs: 9 arany, Hús: 10 arany, Kábítószer: 15 arany ");
                System.out.println();
                Scanner mitvesz = new Scanner(System.in);
                System.out.println("Kérlek add meg amit vásárolni szeretnél! (kis betűvel, ékezet nélkül)");
                String targy = mitvesz.nextLine();
                int ar = 0;
                switch(targy) {
                    case "kotel":
                        ar=5;
                        break;
                    case "faklya":
                        ar=7;
                        break;
                    case "hus":
                        ar=10;
                        break;
                    case "gyumolcs":
                        ar=9;
                        break;
                    case "kabitoszer":
                        ar=15;
                        break;
                    default:
                        System.out.println("NINCS ILYEN TÁRGY!");
                        faluvasarlas();
                }
                if (Tarsak.vaneilyen("kereskedo")){
                    ar = (int)(ar*0.85);
                }
                if (Felfedezo.arany<ar){
                    System.out.println("Nincs elég aranyad, hogy megvásárold!");
                } else{
                    Felfedezo.arany-=ar;
                    boolean sikerult=false;
                    for (int i = 0; i < Inventory.inventory.size(); i++) {
                        if (Inventory.inventory.get(i).hozzaad(targy)){
                            sikerult=true;
                            break;
                        }
                    }
                    if (!sikerult){
                        Inventory.inventory.add(new Slot());
                        Inventory.inventory.get(Inventory.inventory.size()-1).hozzaad(targy);
                    }
                }
                Lepesenkent.adatkiir();
                faluvasarlas();
            } else if(szvasarolni.equals("n")){
                Palya.palyakiir();
                Palya.mozgas();
            } else{
                System.out.println("NINCS ILYEN LEHETŐSÉG!");
                faluvasarlas();
            }
        }
    }
}
