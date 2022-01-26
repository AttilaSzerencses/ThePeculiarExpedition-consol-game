package ThePeculiarExpedition.Tarsak;

import ThePeculiarExpedition.Kezdes.Felfedezo;

/**
 * Ez a gyerek osztaly felelos a Katona tars hozaadasaert, tovabba a tars elonyenek implementalasahoz.
 * @author Szerencsés Attila
 */
public class Katona extends Tarsak{
    public Katona() {
        Felfedezo.csapattarsak.add(this);
    }

}
