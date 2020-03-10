import java.util.ArrayList;

public class CollectionJoueur implements ICollection<Joueur> {

    private Joueur[] tableauJoueur;

    public CollectionJoueur(int nbJoueurs) {
        tableauJoueur = new Joueur[nbJoueurs];
    }


    @Override
    public Iterateur<Jouegit ur> getIterateur() {
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
                return tableauJoueur[index++];
            }
            return null;
        }

        @Override
        public Joueur currentItem() {
            return tableauJoueur[index];
        }

        @Override
        public boolean hasNext() {

            if(index < tableauJoueur.length) {
                return true;
            }
            return false;
        }

    }

}