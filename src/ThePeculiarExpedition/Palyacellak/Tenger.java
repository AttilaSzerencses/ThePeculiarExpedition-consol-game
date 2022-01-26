package ThePeculiarExpedition.Palyacellak;

/**
 * Ez a gyerek osztaly felelos az tenger ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Tenger extends Cellak{
    public Tenger() {
        ertek=2;
        nev="tenger";
        jarhatoe=false;
        vanekincs=false;
        pihenhete=false;
        kijelzes="\uD83C\uDF0A";
    }
}
