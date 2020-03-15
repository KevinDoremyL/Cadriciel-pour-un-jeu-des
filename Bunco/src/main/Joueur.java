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
        numeroJoueur++;
    }

    public Joueur(String nomJoueur, int scoreJoueur) {
        this.nomJoueur = nomJoueur;
        this.scoreJoueur = scoreJoueur;
        numeroJoueur++;
    }

    public String getNom() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public int getScore() {
        return scoreJoueur;
    }

    public void setScore(int scoreJoueur) {
        this.scoreJoueur = scoreJoueur;
    }
    public void ajouterScore(int scoreAjouteur){
        this.scoreJoueur+= scoreAjouteur;
    }

    @Override
    public int compareTo(Joueur o) {
        return Integer.compare(this.getScore(), o.getScore());
    }

}