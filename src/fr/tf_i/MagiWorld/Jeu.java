package fr.tf_i.MagiWorld;

import fr.tf_i.MagiWorld.Player.Player;

public class Jeu {
    private boolean isGameSetup = false; //When the game is setup
    private int playerNb = 0; //Player Number
    private int nbPlayers = 2; // Number of Players



    /**
     * Launch the game, it is the core
     */
    void gameLaunch() {

        if (!isGameSetup) { //IF the game is not setup so set it up
            setupGame();
        } else {
            System.out.println("---------- Succès ! ----------");
        }

        //SUITE
    }

    /**
     * Setup the game and players.
     */
    public void setupGame() {
       Player player = new Player();

        if (playerNb < nbPlayers) { //IF player number (ex : Player 1) is less than the number of players (2 here) so set it up
            playerNb ++;
            System.out.println("Création du personnage du Joueur " + playerNb);
            player.askChosenClasse();
        } else {
            isGameSetup = true;
            gameLaunch();
        }
    }


}
