package ThePeculiarExpedition.Palyacellak;

/**
 * Ez a gyerek osztaly felelos az hegy ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Hegy extends Cellak{

    public Hegy() {
        ertek=4;
        nev="hegy";
        jarhatoe=false;
        vanekincs=false;
        pihenhete=false;
        kijelzes="\uD83C\uDF04";
    }
}
