import java.util.ArrayList;

public class CollectionDes implements ICollection<De> {
    private int nbDes;
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
                return tableauDe.get(index++);
            }
            return null;
        }

        @Override
        public De currentItem() {
            return listeDe.get(index);
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