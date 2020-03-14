public class Factory {

    public static De getDice(int nbDeFace){
        return new De(nbDeFace);
    }

    public static Joueur getJoueur(String nom){
        return new Joueur(nom);
    }
}
