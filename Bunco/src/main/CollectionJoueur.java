import java.util.ArrayList;

public class CollectionJoueur implements ICollection<Joueur> {

    private ArrayList<Joueur> listeJoueurs;

    public CollectionJoueur(int nbJoueurs) {
        listeJoueurs = new ArrayList<Joueur>(nbJoueurs);

    }

    public void ajouterJoueur(Joueur joueur){
        this.listeJoueurs.add(joueur);
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
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

            if(index < listeJoueurs.size()) {
                return true;
            }
            return false;
        }

    }

}