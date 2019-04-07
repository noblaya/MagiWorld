package fr.tf_i.MagiWorld;

import fr.tf_i.MagiWorld.Player.Player;

public class Jeu {
    private boolean isGameSetup = false;
    private int nbPlayers = 2;
    protected int playerNb = 0;


    public void gameLaunch () {

        if (isGameSetup == false) {
            setupGame();
        } else {
            System.out.println("---------- Succès ! ----------");
        }

        //SUITE
    }

    public void setupGame() {
        Player player = new Player();

        playerNb ++;

        if (playerNb < nbPlayers) {
            System.out.println("Création du personnage du Joueur " + playerNb);
            player.askChosenClasse();
        } else {
            isGameSetup = true;
            gameLaunch();
        }
    }


}
