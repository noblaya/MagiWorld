package fr.tf_i.MagiWorld.Classes;

public class Rodeur {

    /**
     * Rodeur's Basic attack
     * @param playerNb Which player
     * @param agility Player's agility
     * @return the amount of damage to apply
     */
    public static int BasicAttack(int playerNb, int agility) {
        int damage = -1;

        damage = agility;
        System.out.println("Joueur " + playerNb + " utilise Tir à l'Arc et inflige " + damage + " dommages.");

        return damage;
    }

    /**
     * Rodeur Special attack
     * @param playerNb Which player
     * @param lvl Player's level
     * @return the amount of agility to add
     */
    public static int SpecialAttack(int playerNb, int lvl) {
        int self = -1;

        self = (lvl/2);
        System.out.println("Joueur " + playerNb + " utilise Concentration et gagne " + self + " en agilite.");

        return self;
    }
}
