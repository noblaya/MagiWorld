package fr.tf_i.MagiWorld.Player;

import fr.tf_i.MagiWorld.Jeu;

import java.util.Scanner;

/**
 * Maybe use a board with Player id (ex id 0 = Player 1, id 1 = Player 2) with all there stats (level, life, etc) and
 * print a csv file or other.
 */
public class Player {
    private int classe, level, life, strength, agility, intelligence, playerNb = 0;
    private Jeu jeu = new Jeu();
    Scanner sc = new Scanner(System.in);

    /**
     * Ask the chosen class to the player between 1 and 3 (1 : Guerrier 2 : Rôdeur, 3 : Mage)
     */
    public void askChosenClasse() {
        playerNb ++;
        System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage)");
        classe = sc.nextInt();
        askLevel();
    }

    /**
     * Ask player level between 1 and 100
     */
    private void askLevel() {
        System.out.println("Niveau du personnage ? (Entre 1 et 100)");
        level = sc.nextInt();
        askStrength();
    }


    /**
     * Ask player Strength between 1 and 10
     */
    private void askStrength(){
        System.out.println("Force du personnage ? (Entre 0 et 10)");
        strength = sc.nextInt();
        askAgility();
    }

    /**
     * Ask player Agility between 1 and 10
     */
    private void askAgility() {
        System.out.println("Agilité du personnage ? (Entre 0 et 10)");
        agility = sc.nextInt();
        askIntelligence();
    }

    /**
     * Ask player Intelligence between 1 and 10
     */
    private void askIntelligence() {
        System.out.println("Intelligence du personnage ? (Entre 0 et 10");
        intelligence = sc.nextInt();
        setLife();
    }

    /**
     * Set the player life (Player Level x 5)
     */
    private void setLife() {
        life = level*5;
        setPlayerDescription();
    }

    /**
     * Set the player description (or intro) using player id
     */
    private void setPlayerDescription() {
        String intro;
        switch (classe){
            case 1 :
                intro = "Woarg je suis le Guerrier Joueur " + playerNb + " niveau "+ level + " je possède " + life + " de vie, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                break;
            case 2 :
                intro = "Hmm je suis le Rôdeur Joueur " + playerNb + " niveau "+ level + " je possède " + life + " de vie, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                break;
            case 3 :
                intro = "Abracadabra je suis le Mage Joueur " + playerNb + " niveau "+ level + " je possède " + life + " de vie, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
            default:
                intro = "Erreur dans le choix du personnage, je suis donc un simple humain Joueur " + playerNb + " niveau "+ level + " je possède " + life + " de vie, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                break;
        }
        System.out.println(intro);
        jeu.setupGame();
    }

}
