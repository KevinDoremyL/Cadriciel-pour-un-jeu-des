import java.util.ArrayList;

public class CollectionJoueur implements ICollection<Joueur> {

    private ArrayList<Joueur> listeJoueurs;

    public CollectionJoueur(int nbJoueurs) {
        listeJoueurs = new ArrayList<Joueur>(nbJoueurs);
    }

    class IterateurJoueur implements Iterateur<Joueur> {
        private int index = 0;

        @Override
        public void reset() {
            this.index = 0;

        }

        @Override
        public Joueur next() {

            if (this.hasNext()) {
                return listeJoueurs.get(index++);
            }
            return null;
        }

        @Override
        public Joueur currentItem() {
            return listeJoueurs.get(index);
        }

        @Override
        public boolean hasNext() {

            if (index < listeJoueurs.size()) {
                return true;
            }
            return false;
        }

    }

    @Override
    public Iterateur<Joueur> iterateur() {
        // TODO Auto-generated method stub
        return null;
    }
}