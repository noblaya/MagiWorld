package fr.tf_i.MagiWorld.Player;

import fr.tf_i.MagiWorld.Jeu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
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
    private void setPlayer1() {
        Path playerSetupPath = Paths.get("Player1.csv");
        String playerSetup = "";
        boolean responseIsGood;
        int classe = -1;
        int lvl = -1;
        int life = -1;
        int strength = -1;
        int agility = -1;
        int intelligence = -1;
        int playerNb = 1;
        int availablePoints = -1;
        int currentLife = -1;

        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Creation du personnage du Joueur 1");
        System.out.println("----------------------------------");


        //Set Player's Class :
        do {
            do {
                System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rodeur, 3 : Mage)");
                try {
                    classe = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 1 et 3 correspondant à la Classe souhaitée");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        }while (classe < 1 || classe > 3);


        //Set Player's Level :
        do {
            do {
                System.out.println("Niveau du personnage ? (Entre 1 et 100)");
                try {
                    lvl = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 1 et 100 correspondant au Niveau souhaité");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        } while (lvl < 1 || lvl > 100);

        //Set Available Points to Spend.
        availablePoints = lvl;


        //Set Player's life
        life = lvl*5;
        currentLife = life;


        //Set Player's Strength
        do {
            do {
                System.out.println("Force du personnage ? (Entre 0 et " + availablePoints + ")");
                try {
                    strength = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints + "correspondant à la Force du personnage souhaitee");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        } while (strength < 0 || strength > availablePoints);
        availablePoints = (availablePoints - strength);


        //Set Player's Agility
        do {
            do {
                System.out.println("Agilite du personnage ? (Entre 0 et " + availablePoints + ")");
                try {
                    agility = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints + " correspondant à l'Agilité du personnage souhaitee");
                    responseIsGood = false;
                }
            }while (!responseIsGood);
        } while (agility < 0 || agility > availablePoints);
        availablePoints = (availablePoints - agility);

        //Set Player's Intelligence
        do {
            do {
                System.out.println("Intelligence du personnage ? (Entre 0 et " + availablePoints +")");
                try {
                    intelligence = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e){
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints +" correspondant à l'Intelligence du personnage souahaitee");
                    responseIsGood = false;
                }

            } while (!responseIsGood);
        } while (intelligence < 0 || intelligence > 100);
        availablePoints = (availablePoints - intelligence);

        playerSetup = playerNb + "," + classe + "," + lvl + "," + life +  "," + strength + "," + agility + "," + intelligence + "," + currentLife + "%n";
        try {
            Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer.");
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
        Path playerSetupPath = Paths.get("Player2.csv");
        String playerSetup = "";
        boolean responseIsGood;
        int classe = -1;
        int lvl = -1;
        int life = -1;
        int strength = -1;
        int agility = -1;
        int intelligence = -1;
        int playerNb = 2;
        int availablePoints = -1;
        int currentLife = -1;

        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Creation du personnage du Joueur 2");
        System.out.println("----------------------------------");

        //Set Player's Class :
        do {
            do {
                System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rodeur, 3 : Mage)");
                try {
                    classe = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 1 et 3 correspondant à la Classe souhaitee");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        }while (classe < 1 || classe > 3);


        //Set Player's Level :
        do {
            do {
                System.out.println("Niveau du personnage ? (Entre 1 et 100)");
                try {
                    lvl = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 1 et 100 correspondant au Niveau souhaite");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        } while (lvl < 1 || lvl > 100);

        //Set Available Points to Spend.
        availablePoints = lvl;


        //Set Player's life
        life = lvl*5;
        currentLife = life;


        //Set Player's Strength
        do {
            do {
                System.out.println("Force du personnage ? (Entre 0 et " + availablePoints + ")");
                try {
                    strength = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints + "correspondant à la Force du personnage souhaitee");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        } while (strength < 0 || strength > availablePoints);
        availablePoints = (availablePoints - strength);


        //Set Player's Agility
        do {
            do {
                System.out.println("Agilite du personnage ? (Entre 0 et " + availablePoints + ")");
                try {
                    agility = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints + " correspondant à l'Agilité du personnage souhaitee");
                    responseIsGood = false;
                }
            }while (!responseIsGood);
        } while (agility < 0 || agility > availablePoints);
        availablePoints = (availablePoints - agility);

        //Set Player's Intelligence
        do {
            do {
                System.out.println("Intelligence du personnage ? (Entre 0 et " + availablePoints +")");
                try {
                    intelligence = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e){
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints +" correspondant à l'Intelligence du personnage souahaitee");
                    responseIsGood = false;
                }

            } while (!responseIsGood);
        } while (intelligence < 0 || intelligence > 100);
        availablePoints = (availablePoints - intelligence);

        playerSetup = playerNb + "," + classe + "," + lvl + "," + life + "," + strength + "," + agility + "," + intelligence + "," + currentLife + "%n";
        try {
            Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer.");
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
                    intro = "Woarg je suis le Guerrier Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                    break;
                case 2:
                    intro = "Hmmm je suis le Rodeur Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                    break;
                case 3:
                    intro = "Abracadabra je suis le Mage Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                    break;

                default:
                    intro = "Erreur lors du choix de la classe, je suis donc le simple Humain Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
            }
            System.out.println(intro);
            setupPlayers(2);
        } else {
            switch (classe) {
                case 1:
                    intro = "Woarg je suis le Guerrier Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                    break;
                case 2:
                    intro = "Hmmm je suis le Rodeur Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                    break;
                case 3:
                    intro = "Abracadabra je suis le Mage Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                    break;

                default:
                    intro = "Erreur lors du choix de la classe, je suis donc le simple Humain Joueur " + playerNb + " niveau " + lvl + ", je possede " + life + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
            }
            System.out.println(intro);
            jeu.gameLaunch(true);
        }

    }
}
