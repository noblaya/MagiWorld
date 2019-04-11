package fr.tf_i.MagiWorld.Classes;

public class Rodeur {

    public static int BasicAttack(int playerNb, int agility) {
        int damage = -1;

        damage = agility;
        System.out.println("Joueur " + playerNb + " utilise Tir à l'Arc et inflige " + damage + " dommages.");

        return damage;
    }

    public static int SpecialAttack(int playerNb, int lvl) {
        int self = -1;

        self = (lvl/2);
        System.out.println("Joueur " + playerNb + " utilise Concentration et gagne " + self + " en agilité.");

        return self;
    }
}
