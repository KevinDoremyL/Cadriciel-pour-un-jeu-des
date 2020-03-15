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

    @Override
    public int compareTo(Joueur o) {

      return Integer.compare(this.getScore(),o.getScore());
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