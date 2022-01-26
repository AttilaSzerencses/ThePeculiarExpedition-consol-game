package ThePeculiarExpedition.Tarsak;

import ThePeculiarExpedition.Kezdes.Felfedezo;

/**
 * Ez az osztaly felelos a tarsak oszefuzesere.
 * Tovabba a tarsakhoz kapcsolodo metodusok megvalositasara.
 * @author Szerencsés Attila
 */
public class Tarsak {
    public String nev = "";
    /**
     * Ez a metodus felel a mozgaskoltseg kiszamitasaert. Minden +tars 15%-al noveli a mozgaskoltseget.
     */
    public static void tarsakmozgas(){
        if(Felfedezo.csapattarsak!=null){
            if (Felfedezo.csapattarsak.size()>0) {
                for (int i = 0; i < Felfedezo.csapattarsak.size(); i++) {
                    Felfedezo.mozgas *= 1.15;
                }
            }
        }
    }

    /**
     * Ez a metodus ellenorzi, hogy van e a felfedezonek a parameterben megadott tarsa.
     * @param nev Egy tars nevet varja parameterben, ezt fogja ellenorizni, hogy rendelkezik e vele.
     * @return Igazzal ter vissza, ha rendelkezik a felfedezo a megadott tarsal, hamissal, ha nem.
     */
    public static boolean vaneilyen(String nev){
        for (int i = 0; i < Felfedezo.csapattarsak.size(); i++) {
            if (Felfedezo.csapattarsak.get(i).nev.equals(nev)){
                return true;
            }
        }
        return false;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}
