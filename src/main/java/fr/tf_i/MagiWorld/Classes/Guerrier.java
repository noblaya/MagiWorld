package fr.tf_i.MagiWorld.Classes;

public class Guerrier {



    public static int BasicAttack(int playerNb, int strength) {
        int damage = -1;

        damage = strength;
        System.out.println("Joueur " + playerNb + " utilise Coup d'épée et inflige " + damage + " dommages.");

        return damage;
    }

    public static int[] SpecialAttack(int playerNb, int strength) {
        int damage = -1;
        int self = -1;

        damage = (strength*2);
        self = (strength/2);
        System.out.println("Joueur " + playerNb + " utilise Coup de Rage et inflige " + damage + " dommages à l'adversaire mais s'inflige " + self + " dommages dans sa colère.");

        return new int[] {damage,self};
    }
}
