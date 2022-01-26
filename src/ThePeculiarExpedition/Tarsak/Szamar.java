package ThePeculiarExpedition.Tarsak;

import ThePeculiarExpedition.Kezdes.Felfedezo;

/**
 * Ez a gyerek osztaly felelos a Szamar tars hozaadasaert, tovabba a tars elonyenek implementalasahoz.
 * @author Szerencsés Attila
 */
public class Szamar extends Tarsak{
    public Szamar() {
        Felfedezo.csapattarsak.add(this);
        Felfedezo.slotszam+=2;
    }

}
