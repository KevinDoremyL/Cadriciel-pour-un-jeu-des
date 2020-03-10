public class Joueur implements Comparable<Joueur> {
    private String nom;
    private int score;
    public Joueur(String nom) {
    this.nom = nom;
    this.score = 0;
    }

    @Override
    public int compareTo(Joueur o) {
        // TODO Auto-generated method stub
        return 0;
    }
}