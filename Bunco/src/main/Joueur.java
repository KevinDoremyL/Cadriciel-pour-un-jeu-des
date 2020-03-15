public class Joueur implements Comparable<Joueur> {
    String nom;
    int score;

    public String getNom() {
        return nom;
    }

    public Joueur(String nom) {
        this.nom=nom;
        this.score=0;
    }
    public Joueur(String nom, int score) {
        this.nom=nom;
        this.score=0;
    }

    @Override
    public int compareTo(Joueur o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public  void additionerScore(int addition){
        this.score += addition;
    }

    public int getScore() {
        return score;
    }
}