import java.util.ArrayList;

public class CollectionDes implements ICollection<De> {

    private ArrayList<De> listeDes;

    public CollectionDes(int nbDes) {

        listeDes = new ArrayList<De>(nbDes);

    }

    @Override
    public Iterateur<De> getIterateur() {
        return new IterateurDe();
    }

    public ArrayList<De> getListeDes() {
        return listeDes;
    }

    public void ajouterDe(De de){
        this.listeDes.add(de);
    }

    class IterateurDe implements Iterateur<De> {

        private int index=0;

        @Override
        public void reset() {
            this.index=0;

        }

        @Override
        public De next() {
            De nextDe = null;

            if(this.hasNext()){
                nextDe = listeDes.get(index++);
                this.index++;
                return nextDe;
            }
            return null;
        }

        @Override
        public De currentItem() {
            return listeDes.get(index);
        }

        public int getIndex() {
            return index;
        }

        @Override
        public boolean hasNext() {

            if(index < listeDes.size()){
                return true;
            }
            return false;
        }

    }


}