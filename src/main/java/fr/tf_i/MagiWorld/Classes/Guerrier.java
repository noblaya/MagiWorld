package fr.tf_i.MagiWorld.Classes;

public class Guerrier {


    /**
     * Guerrier's basic attack
     * @param playerNb Which player
     * @param strength Player's strength
     * @return the dommage to apply
     */
    public static int BasicAttack(int playerNb, int strength) {
        int damage = -1;

        damage = strength;
        System.out.println("Joueur " + playerNb + " utilise Coup d'epee et inflige " + damage + " dommages.");

        return damage;
    }

    /**
     * Guerrier's special attack
     * @param playerNb Which player
     * @param strength Player's strength
     * @return the damages to apply
     */
    public static int[] SpecialAttack(int playerNb, int strength) {
        int damage = -1;
        int self = -1;

        damage = (strength*2); // Damages to the enemy
        self = (strength/2); // Damages to self
        System.out.println("Joueur " + playerNb + " utilise Coup de Rage et inflige " + damage + " dommages à l'adversaire mais s'inflige " + self + " dommages dans sa colere.");

        return new int[] {damage,self};
    }
}
