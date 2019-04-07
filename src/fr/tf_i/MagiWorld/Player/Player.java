package fr.tf_i.MagiWorld.Player;

import fr.tf_i.MagiWorld.Jeu;

import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    private int classe, level, life, strength, agility, intelligence, playerNb = 0;
    Jeu jeu = new Jeu();

    /**
     * Ask the chosen class to the player between 1 and 3 (1 : Guerrier 2 : Rôdeur, 3 : Mage)
     */
    public void askChosenClasse() {
        playerNb ++;
        System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage");
        classe = 1;
        askLevel();
    }

    public void askLevel() {
        System.out.println("Niveau du personnage ? (Entre 1 et 100)");
        level = 10;
        askStrength();
    }


    public void askStrength(){
        System.out.println("Force du personnage ? (Entre 0 et 10)");
        strength = 10;
        askAgility();
    }

    public void askAgility() {
        System.out.println("Agilité du personnage ? (Entre 0 et 10)");
        agility = 0;
        askIntelligence();
    }

    public void askIntelligence() {
        System.out.println("Intelligence du personnage ? (Entre 0 et 10");
        intelligence = 0;
        setLife();
    }

    public void setLife() {
        life = level*5;
        setPlayerDescription();
    }

    public void setPlayerDescription() {
        String intro = "";
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
