import java.util.ArrayList;

public class CollectionJoueur implements ICollection<Joueur> {
    public ArrayList<Joueur> listeJoueur;
    public CollectionJoueur(ArrayList<Joueur>listeJoueur) {
       this.listeJoueur = listeJoueur;
    }


    @Override
    public Iterateur getIterateur() {
       return new IterateurJoueur();
    }

    class IterateurJoueur implements Iterateur<Joueur> {
        private int index=0;
        @Override
        public void reset() {
            this.index=0;

        }

        @Override
        public Joueur next() {

            if(this.hasNext()){
                return listeJoueur.get(index++);
            }
            return null;
        }

        @Override
        public Joueur currentItem() {
            return listeJoueur.get(index);
        }

        @Override
        public boolean hasNext() {

            if(index < listeJoueur.size()){
                return true;
            }
            return false;
        }

    }

}