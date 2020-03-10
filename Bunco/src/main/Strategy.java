import javax.crypto.spec.PSource;

public interface Strategy {

    public void calculerLeVainqueur(Jeu jeu);

    public void calculerScoreTour(Jeu jeu);

}

/**
 * Ce logiciel serait utilisé éventuellement par plusieurs applications de jeu
 * de dés dont il existe plusieurs variantes. Plusieurs éléments peuvent changer
 * d'une variante à l'autre, par exemple
 */
// TODO 1: le nombre de faces qu'a un dé
// TODO 2: le nombre de dés par joueur
// TODO 3: le nombre de joueurs
// TODO 4: le nombre de tours dans un jeu
// TODO 5: les règles de calcul des scores des joueurs.
