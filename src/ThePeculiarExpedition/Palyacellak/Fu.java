package ThePeculiarExpedition.Palyacellak;

/**
 * Ez a gyerek osztaly felelos az fu ertekeinek eltarolasaert.(ertek,nev,jarhate a terep, van-e kincs rajta, pihenhet-e rajta, kijelzes)
 * @author Szerencsés Attila
 */
public class Fu extends Cellak{
    public Fu() {
        ertek=1;
        nev="fu";
        jarhatoe=true;
        vanekincs=false;
        pihenhete=false;
        kijelzes= "⬜";
    }
}
