package fr.tf_i.MagiWorld;

import fr.tf_i.MagiWorld.Player.Player;
import fr.tf_i.MagiWorld.Player.PlayerSetup;

public class Jeu {
    private boolean isGameSetup = false; //When the game is setup
    private int playerNb = 0; //Player Number



    /**
     * Launch the game, it is the core
     */
    public void gameLaunch(boolean isGameSetup) {

        if (!isGameSetup) { //IF the game is not setup so set it up
            setupGame();
        } else {
            Player.Player1();
        }

    }

    /**
     * Setup the game and players.
     */
    public void setupGame() {
       PlayerSetup playerSetup = new PlayerSetup();

       playerSetup.setupPlayers(1);
    }


}
