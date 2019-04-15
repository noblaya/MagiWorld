package fr.tf_i.MagiWorld.Player;

import fr.tf_i.MagiWorld.Classes.Guerrier;
import fr.tf_i.MagiWorld.Classes.Mage;
import fr.tf_i.MagiWorld.Classes.Rodeur;
import fr.tf_i.MagiWorld.Data.ReadLastLine;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    int currentAction = -1;



    /**
     * Player 1
     */
    public static void Player1(){
        Scanner sc = new Scanner(System.in);
        String csv = "";
        boolean responseIsGood;
        int currentAction = -1;

        int classe = -1;
        int lvl = -1;
        int life = -1;
        int strength = -1;
        int agility = -1;
        int intelligence = -1;
        int currentLife = -1;

        int playerNb = 1;



        // ---------------- INIT VARIABLES USING CSV HERE -----------------
        try {
            csv = ReadLastLine.Player1CSV();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier Player1.csv");
        }
        String [] split = csv.split(",");

        classe = Integer.valueOf(split[1]);
        lvl = Integer.valueOf(split[2]);
        life = Integer.valueOf(split[3]);
        strength = Integer.valueOf(split[4]);
        agility = Integer.valueOf(split[5]);
        intelligence = Integer.valueOf(split[6]);
        currentLife = Integer.valueOf(split[7]);

        do {
            do {
                do {
                    System.out.println("Joueur 1 (" + currentLife + " de vitalité) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Spéciale)");
                    try {
                        currentAction = sc.nextInt();
                        responseIsGood = true;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Merci de tapper 1 pour Attaque Basique ou 2 pour Attaque Spéciale");
                        responseIsGood = false;
                    }

                } while (!responseIsGood);

                //SUITE
                PlayerAttack(playerNb, classe, lvl, life, strength, agility, intelligence, currentAction, currentLife);
                //SUITE

            } while (currentAction < 1 || currentAction > 2);
            currentAction = -1;
        } while (currentLife <= 0);
        System.out.println("Joueur 1, vous avez perdu !");
        // ---------------- FIN DU JEU ---------------

    }

    /**
     * Player 2
     */
    public static void Player2(){
        Scanner sc = new Scanner(System.in);
        String csv = "";
        int currentAction = -1;
        boolean responseIsGood;

        int classe = -1;
        int lvl = -1;
        int life = -1;
        int strength = -1;
        int agility = -1;
        int intelligence = -1;
        int currentLife = -1;

        int playerNb = 2;



        // ---------------- INIT VARIABLES USING CSV HERE -----------------
        try {
            csv = ReadLastLine.Player2CSV();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier Player2.csv");
        }
        String [] split = csv.split(",");

        classe = Integer.valueOf(split[1]);
        lvl = Integer.valueOf(split[2]);
        life = Integer.valueOf(split[3]);
        strength = Integer.valueOf(split[4]);
        agility = Integer.valueOf(split[5]);
        intelligence = Integer.valueOf(split[6]);
        currentLife = Integer.valueOf(split[7]);

        do {
            do {
                do {
                    System.out.println("Joueur 1 (" + currentLife + " de vitalité) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Spéciale)");
                    try {
                        currentAction = sc.nextInt();
                        responseIsGood = true;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Merci de tapper 1 pour Attaque Basique ou 2 pour Attaque Spéciale");
                        responseIsGood = false;
                    }

                } while (!responseIsGood);

                //SUITE
                PlayerAttack(playerNb, classe, lvl, life, strength, agility, intelligence, currentAction, currentLife);
                //SUITE

            } while (currentAction < 1 || currentAction > 2);
            currentAction = -1;
        } while (currentLife <= 0);
        System.out.println("Joueur 2, vous avez perdu !");
        // ---------------- FIN DU JEU ---------------

    }

    /**
     * Players Actions
     * @param attPlayerNb Which player is performing the action ?
     * @param attClasse Class of this player
     * @param attLvl Level of this player
     * @param attLife Max life of this player
     * @param attStrength Strength of this player
     * @param attAgility Agility of this player
     * @param attIntelligence Intelligence of this player
     * @param attCurrentAction Which action player choose
     * @param attCurrentLife The current life of this player
     */
    public static void PlayerAttack(int attPlayerNb, int attClasse, int attLvl, int attLife, int attStrength, int attAgility, int attIntelligence, int attCurrentAction, int attCurrentLife) {

        int[] actionResult;
        int damage = -1;
        int self = -1;

        if (attPlayerNb == 1) {

            // PLAYER 1 ACTIONS
            switch (attCurrentAction) {
                case 1: {
                    switch (attClasse) {
                        case 1:
                            damage = Guerrier.BasicAttack(attPlayerNb, attStrength);
                            break;

                        case 2:
                            damage = Rodeur.BasicAttack(attPlayerNb, attAgility);
                            break;

                        case 3:
                            damage = Mage.BasicAttack(attPlayerNb, attIntelligence);
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs");
                            break;
                    }
                }

                case 2: {
                    switch (attClasse) {
                        case 1:
                            actionResult = Guerrier.SpecialAttack(attPlayerNb, attStrength);
                            break;

                        case 2:
                            self = Rodeur.SpecialAttack(attPlayerNb, attLvl);
                            break;

                        case 3:
                            self = Mage.SpecialAttack(attPlayerNb, attIntelligence, attLife, attCurrentLife);
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs");
                            break;
                    }

                }
            }
            Player2();


            // PLAYER 2 ACTIONS
        } else {
            switch (attCurrentAction) {
                case 1: {
                    switch (attClasse) {
                        case 1:
                            damage = Guerrier.BasicAttack(attPlayerNb, attStrength);
                            if (attPlayerNb == 1) {

                            }
                            break;

                        case 2:
                            damage = Rodeur.BasicAttack(attPlayerNb, attAgility);
                            break;

                        case 3:
                            damage = Mage.BasicAttack(attPlayerNb, attIntelligence);
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs");
                            break;
                    }
                }

                case 2: {
                    switch (attClasse) {
                        case 1:
                            actionResult = Guerrier.SpecialAttack(attPlayerNb, attStrength);
                            break;

                        case 2:
                            self = Rodeur.SpecialAttack(attPlayerNb, attLvl);
                            break;

                        case 3:
                            self = Mage.SpecialAttack(attPlayerNb, attIntelligence, attLife, attCurrentLife);
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs");
                            break;
                    }

                }
            }
            Player1();
        }
    }
}


