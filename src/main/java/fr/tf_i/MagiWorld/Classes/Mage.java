package fr.tf_i.MagiWorld.Classes;

public class Mage {

    /**
     * Mage's basic attack
     * @param playerNb Which player
     * @param intelligence Player's intelligence
     * @return the damage to apply
     */
    public static int BasicAttack(int playerNb, int intelligence) {
        int damage = -1;

        damage = intelligence;
        System.out.println("Joueur " + playerNb + " utilise Boule de Feu et inflige " + damage + " dommages.");

        return damage;
    }

    /**
     * Mage Special attack
     * @param playerNb Which player
     * @param intelligence Player's intelligence
     * @param life Player's max life (starting life)
     * @param currentLife Player's current life
     * @return the amount of life to restore
     */
    public static int SpecialAttack(int playerNb, int intelligence, int life, int currentLife) {
        int currentSelf = -1;
        int deltaLife = -1;
        int self = -1;

        deltaLife = (life-currentLife);
        currentSelf = (intelligence*2);

        if (currentSelf <= deltaLife) {
            self = (intelligence*2);
        } else {
            self = deltaLife;
        }
        System.out.println("Joueur " + playerNb + " utilise Soin et gagne " + self + " en vitalite.");

        return self;
    }
}
