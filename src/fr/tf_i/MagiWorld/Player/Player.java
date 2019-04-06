package fr.tf_i.MagiWorld.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    int classe, level, life, strength, agility, intelligence = 0;
    String className = "";

    public Player(int classe, int level, int life, int strength, int agility, int intelligence) {
        this.classe = classe;
        this.level = level;
        this.life = life;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Ask the chosen class to the player between 1 and 3 (1 : Guerrier 2 : Rôdeur, 3 : Mage)
     * @param classe the chosen class
     */
    public void askChosenClasse(int classe) {
        boolean responseIsGood;
        this.classe = classe;

        System.out.println("Veuillez choisir la classe de votre personnage");
        do {
            try {
                    classe = sc.nextInt();
                    responseIsGood = (classe >=1 && classe <=3);

            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Vous devez choisir la classe de votre personnage entre les 3 choix (Exemple : saisissez ''1'' pour ''Guerrier'')");
                responseIsGood =  false;
            }
        } while (!responseIsGood);

        this.className = className;
        switch (classe) {
            case 1 :
                className = "Guerrier";
                break;
            case 2 :
                className = "Rôdeur";
                break;
            case 3 :
                className = "Mage";
                break;

                default:
                    className = "Aucune";
                    break;

        }

        if (className.contains("Aucune")){
            System.out.println("Erreur lors de la saisie de la classe !");
        } else
            System.out.println("Vous êtes un " + className);
        this.askLevel(0);
    }

    public void askLevel(int level) {
        this.level = level;
        //SUITE
    }


    public void askStrength(int strength) {
        this.strength = strength;
    }

    public void askAgility(int agility) {
        this.agility = agility;
    }

    public void askIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setLife(int life) {
        this.life = life;
    }

}
