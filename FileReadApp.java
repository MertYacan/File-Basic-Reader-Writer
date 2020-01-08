/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mert Yacan
 */
public class FileReadApp {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/mert/okuBeni.txt");

        BufferedReader textIn = new BufferedReader(new FileReader(file));
        String st;
        try {
            while ((st = textIn.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileReadApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
