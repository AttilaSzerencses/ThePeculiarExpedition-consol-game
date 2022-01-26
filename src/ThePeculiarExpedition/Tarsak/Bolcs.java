package ThePeculiarExpedition.Tarsak;

import ThePeculiarExpedition.Kezdes.Felfedezo;

/**
 * Ez a gyerek osztaly felelos a Bolcs tars hozaadasaert, tovabba a tars elonyenek implementalasahoz.
 * @author Szerencsés Attila
 */
public class Bolcs extends Tarsak{
    public Bolcs() {
        Felfedezo.csapattarsak.add(this);
        Felfedezo.viszony+=3;
    }
}
