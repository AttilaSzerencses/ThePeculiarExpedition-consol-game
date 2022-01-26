package ThePeculiarExpedition.Tarsak;

import ThePeculiarExpedition.Kezdes.Felfedezo;

/**
 * Ez a gyerek osztaly felelos a Kereskedo tars hozaadasaert, tovabba a tars elonyenek implementalasahoz.
 * @author Szerencsés Attila
 */
public class Kereskedo extends Tarsak{
    public Kereskedo() {
        Felfedezo.csapattarsak.add(this);
    }

}
