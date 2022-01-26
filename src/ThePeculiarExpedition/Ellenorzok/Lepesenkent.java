package ThePeculiarExpedition.Ellenorzok;

import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Inventory.Slot;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Kezdes.Kezdes;
import ThePeculiarExpedition.Palya.Palya;
import ThePeculiarExpedition.Palyacellak.*;
import ThePeculiarExpedition.Tarsak.Kereskedo;
import ThePeculiarExpedition.Tarsak.Tarsak;
import ThePeculiarExpedition.Versenytarsak.Versenytars;


import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

/**
 * Ez az osztaly a jatek folyaman ellenoriz, illetve adatot kozol minden lepesnel.
 * Palyacellakat, mozgaskoltsegeket, fuggosegeket, kiesesi lehetoseget ellenoriz, tovabba kiirja a jatekos jelenlegi adatait.
 * @author Szerencsés Attila
 */

public class Lepesenkent {

    /**
     * Ez a metodus felelos a jatekos jelenlegi adatainak kiirasaert. Osszefoglalja a kiirasokat.
     * Kiirja a jatekos inventory tartalmat, tarsait, aranyat, energiajat.
     */
    public static void adatkiir(){
        System.out.println("--------------------------------");
        Inventory.inventorykiir();
        Felfedezo.tarsakkiir();
        Felfedezo.aranykiir();
        Felfedezo.energiakiir();
        System.out.println("--------------------------------");
    }

    /**
     * Ez a metodus felelos a jatekos mozgaskoltsogenek ellenorzeseert.
     * Osszefoglalja a mozgaskoltseget szamolo metodusokat.
     */
    public static void mozgaskoltseg(){

        Tarsak.tarsakmozgas();
        Dzsungel.dzsungelmozgas();
        Inventory.inventorymozgas();
    }

    /**
     * Ez a metodus ellenorzi, hogy a jelenlegi palyacella expedicios hajo-e.
     * @return igazzal, vagy hamissal tér vissza, annak fugvenyeben hogy a megvizsgalt palyacella hajo-e.
     */
    public static boolean hajoe(){
        if (Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].nev.equals("hajo")) {
            return true;
        }
        return false;
    }

    /**
     * Ez a metodus ellenorzi, hogy a jelenlegi palyacella falu-e.
     * @return igazzal, vagy hamissal tér vissza, annak fugvenyeben hogy a megvizsgalt palyacella falu-e.
     */
    public static boolean falue(){
        if (Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].nev.equals("falu")){
            return true;
        }
        return false;
    }

    /**
     * Ez a metodus ellenorzi, hogy a jelenlegi palyacella barlang-e.
     * @return igazzal, vagy hamissal tér vissza, annak fugvenyeben hogy a megvizsgalt palyacella barlang-e.
     */
    public static boolean barlange(){
        if (Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].nev.equals("barlang")){
            return true;
        }
        return false;
    }

    /**
     * Ez a metodus ellenorzi, hogy a jelenlegi palyacella oltar-e.
     * @return igazzal, vagy hamissal tér vissza, annak fugvenyeben hogy a megvizsgalt palyacella oltar-e.
     */
    public static boolean oltare(){
        if (Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].nev.equals("oltar")) {
            return true;
        }
        return false;
    }

    /**
     * Ez a metodus ellenorzi, hogy a jelenlegi palyacella arany piramis-e, továbbá informaciot kozol a jatekos fele, hozzadja az inventoryhoz a targyat.
     */
    public static void aranype(){
        if (Palya.palya[Palya.pozicio[0]][Palya.pozicio[1]].nev.equals("aranypiramis")){
            if (Palya.kuldetesszam==Felfedezo.kuldetes) {
                System.out.println("GRATULÁLOK, MEGTALÁLTAD AZ ARANY PIRAMIST!!");
                System.out.println("Eldöntheted, hogy folytatod a kalandozást, vagy visszamész a hajóhoz.");
                System.out.println("Ha visszamész a hajóhoz, elkezdheted az új küldetésed, az aranypiramis leadásával!");
                Inventory.inventory.add(new Slot());
                Inventory.inventory.get(Inventory.inventory.size()-1).hozzaad("aranypiramis");
                Felfedezo.kuldetes++;
            }
        }
    }

    /**
     * Ez a metodus felelos a jatekos energia elfogyasanak kezeleseert.
     * Ha elfogyott az energiaja, lepesenkent 8% eselyel elvesziti egy tarsat, ha nincs tarsa. A jatekos es a tarsak kiesesert felel.
     */
    public static void energianull(){
        if (Felfedezo.energia==0){
            Random szam = new Random();
            int random = szam.nextInt(100) + 1;
            if (random<=8){
                if (Felfedezo.csapattarsak.size()!=0){
                    System.out.println("Sajnos elveszítetted a társad, mert elfogyott az energiád!");
                    System.out.println("VIGYÁZZ, MERT TE IS KI ESHETSZ, HA NEM TÖLTÖD VISSZA AZ ENERGIÁD!");
                    for (int i = 0; i < Felfedezo.csapattarsak.size() ; i++) {
                        switch (Felfedezo.csapattarsak.get(i).nev) {
                            case "kereskedo":
                                for (int j = 0; j < Felfedezo.csapattarsak.size(); j++) {
                                    if (Felfedezo.csapattarsak.get(j).nev.equals("kereskedo")){
                                        Felfedezo.csapattarsak.remove(j);
                                    }
                                }
                                break;
                            case "katona":
                                for (int j = 0; j < Felfedezo.csapattarsak.size(); j++) {
                                    if (Felfedezo.csapattarsak.get(j).nev.equals("katona")){
                                        Felfedezo.csapattarsak.remove(j);
                                    }
                                }
                                break;
                            case "szamar":
                                for (int j = 0; j < Felfedezo.csapattarsak.size(); j++) {
                                    if (Felfedezo.csapattarsak.get(j).nev.equals("szamar")){
                                        Felfedezo.csapattarsak.remove(j);
                                    }
                                }
                                break;
                            case "felderito":
                                for (int j = 0; j < Felfedezo.csapattarsak.size(); j++) {
                                    if (Felfedezo.csapattarsak.get(j).nev.equals("felderito")) {
                                        Felfedezo.csapattarsak.remove(j);
                                    }
                                }
                                break;
                            case "saman":
                                for (int j = 0; j < Felfedezo.csapattarsak.size(); j++) {
                                    if (Felfedezo.csapattarsak.get(j).nev.equals("saman")) {
                                        Felfedezo.csapattarsak.remove(j);
                                    }
                                }
                                break;
                            case "bolcs":
                                for (int j = 0; j < Felfedezo.csapattarsak.size(); j++) {
                                    if (Felfedezo.csapattarsak.get(j).nev.equals("bolcs")) {
                                        Felfedezo.csapattarsak.remove(j);
                                    }
                                }
                                break;
                        }
                    }
                } else{
                    System.out.println("Nincsenek társaid, és energiád sem, ezért kiestél.");
                    System.out.println("Sajnos elvesztetted a játékot.");
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Ez a metodus ellenorzi, hogy a felfedezonk jelenlegi fuggoseget. (kabitoszer,whiskey)
     * @return Igazzal ter vissza, ha a jatekos fuggo, hamissal pedig ha nem fuggo.
     */
    public static boolean fuggosege(){
        if (!Felfedezo.fuggoseg[0].equals("csokolade") && !Felfedezo.fuggoseg[0].equals(" ") && Felfedezo.fuggoseg[0].equals(Felfedezo.fuggoseg[1])){
            return true;
        }
        return false;
    }

    /**
     * Ez a metodus ellenorzi, hogy a jelenlegi palyacella falu-e.
     * @return igazzal, vagy hamissal tér vissza, annak fugvenyeben hogy a megvizsgalt palyacella falu-e.
     */
    public static void fuggosegkieses(){
        if (Felfedezo.fuggoseglepes>30) {
            Random szam2 = new Random();
            int random2 = szam2.nextInt(100) + 1;
            if (random2 <= 10) {
                System.out.println("Nem fogyasztottál a kiváltó élelmiszerből.");
                System.out.println("A függőséged miatt, sajnos meghaltál, így elvesztetted a játékot.");
                System.exit(0);
            }
        }
    }

    /**
     * Ez a metodus felelos a jatek vegen torteno nyeresert/vesztesert.
     * Ellenorzi, hogy az utolso kuldetesnel jarunk, es ellenorzi, hogy nagyobb-e a hirnevunk, mint a tobbi elenfelnek.
     */
    public static void nyeres(){
        Versenytars.versenytarshnkiir();
        for (int i = 0; i < Kezdes.versenythirnev.length; i++) {
            if (Kezdes.versenythirnev[i]>Felfedezo.hirnev){
                System.out.println(i+". Ellenfél nyert. Sajnos te veszítettél.");
                System.out.println("A te hírneved: "+Felfedezo.hirnev+", ellenfeled hírneve pedig: "+Kezdes.versenythirnev[i]);
                System.exit(0);
            } else{
                Versenytars.versenytarshnkiir();
                System.out.println("Te hírneved: "+Felfedezo.hirnev);
                System.out.println("Te nyertél! Az összes ellenfelednél több hírnevet szereztél! GRATULÁLOK!");
                System.exit(0);
            }
        }
    }

    /**
     * Ez a metodus felelos a fenti metodusok osszegzeseert, tovabba ellenorzi, a kovetkezo palyacella jarhatosagat.
     */
    public static void ellenoriz() throws FileNotFoundException {
        if (Palya.kovetkezojarhatoe) {
            mozgaskoltseg();
            if (Felfedezo.energia-Felfedezo.mozgas<0){
                Felfedezo.energia=0;
            } else{
                Felfedezo.energia -= Felfedezo.mozgas;
            }
            Felfedezo.mozgas = 1;
        }
        Expediciohajo.pihenes();
        Expediciohajo.ujszint();
        Falu.falutars();
        Falu.faluvasarlas();
        Barlang.barlangon();
        Oltar.oltaron();
        aranype();
        energianull();
        fuggosege();
        fuggosegkieses();
    }



}
