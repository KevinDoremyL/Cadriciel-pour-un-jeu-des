import java.lang.reflect.Array;
import java.util.ArrayList;

public class CollectionDes implements ICollection<De> {
    private ArrayList<De> listeDe;
    public CollectionDes(ArrayList<De> listeDe) {
    this.listeDe = listeDe;
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
                return listeDe.get(index++);
            }
            return null;
        }

        @Override
        public De currentItem() {
          return listeDe.get(index);
        }

        @Override
        public boolean hasNext() {
        
        if(index < listeDe.size()){
            return true;
        }
            return false;
        }

    }

}