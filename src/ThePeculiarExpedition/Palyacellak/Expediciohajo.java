package ThePeculiarExpedition.Palyacellak;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Kezdes.Kezdes;
import ThePeculiarExpedition.Palya.Palya;
import ThePeculiarExpedition.Tarsak.Tarsak;
import ThePeculiarExpedition.Versenytarsak.Versenytars;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ez a gyerek osztaly felelos az expediciohajo ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Expediciohajo extends Cellak{

    public Expediciohajo() {
        ertek=99;
        nev="hajo";
        jarhatoe=true;
        vanekincs=false;
        pihenhete=true;
        kijelzes="⛵";
    }

    /**
     * Ez a metodus felelos azert, hogy ha hajon vagyunk tudjunk pihenni. Megkerdezi a felhasznalot hogy szeretne-e pihenni.
     * Amennyiben igen, feltolti az energiajat 100-ra, amennyiben nem, nem valtozik semmi.
     */
    public static void pihenes(){
        if (Lepesenkent.hajoe()) {
            System.out.println("A hajón vagy. Szeretnél pihenni, hogy feltöltsd az energiád? i/n");
            Scanner sc = new Scanner(System.in);
            String pihenes = sc.nextLine();
            if (pihenes.equals("i")) {
                Felfedezo.energia = 100;
            } else if(pihenes.equals("n")){

            } else{
                System.out.println("NINCS ILYEN LEHETŐSÉG!");
                pihenes();
            }
        }
    }

    /**
     * Ez a metodus felelos az uj kuldetesre valo lepesert.
     * Amennyiben, nalunk van az aranypiramis, es a hajora lepunk lehetosegunk lesz eladni a kincseinkent es tovabb lepni a kovetkezo kuldetesre.
     * Bekeri a felhasznalotol szeretne e tovabb haladni, ha igen, akkor betoltodik az uj palya.
     * Lehetoseg lesz ujra tarsat valasztani, tovabba vasarolni kuldetes elott.
     */
    public static void ujszint() throws FileNotFoundException {
        if (Lepesenkent.hajoe()) {
            if (Inventory.vanenala("aranypiramis")) {
                while (Inventory.vanenala("kincs")){
                    Felfedezo.kincselad();
                }
                    System.out.println("Elhoztad az aranypiramist, gratulálok!");
                    System.out.println("Mostmár tovább léphetsz a következő szintre. Jutalmad: +1000 hírnév");
                    System.out.println("Szeretnél továbblépni? i/n");
                    Scanner sc2 = new Scanner(System.in);
                    String tovabblepes = sc2.nextLine();
                    if (tovabblepes.equals("i")) {
                        Inventory.torles("aranypiramis");
                        Felfedezo.hirnev += 1000;
                        Palya.kuldetesszam++;
                    } else if(tovabblepes.equals("n")){
                        Palya.mozgas();
                    }
                    else{
                        System.out.println("NINCS ILYEN LEHETŐSÉG!");
                        ujszint();
                    }
                    if (Felfedezo.kuldetes==6){
                        Lepesenkent.nyeres();
                    }
                    if (!Kezdes.sajate) {
                        switch (Palya.kuldetesszam) {
                            case 2:
                                Kezdes.palyanev = "alappalya2.txt";
                                break;
                            case 3:
                                Kezdes.palyanev = "alappalya3.txt";
                                break;
                            case 4:
                                Kezdes.palyanev = "alappalya4.txt";
                                break;
                            case 5:
                                Kezdes.palyanev = "alappalya5.txt";
                                break;
                        }
                    } else{
                        switch (Palya.kuldetesszam) {
                            case 2:
                                Kezdes.palyanev = "2"+Kezdes.palyanev.substring(1);
                                break;
                            case 3:
                                Kezdes.palyanev = "3"+Kezdes.palyanev.substring(1);
                                break;
                            case 4:
                                Kezdes.palyanev = "4"+Kezdes.palyanev.substring(1);
                                break;
                            case 5:
                                Kezdes.palyanev = "5"+Kezdes.palyanev.substring(1);
                                break;
                        }
                    }
                    Palya.latottak = new ArrayList<>();
                    System.out.println(Palya.kuldetesszam + ". KÜLDETÉS!");
                    Versenytars.vtarshirnev();
                    Kezdes.tarssorolas();
                    Felfedezo.vasarol();
                    Palya.palyabeolvas(); //beolvassuk az alap palyat
                    Palya.kijelzettpalya(); //palya kinezetenek atalakitasa
                    if (Tarsak.vaneilyen("bolcs")) {
                        System.out.println("Új küldetésbe kezdtél, a bölcs társad miatt kaptál +3 viszonyt!");
                        Felfedezo.viszony += 3;
                    }
                }
            }
        }
    }
