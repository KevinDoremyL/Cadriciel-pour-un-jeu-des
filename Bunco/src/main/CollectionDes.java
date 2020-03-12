import java.util.ArrayList;

public class CollectionDes implements ICollection<De> {

    private ArrayList<De> listeDes;

    public CollectionDes(int nbDes) {

        listeDes = new ArrayList<>(nbDes);
    }

    class IterateurDe implements Iterateur<De> {
        private int index = 0;

        @Override
        public void reset() {
            this.index = 0;

        }

        @Override
        public De next() {

            if (this.hasNext()) {
                return listeDes.get(index++);
            }
            return null;
        }

        @Override
        public De currentItem() {
            return listeDes.get(index);
        }

        @Override
        public boolean hasNext() {

            if (index < listeDes.size()) {
                return true;
            }
            return false;
        }

    }

    @Override
    public Iterateur<De> iterateur() {
        // TODO Auto-generated method stub
        return null;
    }
}