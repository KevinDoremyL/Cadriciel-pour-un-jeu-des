public class Joueur implements Comparable<Joueur> {

    private String nomJoueur;
    private int scoreJoueur;
    private static int numeroJoueur = 1;

    public Joueur(){
        this.nomJoueur = "Joueur"+numeroJoueur;
        numeroJoueur++;
    }

    public Joueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
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
        return Integer.compare(this.getScoreJoueur(), o.getScoreJoueur());
    }
}