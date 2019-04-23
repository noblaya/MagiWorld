package fr.tf_i.MagiWorld.Classes;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

public class GuerrierTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void Given_DamageToApply_When_ActionToPerform_Then_DisplayHowMuch() {
        Guerrier.BasicAttack(1, 50);
        assertEquals("Joueur 1 utilise Coup d'epee et inflige 50 dommages.", outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    public void Given_SpecialAttackToAplly_When_ActionToPerform_Then_DisplayHowMuch() {
        Guerrier.SpecialAttack(1, 50);
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 100 dommages à l'adversaire mais s'inflige 25 dommages dans sa colere.", outContent.toString().replace("\r\n", "\n"));
    }
}