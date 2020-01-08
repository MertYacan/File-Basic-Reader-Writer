/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static mert.FileLineNumberApp.text;

/**
 *
 * @author Mert Yacan
 */
public class LineNumberProgram {

    public static char choice;
    public static File file;
    public static String filePath;
    public static Boolean isFileOpen = false;
    public static BufferedReader textIn = null;
    public static FileWriter textOut = null;
    public static String line = "";
    public static String text = "";

    public static String getNumber(int i) {
        String number = String.format("%03d", i);
        return number + " - ";
    }

    public static void showMenu() {
        System.out.println("------------");
        System.out.println("1) Select file");
        System.out.println("2) Display the file");
        System.out.println("3) Add line numbers");
        System.out.println("4) Remove line numbers");
        System.out.println("5) Exit");
        System.out.println("Please choose what to do: ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String newLineChar = System.getProperty("line.separator");

        showMenu();
        Scanner sc = new Scanner(System.in);

        for (;;) {
                switch (choice = sc.nextLine().charAt(0)) {
                    case '1':
                        System.out.println("Please enter the file location.");
                        filePath = sc.nextLine();
                        isFileOpen = true;
                        showMenu();
                        break;
                    case '2':
                        if (isFileOpen) {
                            try {
                                textIn = new BufferedReader(new FileReader(filePath));
                                while ((line = textIn.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(LineNumberProgram.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(LineNumberProgram.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            System.out.println("Please pick a file first.");
                        }
                        showMenu();
                        break;
                    case '3':
                        if (isFileOpen) {
                            try {
                                BufferedReader textIn = new BufferedReader(new InputStreamReader(System.in));

                                textIn = new BufferedReader(new FileReader(filePath));
                                String line = "";
                                for (int i = 1; (line = textIn.readLine()) != null; i++) {
                                    String nameNumber = String.format("%03d", i);
                                    nameNumber = nameNumber + " - ";
                                    text = text + nameNumber + line + newLineChar;
                                    System.out.println(text);
                                }

                                textIn.close();

                                //just to empty the file instead of using printwriter
                                File file = new File(filePath);
                                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                                raf.setLength(0);

                                textOut = new FileWriter(filePath, true);
                                textOut.write(text);
                                textOut.close();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(LineNumberProgram.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(LineNumberProgram.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            System.out.println("Please pick a file first.");
                        }
                        showMenu();
                        break;

                    case '4':
                        try {
                            textIn = new BufferedReader(new FileReader(filePath));
                            text = new String();
                            while ((line = textIn.readLine()) != null) {
                                if (line.length() >= 5
                                        && Character.isDigit(line.charAt(0))
                                        && line.charAt(4) == '-') {
                                    text += line.substring(6) + newLineChar;
                                } else {
                                    text += line + newLineChar;
                                }

                            }
                            textIn.close();

                            //just to empty the file instead of using printwriter
                            file = new File(filePath);
                            RandomAccessFile raf = new RandomAccessFile(file, "rw");
                            raf.setLength(0);

                            textOut = new FileWriter(filePath, true);
                            textOut.write(text);
                            textOut.close();
                            showMenu();
                            break;
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(LineNumberProgram.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(LineNumberProgram.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    case '5':
                        System.out.println("ikiye bastýn");
                        return;
                    default:
                        System.out.println("Unknown command. Please try again.");
                        showMenu();
                }
            }
        }
    }
