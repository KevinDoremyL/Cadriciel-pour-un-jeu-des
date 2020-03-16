public class Factory {

    public static De getDice(int nbDeFace){
        return new De(nbDeFace);
    }

    public static Joueur getJoueur(){
        return new Joueur("");
    }

    public static Joueur getJoueur(String nom){
        return new Joueur(nom);
    }

    public static Jeu getJeu(){
        return new Jeu();
    }
}
