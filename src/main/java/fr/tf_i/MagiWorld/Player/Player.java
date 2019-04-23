package fr.tf_i.MagiWorld.Player;

import fr.tf_i.MagiWorld.Classes.Guerrier;
import fr.tf_i.MagiWorld.Classes.Mage;
import fr.tf_i.MagiWorld.Classes.Rodeur;
import fr.tf_i.MagiWorld.Data.ReadLastLine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class Player {



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
        int currentLife = 1;

        int playerNb = 1;



        // ---------------- INIT VARIABLES USING CSV HERE -----------------
        try {
            csv = ReadLastLine.Player1CSV();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier Player1.csv 51");
        }
        String [] split = csv.split(",");

        classe = Integer.valueOf(split[1]); //Set player's class using CSV
        lvl = Integer.valueOf(split[2]); // Set player's level using CSV
        life = Integer.valueOf(split[3]); // Set player's starting life using CSV
        strength = Integer.valueOf(split[4]); // Set player's strength using CSV
        agility = Integer.valueOf(split[5]); // Set player's agility using CSV
        intelligence = Integer.valueOf(split[6]); // Set player's intelligence using CSV
        currentLife = Integer.valueOf(split[7]); // Set player's life using CSV

        do {
            do {
                do {
                    System.out.println("");
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Joueur 1 (" + currentLife + " de vitalite) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Speciale)");
                    try {
                        currentAction = sc.nextInt();
                        responseIsGood = true;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Merci de tapper 1 pour Attaque Basique ou 2 pour Attaque Speciale");
                        responseIsGood = false;
                    }

                } while (!responseIsGood);

                //SUITE
                PlayerAttack(playerNb, classe, lvl, life, strength, agility, intelligence, currentAction, currentLife);
                //SUITE

            } while (currentAction < 1 || currentAction > 2);
            currentAction = -1;
        } while (currentLife <= 0);

        // ---------------- END OF THE GAME ---------------

        System.out.println("");
        System.out.println("JOUEUR 1, VOUS AVEZ PERDU");
        System.out.println("");
        System.out.println("=========================");

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("Player1.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        try {
            PrintWriter writer2 = new PrintWriter("Player2.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        System.exit(0);

        // ---------------- END OF THE GAME ---------------

    }

    /**
     * Player 2
     */
    private static void Player2(){
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
        int currentLife = 1;

        int playerNb = 2;



        // ---------------- INIT VARIABLES USING CSV HERE -----------------
        try {
            csv = ReadLastLine.Player2CSV();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier Player2.csv 136");
        }
        String [] split = csv.split(",");

        classe = Integer.valueOf(split[1]);
        lvl = Integer.valueOf(split[2]);
        life = Integer.valueOf(split[3]);
        strength = Integer.valueOf(split[4]);
        agility = Integer.valueOf(split[5]);
        intelligence = Integer.valueOf(split[6]);
        currentLife = Integer.valueOf(split[7]);

        if (currentLife > 0) {
            do {
                do {
                    System.out.println("");
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Joueur 2 (" + currentLife + " de vitalité) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Spéciale)");
                    try {
                        currentAction = sc.nextInt();
                        responseIsGood = true;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Merci de tapper 1 pour Attaque Basique ou 2 pour Attaque Spéciale");
                        responseIsGood = false;
                    }

                } while (!responseIsGood);

                // Start action
                PlayerAttack(playerNb, classe, lvl, life, strength, agility, intelligence, currentAction, currentLife);

            } while (currentAction < 1 || currentAction > 2);
            currentAction = -1;
        } else

        // ---------------- END OF THE GAME ---------------

            System.out.println("");
        System.out.println("JOUEUR 2, VOUS AVEZ PERDU");
        System.out.println("");
        System.out.println("=========================");

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("Player1.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        try {
            PrintWriter writer2 = new PrintWriter("Player2.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        System.exit(0);

        // ---------------- END OF THE GAME ---------------

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
    private static void PlayerAttack(int attPlayerNb, int attClasse, int attLvl, int attLife, int attStrength, int attAgility, int attIntelligence, int attCurrentAction, int attCurrentLife) {

        Path player1CSVPath = Paths.get("Player1.csv");
        Path player2CSVPath = Paths.get("Player2.csv");
        String ennemySetup;
        String playerSetup;

        String player1Stats = "";
        String player2Stats = "";
        String[] splitPl1;
        String[] splitPl2;

        int[] multipleResult;
        int damage = -1;
        int self = -1;

        // Player performing action stats (using CSV (not called parameters))
        int plPlayerNb = -1;
        int plClasse = -1;
        int plLvl = -1;
        int plLife= -1;
        int plStrength = -1;
        int plAgility =-1;
        int plIntelligence = -1;
        int plCurrentLife = -1;

        // Enemy of the player (Using CSV)
        int ennPlayerNb = -1;
        int ennClasse = -1;
        int ennLvl = -1;
        int ennLife= -1;
        int ennStrength = -1;
        int ennAgility =-1;
        int ennIntelligence = -1;
        int ennCurrentLife = -1;



        if (attPlayerNb == 1) { // Which player is performing the action ?

            //Load Player 1 Setup :
            try {
                player1Stats = ReadLastLine.Player1CSV();
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture du Player1.csv 250");
            }
            plPlayerNb = 1;
            plClasse = attClasse;
            plLvl = attLvl;
            plLife = attLife;
            plStrength = attStrength;
            plAgility = attAgility;
            plIntelligence = attIntelligence;
            plCurrentLife = attCurrentLife;


            splitPl1 = player1Stats.split(",");

            //Load Player 2 Setup :
            try {
                player2Stats = ReadLastLine.Player2CSV();
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture du Player2.csv 268");
            }

            splitPl2 = player2Stats.split(",");

            ennPlayerNb = 2;
            ennClasse = Integer.valueOf(splitPl2[1]);
            ennLvl = Integer.valueOf(splitPl2[2]);
            ennLife = Integer.valueOf(splitPl2[3]);
            ennStrength = Integer.valueOf(splitPl2[4]);
            ennAgility = Integer.valueOf(splitPl2[5]);
            ennIntelligence = Integer.valueOf(splitPl2[6]);
            ennCurrentLife = Integer.valueOf(splitPl2[7]);

            // PLAYER 1 ACTIONS
            switch (attCurrentAction) { // Which action ?
                case 1: {
                    switch (attClasse) { // What is the player's class ?
                        case 1:
                            damage = Guerrier.BasicAttack(attPlayerNb, attStrength);
                            ennCurrentLife = ennCurrentLife - damage;

                            //Update CSV
                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player2(); // Player 2's turn
                            break;

                        case 2:
                            damage = Rodeur.BasicAttack(attPlayerNb, attAgility);
                            ennCurrentLife = ennCurrentLife - damage;

                            //Update CSV
                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player2(); // Player 2's turn
                            break;

                        case 3:
                            damage = Mage.BasicAttack(attPlayerNb, attIntelligence);
                            ennCurrentLife = ennCurrentLife - damage;

                            //Update CSV
                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player2();
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs");
                            Player2(); // Player 2's turn
                            break;
                    }
                }

                case 2: {
                    switch (attClasse) {
                        case 1:
                            multipleResult = Guerrier.SpecialAttack(attPlayerNb, attStrength);
                            damage = multipleResult[0];
                            self = multipleResult[1];

                            ennCurrentLife = ennCurrentLife - damage;
                            plCurrentLife = plCurrentLife - self;


                            //Update CSVs

                            playerSetup = plPlayerNb + "," + plClasse + "," + plLvl + "," + plLife +  "," + plStrength + "," + plAgility + "," + plIntelligence + "," + plCurrentLife + "%n";
                            try {
                                Files.write(player1CSVPath, String.format(playerSetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }

                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player2(); // Player 2's turn
                            break;

                        case 2:
                            self = Rodeur.SpecialAttack(attPlayerNb, attLvl);
                            plAgility = plAgility + self;

                            //Update CSVs

                            playerSetup = plPlayerNb + "," + plClasse + "," + plLvl + "," + plLife +  "," + plStrength + "," + plAgility + "," + plIntelligence + "," + plCurrentLife + "%n";
                            try {
                                Files.write(player1CSVPath, String.format(playerSetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player2(); // Player 2's turn
                            break;

                        case 3:
                            self = Mage.SpecialAttack(attPlayerNb, attIntelligence, attLife, attCurrentLife);
                            plCurrentLife = plCurrentLife + self;

                            //Update CSVs

                            playerSetup = plPlayerNb + "," + plClasse + "," + plLvl + "," + plLife +  "," + plStrength + "," + plAgility + "," + plIntelligence + "," + plCurrentLife + "%n";
                            try {
                                Files.write(player1CSVPath, String.format(playerSetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player2(); // Player 2's turn
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs.");
                            Player2(); // Player 2's turn
                            break;
                    }

                }
            }
            Player2(); // Player 2's turn


            // PLAYER 2 ACTIONS
        } else {

            //Load Player 1 Setup :
            try {
                player1Stats = ReadLastLine.Player1CSV();
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture du Player1.csv, merci de verifier qu'il est bien present dans le dossier.");
            }
            plPlayerNb = 2;
            plClasse = attClasse;
            plLvl = attLvl;
            plLife = attLife;
            plStrength = attStrength;
            plAgility = attAgility;
            plIntelligence = attIntelligence;
            plCurrentLife = attCurrentLife;


            splitPl1 = player1Stats.split(",");

            //Load Player 2 Setup :
            try {
                player2Stats = ReadLastLine.Player2CSV();
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture du Player2.csv, merci de verifier qu'il est bien present dans le dossier.");
            }

            splitPl2 = player2Stats.split(",");

            ennPlayerNb = 1;
            ennClasse = Integer.valueOf(splitPl1[1]);
            ennLvl = Integer.valueOf(splitPl1[2]);
            ennLife = Integer.valueOf(splitPl1[3]);
            ennStrength = Integer.valueOf(splitPl1[4]);
            ennAgility = Integer.valueOf(splitPl1[5]);
            ennIntelligence = Integer.valueOf(splitPl1[6]);
            ennCurrentLife = Integer.valueOf(splitPl1[7]);

            // PLAYER 2 ACTIONS
            switch (attCurrentAction) {
                case 1: {
                    switch (attClasse) {
                        case 1:
                            damage = Guerrier.BasicAttack(attPlayerNb, attStrength);
                            ennCurrentLife = ennCurrentLife - damage;

                            //Update CSV
                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player1CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player1(); // Player 1's turn
                            break;

                        case 2:
                            damage = Rodeur.BasicAttack(attPlayerNb, attAgility);
                            ennCurrentLife = ennCurrentLife - damage;

                            //Update CSV
                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player1CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player1(); // Player 1's turn
                            break;

                        case 3:
                            damage = Mage.BasicAttack(attPlayerNb, attIntelligence);
                            ennCurrentLife = ennCurrentLife - damage;

                            //Update CSV
                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                            Files.write(player1CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                        } catch (IOException e) {
                            System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                            return;
                        }
                            Player1(); // Player 1's turn
                        break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs.");
                            Player1(); // Player 1's turn
                            break;
                    }
                }

                case 2: {
                    switch (attClasse) {
                        case 1:
                            multipleResult = Guerrier.SpecialAttack(attPlayerNb, attStrength);
                            damage = multipleResult[0];
                            self = multipleResult[1];

                            ennCurrentLife = ennCurrentLife - damage;
                            plCurrentLife = plCurrentLife - self;


                            //Update CSVs

                            playerSetup = plPlayerNb + "," + plClasse + "," + plLvl + "," + plLife +  "," + plStrength + "," + plAgility + "," + plIntelligence + "," + plCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(playerSetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }

                            ennemySetup = ennPlayerNb + "," + ennClasse + "," + ennLvl + "," + ennLife +  "," + ennStrength + "," + ennAgility + "," + ennIntelligence + "," + ennCurrentLife + "%n";
                            try {
                                Files.write(player1CSVPath, String.format(ennemySetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player1(); // Player 1's turn
                            break;

                        case 2:
                            self = Rodeur.SpecialAttack(attPlayerNb, attLvl);
                            plAgility = plAgility + self;

                            //Update CSVs

                            playerSetup = plPlayerNb + "," + plClasse + "," + plLvl + "," + plLife +  "," + plStrength + "," + plAgility + "," + plIntelligence + "," + plCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(playerSetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player1(); // Player 1's turn
                            break;

                        case 3:
                            self = Mage.SpecialAttack(attPlayerNb, attIntelligence, attLife, attCurrentLife);
                            plCurrentLife = plCurrentLife + self;

                            //Update CSVs

                            playerSetup = plPlayerNb + "," + plClasse + "," + plLvl + "," + plLife +  "," + plStrength + "," + plAgility + "," + plIntelligence + "," + plCurrentLife + "%n";
                            try {
                                Files.write(player2CSVPath, String.format(playerSetup).getBytes(), APPEND);
                            } catch (IOException e) {
                                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer en verifiant qu'il est bien present dans le dossier.");
                                return;
                            }
                            Player1(); // Player 1's turn
                            break;

                        default:
                            System.out.println("Erreur lors du choix des joueurs.");
                            Player1(); // Player 1's turn
                            break;
                    }

                }
            }
            Player1(); // Player 1's turn
        }
    }
}


