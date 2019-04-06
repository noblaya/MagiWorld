package fr.tf_i.MagiWorld.Player;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Player player = new Player(1,1,1,1,1,1);


    @Test
    public void Given_Rodeur_When_AskingForClass_Then_DisplayChoosenClass(){
        player.askChosenClasse(2);
        assertEquals("Vous êtes un Rôdeur\n", outContent.toString().replace("\r\n", "\n"));
    }

}