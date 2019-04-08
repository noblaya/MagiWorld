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

    public void setupPlayers(int playerNb){
        if (playerNb == 1) {
            setPlayer1();
        } else if (playerNb == 2) {
            setPlayer2();
        } else {
            System.out.println("Erreur playerNb autre que 1 ou 2 !");
        }
    }


    public void setPlayer1() {
        Player players = new Player();
        Path playerSetupPath = Paths.get("PlayerSetup.csv");
        String playerSetup = "";
        int classe, lvl, life, strength, agility, intelligence;
        int playerNb = 1;

        System.out.println("Création du personnage du Joueur 1");

        System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        classe = sc.nextInt();

        System.out.println("Niveau du personnage ? (Entre 1 et 100)");
        lvl = sc.nextInt();

        life = lvl*5;

        System.out.println("Force du personnage ? (Entre 0 et 10)");
        strength = sc.nextInt();

        System.out.println("Agilité du personnage ? (Entre 0 et 10)");
        agility = sc.nextInt();

        System.out.println("Intelligence du personnage ? (Entre 0 et 10)");
        intelligence = sc.nextInt();

        playerSetup = playerNb + "," + classe + "," + lvl + "," + life + "," + strength + "," + agility + "," + intelligence + "%n";
        try {
            Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la génération du PlayerSetup.csv. MErci de rééssayer.");
            return;
        }

        setupIntro(1,classe,lvl,life,strength,agility,intelligence);
    }

    private void setPlayer2() {
        Jeu jeu = new Jeu();
        Player players = new Player();
        Path playerSetupPath = Paths.get("PlayerSetup.csv");
        String playerSetup = "";
        int classe, lvl, life, strength, agility, intelligence;
        int playerNb = 2;

        System.out.println("Création du personnage du Joueur 2");

        System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        classe = sc.nextInt();

        System.out.println("Niveau du personnage ? (Entre 1 et 100)");
        lvl = sc.nextInt();

        life = lvl*5;

        System.out.println("Force du personnage ? (Entre 0 et 10)");
        strength = sc.nextInt();

        System.out.println("Agilité du personnage ? (Entre 0 et 10)");
        agility = sc.nextInt();

        System.out.println("Intelligence du personnage ? (Entre 0 et 10)");
        intelligence = sc.nextInt();

        playerSetup = playerNb + "," + classe + "," + lvl + "," + life + "," + strength + "," + agility + "," + intelligence + "%n";
        try {
            Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la génération du PlayerSetup.csv. MErci de rééssayer.");
            return;
        }

        setupIntro(2,classe,lvl,life,strength,agility,intelligence);
    }

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
