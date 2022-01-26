package ThePeculiarExpedition.Inventory;

import ThePeculiarExpedition.Kezdes.Felfedezo;

import java.util.ArrayList;

/**
 * Ez az osztaly felelos az inventory megvalositasaert.
 * @author Szerencsés Attila
 */

public class Inventory {
    public static ArrayList<Slot> inventory = new ArrayList<>();

    public Inventory() {
        inventory.add(new Slot());
    }

    /**
     * Ez a metodus megvizsgalja, hogy a parameterben kapott targy szerepel-e a felfedezo inventory-ba.
     * @param targy Parameterben egy targy nevet var, amit ellenorizni fog, hogy benne van-e az inventoryba.
     * @return Igazzal ter vissza ha benne van, hamissal pedig ha nincs az inventoryba.
     */
    public static boolean vanenala(String targy){
        if (inventory!=null) {
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).slot.get(0).equals(targy)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Ez a metodus felelos az inventoryhoz tartozo mozgaskoltseg szamolasert.
     * Ha tobb targy van a felfedezonel, mint amennyi slottal rendelkezik, targyankent 20%-al no a mozgaskoltseg.
     */
    public static void inventorymozgas(){
        if (inventory!=null) {
            if (inventory.size() > Felfedezo.slotszam) {
                int kulonbseg = inventory.size() - Felfedezo.slotszam;
                for (int i = 0; i < kulonbseg; i++) {
                    Felfedezo.mozgas *= 1.2;
                }
            }
        }
    }

    /**
     * Ez a metodus felelos az inventorybol valo targy torleseert.
     * @param targy Parameterben egy targy nevet var, amit ki fog torolni az inventorybol.
     */
    public static void torles(String targy){
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).slot.get(0).equals(targy)){
                inventory.get(i).torol();
                if (inventory.get(i).slot.size()==0){
                    inventory.remove(i);
                }
            }
        }
    }

    /**
     * Ez a metodus felelos az inventory kiirasaert a konzolra. Kiirja a felfedo targyait.
     */
    public static void inventorykiir(){
        System.out.print("Az inventoryd tartalma: ");
        if (Inventory.inventory!=null) {
            for (int i = 0; i < Inventory.inventory.size(); i++) {
                System.out.print(Inventory.inventory.get(i).slot + ", ");
            }
        } else{
            System.out.print("Üres");
        }
        System.out.println();
    }

}
