package ThePeculiarExpedition.Inventory;

import java.util.ArrayList;

/**
 * Ez az osztaly felelos az inventoryban talalhato slotok megvalositasaert.
 * @author Szerencsés Attila
 */
public class Slot {

    public ArrayList<String> slot = new ArrayList<>();

    /**
     * Ez a metodus felelos egy uj slot letrehozasaert, amin a parameterben kapott targyat kapjuk.
     * @param targy Parameterben egy targy nevet var, amit hozzad az adott slothoz(noveli a targyak szamat a sloton),
     *              amennyiben rendelkezik az adott targyal, ha nem uj slotra hozza letre.
     * @return Igazzal ter vissza ha van mar olyan slot, amely a parameterben kapott targyat tartalmazza. Ellenkezo esetben hamissal.
     */
    public boolean hozzaad(String targy) {
        if (!targy.equals("kincs")) {
            if (slot.size() == 0) {
                slot.add(targy);
                return true;
            }
            if (slot.size() >= 7) {
                return false;
            }
            if (!slot.get(0).equals(targy)) {
                return false;
            }
            slot.add(targy);
            return true;
        } else {
            if (slot.size() == 0){
                slot.add(targy);
                return true;
            }
        }
       return false;
    }

    /**
     * Ez a metodus felelos az adott sloton levo targyak szamanak csokkentessert.
     */
    public void torol(){
        slot.remove(slot.size()-1);
    }



}
