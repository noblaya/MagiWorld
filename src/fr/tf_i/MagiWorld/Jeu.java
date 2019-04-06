package fr.tf_i.MagiWorld;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Jeu {
    boolean isGameSetup = false;

    public Jeu(boolean isGameSetup) {
        this.isGameSetup = isGameSetup;
    }


    public void gameLaunch (){
        do {
            setupGame();
        } while (isGameSetup = false);

        //SUITE
    }

    public void setupGame() {
        Path gameSetupPath = Paths.get("GameSetup.csv");
        int nbPlayers = 2;
        int playerNb = 1;

        do {
            System.out.println("Création du personnage du Joueur " + playerNb);
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage");

        } while (playerNb <= nbPlayers);
        isGameSetup = true;
    }
}
