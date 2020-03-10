package src.main;

public class IterateurDe implements Iterateur<De> {
    private int index;
    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }

    @Override
    public De next() {
        // TODO Auto-generated method stub
        // return liste.get(index++)
        return null;
    }

    @Override
    public De currentItem() {
        // TODO Auto-generated method stub
        // return liste.get(index)
        return null;
    }

    @Override
    public boolean hasNext() {
        /*
        if(index < TailleDeLaListe){
            return true;
        }
        */

        return false;
    }

}
