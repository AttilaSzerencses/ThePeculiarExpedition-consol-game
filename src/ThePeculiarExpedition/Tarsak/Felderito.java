package ThePeculiarExpedition.Tarsak;

import ThePeculiarExpedition.Kezdes.Felfedezo;

/**
 * Ez a gyerek osztaly felelos a Felderito tars hozaadasaert, tovabba a tars elonyenek implementalasahoz.
 * @author Szerencsés Attila
 */
public class Felderito extends Tarsak{
    public Felderito() {
        Felfedezo.csapattarsak.add(this);
        Felfedezo.latokor+=1;
    }

}
