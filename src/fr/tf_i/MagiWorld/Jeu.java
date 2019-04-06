package fr.tf_i.MagiWorld;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Jeu {


    public void setupGame() {
        Path gameSetupPath = Paths.get("GameSetup.csv");
        int nbPlayers = 2;
        int playerNb = 1;

        do {
            System.out.println("Création du personnage du joueur " + playerNb + "%n");
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage" + "%n");
            
        } while (playerNb <= nbPlayers);
    }
}
