package ThePeculiarExpedition.Versenytarsak;

import ThePeculiarExpedition.Kezdes.Kezdes;
import ThePeculiarExpedition.Palya.Palya;

import java.util.Random;

public class Versenytars {

    /**
     * Ez a metodus felel a versenytarsak hirnevenek generelasaert.
     * Minden kuldetes elott egy veletlenszeru ertekkel noveli a versenytarsak hirnevet, akik ellen versenyez a felhasznalo.
     * Minden versenytarsnak mashogy no a hirneve.
     */
    public static void vtarshirnev() {
        if (Palya.kuldetesszam==1){
            for (int i = 0; i < Kezdes.ellenfeldb; i++) {
                Kezdes.versenythirnev[i]=0;
                System.out.println((i + 1) + ". Hirneve: " + Kezdes.versenythirnev[i]);
            }
        } else {
            Random szam = new Random();
            switch (Kezdes.ellenfeldb) {
                case 1:
                    for (int i = 0; i < Kezdes.ellenfeldb; i++) {
                        int random = szam.nextInt(220) + 900;
                        Kezdes.versenythirnev[i] += random;
                        System.out.println((i + 1) + ". Hirneve: " + Kezdes.versenythirnev[i]);
                    }
                    break;
                case 2:
                    for (int i = 0; i < Kezdes.ellenfeldb; i++) {
                        int random = szam.nextInt(350) + 800;
                        Kezdes.versenythirnev[i] += random;
                        System.out.println((i + 1) + ". Hirneve: " + Kezdes.versenythirnev[i]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < Kezdes.ellenfeldb; i++) {
                        int random = szam.nextInt(400) + 750;
                        Kezdes.versenythirnev[i] += random;
                        System.out.println((i + 1) + ". Hirneve: " + Kezdes.versenythirnev[i]);
                    }
                    break;
                case 4:
                    for (int i = 0; i < Kezdes.ellenfeldb; i++) {
                        int random = szam.nextInt(300) + 800;
                        Kezdes.versenythirnev[i] += random;
                        System.out.println((i + 1) + ". Hirneve: " + Kezdes.versenythirnev[i]);
                    }
                    break;
                case 5:
                    for (int i = 0; i < Kezdes.ellenfeldb; i++) {
                        int random = szam.nextInt(150) + 850;
                        Kezdes.versenythirnev[i] += random;
                        System.out.println((i + 1) + ". Hirneve: " + Kezdes.versenythirnev[i]);
                    }
                    break;
            }
        }

    }

    /**
     * Ez a metodus felel a versenytarsak hirnevenek kiiratasaert.
     * Attol fuggoen hany darab ellenfelet valasztottunk az elejen, egyesevel kiirja a hirnevuket.
     */
    public static void versenytarshnkiir(){
        for (int i = 0; i < Kezdes.ellenfeldb; i++) {
            System.out.println(i+". versenytárs hírneve: "+Kezdes.versenythirnev[i]);
        }
    }


}
