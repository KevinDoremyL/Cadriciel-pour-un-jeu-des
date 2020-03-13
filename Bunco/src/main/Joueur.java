public class Joueur implements Comparable<Joueur> {
    String nom;
    int score;
    public Joueur() {

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