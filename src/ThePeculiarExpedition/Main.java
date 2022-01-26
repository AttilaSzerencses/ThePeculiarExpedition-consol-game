package ThePeculiarExpedition;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Kezdes.Felfedezo;
import ThePeculiarExpedition.Menu.Menu;
import ThePeculiarExpedition.Palya.Palya;
import ThePeculiarExpedition.Kezdes.Kezdes;
import ThePeculiarExpedition.Versenytarsak.Versenytars;

import java.io.IOException;

/**
 * Ez az osztály felel a jatek futattasaert.
 * Itt hivodik meg az osszes metodus sorba, amelyekre szukseg van a jatek mukodesehez.
 * @author Szerencsés Attila
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Kezdes.startszoveg();
        Kezdes.palyavalasztas();
        Kezdes.palyabeker();
        Kezdes.ellenfelbeker();
        Versenytars.vtarshirnev();
        Lepesenkent.adatkiir(); //Első adat kiírás, társ választás előtt
        Kezdes.tarssorolas(); // Küldetés előtti társválasztás
        Felfedezo.vasarol();
        Palya.palyabeolvas(); //beolvassuk az alap palyat
        Palya.kijelzettpalya(); //palya kinezetenek atalakitasa
        Palya.palyakiir(); //palya elso kiirasa
        while (true){
            Menu.menu(); //folyamatosan meghívom a menüt
        }


    }

}
