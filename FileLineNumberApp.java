/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template writeIn, choose Tools | Templates
 * and open the template in the editor.
 */
package mert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mert Yacan
 */
public class FileLineNumberApp {
    
    public static String text = "";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String newLineChar = System.getProperty("line.separator");
        
        String filePath = null;
        BufferedReader textIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Write file location to add numbers.\n");
        try {
            filePath = textIn.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileWriteApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        textIn = null;
        FileWriter writer = null;

        textIn = new BufferedReader(new FileReader(filePath));
        String line = "";
        for (int i = 1; (line =  textIn.readLine()) != null; i++) {
            String nameNumber = String.format("%03d", i);
            nameNumber = nameNumber + " - ";
            text = text + nameNumber + line + newLineChar;
        }

        textIn.close();
        System.out.println(text);
        
        //just to empty the file instead of using printwriter
        File file = new File(filePath);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.setLength(0);
        
        writer = new FileWriter(filePath, true);
        writer.write(text);
        writer.close();
    }

}
