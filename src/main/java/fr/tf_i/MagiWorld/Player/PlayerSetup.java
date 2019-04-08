package fr.tf_i.MagiWorld.Player;

import fr.tf_i.MagiWorld.Jeu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class PlayerSetup {
    Scanner sc = new Scanner(System.in);

    /**
     * Setup player dispatch (between player 1 and 2)
     * @param playerNb Which player to setup
     */
    public void setupPlayers(int playerNb){
        if (playerNb == 1) {
            setPlayer1();
        } else if (playerNb == 2) {
            setPlayer2();
        } else {
            System.out.println("Erreur playerNb autre que 1 ou 2 !");
        }
    }

    /**
     * Setup Player 1
     */
    public void setPlayer1() {
        Player players = new Player();
        Path playerSetupPath = Paths.get("PlayerSetup.csv");
        String playerSetup = "";
        int classe, lvl, life, strength, agility, intelligence;
        int playerNb = 1;

        System.out.println("Création du personnage du Joueur 1");


        //Set Player's Class :
        do {
            System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            classe = sc.nextInt();
        } while (classe < 1 || classe > 3);


        //Set Player's Level :
        do {
            System.out.println("Niveau du personnage ? (Entre 1 et 100)");
            lvl = sc.nextInt();
        } while (lvl < 1 || lvl > 100);

        //Set Player's life
        life = lvl*5;

        //Set Player's Strength
        do {
            System.out.println("Force du personnage ? (Entre 0 et 10)");
            strength = sc.nextInt();
        } while (strength < 0 || strength > 10);

        //Set Player's Agility
        do {
            System.out.println("Agilité du personnage ? (Entre 0 et 10)");
            agility = sc.nextInt();
        } while (agility < 0 || agility > 10);

        //Set Player's Intelligence
        do {
            System.out.println("Intelligence du personnage ? (Entre 0 et 10)");
            intelligence = sc.nextInt();
        } while (intelligence < 0 || intelligence > 10);

        playerSetup = playerNb + "," + classe + "," + lvl + "," + life + "," + strength + "," + agility + "," + intelligence + "%n";
        try {
            Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la génération du PlayerSetup.csv. MErci de rééssayer.");
            return;
        }

        setupIntro(1,classe,lvl,life,strength,agility,intelligence);
    }

    /**
     * Setup Player 2
     */
    private void setPlayer2() {
        Jeu jeu = new Jeu();
        Player players = new Player();
        Path playerSetupPath = Paths.get("PlayerSetup.csv");
        String playerSetup = "";
        int classe, lvl, life, strength, agility, intelligence;
        int playerNb = 2;

        System.out.println("Création du personnage du Joueur 2");

        //Set Player's Class :
        do {
            System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            classe = sc.nextInt();
        } while (classe < 1 || classe > 3);


        //Set Player's Level :
        do {
            System.out.println("Niveau du personnage ? (Entre 1 et 100)");
            lvl = sc.nextInt();
        } while (lvl < 1 || lvl > 100);

        //Set Player's life
        life = lvl*5;

        //Set Player's Strength
        do {
            System.out.println("Force du personnage ? (Entre 0 et 10)");
            strength = sc.nextInt();
        } while (strength < 0 || strength > 10);

        //Set Player's Agility
        do {
            System.out.println("Agilité du personnage ? (Entre 0 et 10)");
            agility = sc.nextInt();
        } while (agility < 0 || agility > 10);

        //Set Player's Intelligence
        do {
            System.out.println("Intelligence du personnage ? (Entre 0 et 10)");
            intelligence = sc.nextInt();
        } while (intelligence < 0 || intelligence > 10);

        playerSetup = playerNb + "," + classe + "," + lvl + "," + life + "," + strength + "," + agility + "," + intelligence + "%n";
        try {
            Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la génération du PlayerSetup.csv. MErci de rééssayer.");
            return;
        }

        setupIntro(2,classe,lvl,life,strength,agility,intelligence);
    }

    /**
     * Setup the player intro String and print it.
     * @param playerNb which player (1 or 2)
     * @param classe player's class
     * @param lvl player's level
     * @param life player's life
     * @param strength player's strength
     * @param agility player's agility
     * @param intelligence player's intelligence
     */
    private void setupIntro(int playerNb, int classe, int lvl, int life, int strength, int agility, int intelligence) {
        Jeu jeu = new Jeu();
        String intro;

        if (playerNb == 1) {
            switch (classe) {
                case 1:
                    intro = "Woarg je suis le Guerrier Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                    break;
                case 2:
                    intro = "Hmmm je suis le Rôdeur Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                    break;
                case 3:
                    intro = "Abracadabra je suis le Mage Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                    break;

                default:
                    intro = "Erreur lors du choix de la classe, je suis donc le simple Humain Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
            }
            System.out.println(intro);
            setupPlayers(2);
        } else {
            switch (classe) {
                case 1:
                    intro = "Woarg je suis le Guerrier Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                    break;
                case 2:
                    intro = "Hmmm je suis le Rôdeur Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                    break;
                case 3:
                    intro = "Abracadabra je suis le Mage Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
                    break;

                default:
                    intro = "Erreur lors du choix de la classe, je suis donc le simple Humain Joueur " + playerNb + " niveau " + lvl + ", je possède " + life + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !";
            }
            System.out.println(intro);
            jeu.gameLaunch(true);
        }

    }
}
