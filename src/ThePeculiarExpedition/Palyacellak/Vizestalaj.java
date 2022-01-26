package ThePeculiarExpedition.Palyacellak;

/**
 * Ez a gyerek osztaly felelos a vizestalaj ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Vizestalaj extends Cellak{

    public Vizestalaj() {
        ertek=8;
        nev="Vizestalaj";
        jarhatoe=true;
        vanekincs=false;
        pihenhete=false;
        kijelzes="▩";
    }
}
