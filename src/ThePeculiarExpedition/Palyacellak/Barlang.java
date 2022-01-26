package ThePeculiarExpedition.Palyacellak;

import ThePeculiarExpedition.Ellenorzok.Lepesenkent;
import ThePeculiarExpedition.Inventory.Inventory;
import ThePeculiarExpedition.Inventory.Slot;

import java.util.Random;

/**
 * Ez a gyerek osztaly felelos az barlang ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Barlang extends Cellak {

    public Barlang() {
        ertek=5;
        nev="barlang";
        jarhatoe=true;
        vanekincs=false;
        pihenhete=false;
        kijelzes="\uD83E\uDD87";
    }
    /**
     * Ez a metodus felelos azert, hogy a barlang cellan levo torteneseket megvalositsa.
     * Ha barlanc palyacellan vagyunk, ellenorzi, hogy van e nallnuk faklya. Amennyiben igen, akkor ezt törli az inventorybol, és kiir a felhasznalo fele.
     * Ezzel megelozzuk a katasztrofat.
     * Amennyiben nincs, 65% eselyel katasztrofa kovetkezik be. Ezt kozli a felhasznaloval.
     * Tovabba barlanban mindig talalunk kincset, ezt hozza adja az inventorynkhoz.
     */
    public static void barlangon(){
        if (Lepesenkent.barlange()){
            if (Inventory.vanenala("faklya")){
                System.out.println("Van fáklyád, ezt elhasználva megelőzted a katasztrófát!");
                Inventory.torles("faklya");
            } else{
                Random szam = new Random();
                int random = szam.nextInt(100) + 1;
                if (random<=65){
                    System.out.println("Nincs fáklyád, ezért katasztrófa ért!");
                }
            }
            System.out.println("Kincset találtál!");
            Inventory.inventory.add(new Slot());
            Inventory.inventory.get(Inventory.inventory.size()-1).hozzaad("kincs");
        }
    }

}
