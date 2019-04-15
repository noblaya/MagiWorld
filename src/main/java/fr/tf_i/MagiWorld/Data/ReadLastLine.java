package fr.tf_i.MagiWorld.Data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadLastLine{

    public static String Player1CSV() throws Exception {

        FileInputStream in = new FileInputStream("Player1.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine = null, tmp;

        while ((tmp = br.readLine()) != null)
        {
            strLine = tmp;
        }

        String lastLine = strLine;

        return lastLine;
    }

    public static String Player2CSV() throws Exception {

        FileInputStream in = new FileInputStream("Player2.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine = null, tmp;

        while ((tmp = br.readLine()) != null)
        {
            strLine = tmp;
        }

        String lastLine = strLine;

        return lastLine;
    }
}