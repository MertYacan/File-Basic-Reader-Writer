/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template textOut, choose Tools | Templates
 * and open the template in the editor.
 */
package mert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mert Yacan
 */
public class FileWriteApp {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileLoc = null;
        BufferedReader textIn = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Please enter file location.\n");
        try {
            fileLoc = textIn.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileWriteApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintWriter textOut = new PrintWriter(new BufferedWriter( new FileWriter(fileLoc)) );
			System.out.println("File is open. Now you can write into. Write \"end\" when you finish writing.");
			String line = textIn.readLine();
			while ( !line.equals("end") ) {
				textOut.println(line);
				line = textIn.readLine();
			}
                        textOut.close();
    }
    
}
