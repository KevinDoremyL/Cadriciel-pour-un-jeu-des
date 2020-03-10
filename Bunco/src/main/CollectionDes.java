import java.util.ArrayList;

public class CollectionDes implements ICollection<De> {

    private De[] tableauDe;

    public CollectionDes(int nbDes) {

        tableauDe = new De[nbDes];
    }

    @Override
    public Iterateur getIterateur() {
        return new IterateurDe() {
        };
    }

    class IterateurDe implements Iterateur<De> {
        private int index=0;
        @Override
        public void reset() {
            this.index=0;

        }

        @Override
        public De next() {

            if(this.hasNext()){
                return tableauDe[index++];
            }
            return null;
        }

        @Override
        public De currentItem() {
            return tableauDe[index];
        }

        @Override
        public boolean hasNext() {

            if(index < tableauDe.length){
                return true;
            }
            return false;
        }

    }
}