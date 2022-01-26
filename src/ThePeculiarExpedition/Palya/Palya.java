package ThePeculiarExpedition.Palya;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Kezdes.Kezdes;
import ThePeculiarExpedition.Menu.Menu;
import ThePeculiarExpedition.Palyacellak.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ez az osztaly felelos a palya beolvasasaert, atalkitasaert unicode karakterektre.
 * Tovabba itt talalhato meg a kiiro metodus, es a latoter lekezelese is.
 * @author Szerencsés Attila
 */
public class Palya {
    public static int[][] beolvasottpalya;
    public static Cellak[][] palya;
    public static int sorszam;
    public static int oszlopszam;
    public static int[] pozicio = {0,0};
    public static ArrayList<int[]> latottak= new ArrayList<>();
    public static boolean kovetkezojarhatoe=true;
    public static int kuldetesszam=1;

    /**
     * Ez a metodus felelos a palyabeolvasasaert. Amennyiben hibas sajat palyat kapott, az alappalyat olvassa be.
     * Eloszor beolvassa a fajl felso sorat, amiben a sor es oszlop szam talalhato, majd magat a palyat.
     * Ezt eltarolja egy int tomben. Kikeresi a jatekos kezdopozicjiojat is, ami a hajo lesz, es eltarolja.
     */
    public static void palyabeolvas() throws FileNotFoundException {
            try {
                Scanner sc = new Scanner(new File("src/ThePeculiarExpedition/Txtfajlok/" + Kezdes.palyanev));
            } catch (FileNotFoundException e) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("Az alap pálya fog betöltődni, mert nem megfelelő fájlt adtál meg!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Kezdes.palyanev = "alappalya1.txt";
                Kezdes.sajate=false;
            }
        Scanner sc = new Scanner(new File("src/ThePeculiarExpedition/Txtfajlok/"+Kezdes.palyanev));
        sorszam = sc.nextInt();
        oszlopszam = sc.nextInt();
        sc.nextLine();
        beolvasottpalya = new int[sorszam][oszlopszam];

        for (int i = 0; i < sorszam; i++) {
            for (int j = 0; j < oszlopszam ; j++) {
                beolvasottpalya[i][j] = sc.nextInt();
                if (beolvasottpalya[i][j]==99){
                    pozicio[0]=i;
                    pozicio[1]=j;
                }
            }
            sc.nextLine();
        }
    }

    /**
     * Ez a metodus felelos a tereptargyak peladnyositasaert.
     * Egy cellak tipusu tombben tarolja el, a peldanyositott tereptargyakat.
     * Ezaltal tudjuk elerni majd a kijelzett palyankant, mert minden targynak van egy unicode karaktere, amelyet igy eltudunk erni.
     */
    public static void kijelzettpalya(){
       palya = new Cellak[sorszam][oszlopszam];
        for (int i = 0; i < sorszam; i++) {
            for (int j = 0; j < oszlopszam ; j++) {
                // 1-fu, 2-tenger 3-to, 4-hegy, 5-barlang, 6-oltar, 7-dzsungel,8-vizestalaj 9-bozot 99-hajo, 98-falu 97-aranypiramis
                switch(beolvasottpalya[i][j]) {
                    case 1:
                        palya[i][j] = new Fu();
                        break;
                    case 2:
                        palya[i][j] = new Tenger();
                        break;
                    case 3:
                        palya[i][j] = new To();
                        break;
                    case 4:
                        palya[i][j] = new Hegy();
                        break;
                    case 5:
                        palya[i][j] = new Barlang();
                        break;
                    case 6:
                        palya[i][j] = new Oltar();
                        break;
                    case 7:
                        palya[i][j] = new Dzsungel();
                        break;
                    case 8:
                        palya[i][j] = new Vizestalaj();
                        break;
                    case 9:
                        palya[i][j] = new Bozot();
                        break;
                    case 99:
                        palya[i][j] = new Expediciohajo();
                        break;
                    case 98:
                        palya[i][j] = new Falu();
                        break;
                    case 97:
                        palya[i][j] = new Aranypiramis();
                        break;
                }
                latoterhozzaad();
        }

    }
    }

    /**
     * Ez a metodus felelos a palya kiirasaert. A palyat a latoternek megfeleloen irja ki.
     * Alaphelyzetben 1 a latokor, igy a melletunk levo cellakat irja ki csak.
     */
    public static void palyakiir() {
        for (int i = 0; i < sorszam; i++) {
            for (int j = 0; j < oszlopszam; j++) {
                boolean latjuke=false;
                if (pozicio[0] == i && pozicio[1] == j) {
                    System.out.print("\uD83E\uDDCD \t");
                } else {
                    for(int[] poz : latottak) {
                        if(i == poz[0] && j == poz[1]) {
                            System.out.print(palya[i][j].kijelzes + "\t");
                            latjuke = true;
                            break;
                        }
                    }
                    if(!latjuke) System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Ez a metodus felelos azert, hogy mindig hozza adja egy listahoz, a lathato palyacellak kordinatait.
     * A latoter fuggvenyeben(alaphelyzetben 1) tarolja el a latott cellakat, ezaltal tudjuk megfeleloen kijelezni a palyat.
     */
    public static void latoterhozzaad(){
            for(int i = 0; i <= Felfedezo.latokor; i++) {
                for (int j = 0; j <= Felfedezo.latokor; j++) {
                    latottak.add(new int[]{pozicio[0]+i, pozicio[1]+j});
                    latottak.add(new int[]{pozicio[0]-i, pozicio[1]-j});
                    latottak.add(new int[]{pozicio[0]+i, pozicio[1]-j});
                    latottak.add(new int[]{pozicio[0]-i, pozicio[1]+j});
            }
        }
    }

    /**
     * Ez a metodus felelos a mozgas megvalositasaert. Bekeri a felhasznalotol a mozgas iranyat, es ez alapjan fog mozogni a felfedezo.
     * Le kezeli a nem jarhato tereptargyakat is, tovabba a nem megfelelo inputokat.
     * Amennyiben wasd inputt helyett, a kilepes inputot kaplya, vissza dob a jatek a menube, ahol tudunk valasztani a kulonbozo tevekenysegek kozul.
     */
    public static void mozgas() throws FileNotFoundException {
        while (true) {
            System.out.println("Kérem add meg, hogy merre szeretnél haladni, wasd betűk segítségével.(w (előre), s (hátra), d (jobbra), a (balra), kilepes:ha szeretnél visszalépni a menübe)");
            Scanner sc = new Scanner(System.in);
            String irany = sc.nextLine();
            switch (irany) {
                case "w":
                    if (pozicio[0] - 1 >= 0 && palya[pozicio[0] - 1][pozicio[1]].jarhatoe) {
                        pozicio[0] = pozicio[0] - 1;
                        kovetkezojarhatoe = true;
                    } else {
                        System.out.println("!!NEM JÁRHATÓ!!");
                        kovetkezojarhatoe = false;
                        Palya.palyakiir();
                        mozgas();
                    }
                    break;
                case "s":
                    if (pozicio[0] + 1 < sorszam && palya[pozicio[0] + 1][pozicio[1]].jarhatoe) {
                        pozicio[0] = pozicio[0] + 1;
                        kovetkezojarhatoe = true;
                    } else {
                        System.out.println("!!NEM JÁRHATÓ!!");
                        kovetkezojarhatoe = false;
                        Palya.palyakiir();
                        mozgas();
                    }
                    break;
                case "d":
                    if (pozicio[1] + 1 < oszlopszam && palya[pozicio[0]][pozicio[1] + 1].jarhatoe) {
                        pozicio[1] = pozicio[1] + 1;
                        kovetkezojarhatoe = true;
                    } else {
                        System.out.println("!!NEM JÁRHATÓ!!");
                        kovetkezojarhatoe = false;
                        Palya.palyakiir();
                        mozgas();
                    }
                    break;
                case "a":
                    if (pozicio[1] - 1 >= 0 && palya[pozicio[0]][pozicio[1] - 1].jarhatoe) {
                        pozicio[1] = pozicio[1] - 1;
                        kovetkezojarhatoe = true;
                    } else {
                        System.out.println("!!NEM JÁRHATÓ!!");
                        kovetkezojarhatoe = false;
                        Palya.palyakiir();
                        mozgas();
                    }
                    break;
                case "kilepes":
                    Menu.menu();
                    break;
                default:
                    System.out.println("NINCS ILYEN LEHETŐSÉG!");
                    mozgas();
                    break;
            }
            latoterhozzaad();
            Lepesenkent.adatkiir();
            Lepesenkent.ellenoriz();
            Palya.palyakiir(); //palya folyamatos kiiras
            if (Lepesenkent.fuggosege()){
                Felfedezo.fuggoseglepes++;
            }
        }
    }

}
