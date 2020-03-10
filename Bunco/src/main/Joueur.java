public class Joueur implements Comparable<Joueur> {

    private String nomJoueur;
    private int scoreJoueur;

    public Joueur() {

    }

    public Joueur(String nomJoueur, int scoreJoueur) {
        this.nomJoueur = nomJoueur;
        this.scoreJoueur = scoreJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public int getScoreJoueur() {
        return scoreJoueur;
    }

    public void setScoreJoueur(int scoreJoueur) {
        this.scoreJoueur = scoreJoueur;
    }

    @Override
    public int compareTo(Joueur o) {
        // TODO Auto-generated method stub
        return 0;
    }
}