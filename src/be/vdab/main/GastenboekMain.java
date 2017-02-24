/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.main;

import be.vdab.exception.NewEntryException;
import be.vdab.gastenboek.GastenboekEntry;
import be.vdab.gastenboek.GastenboekManager;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vinnie
 */
public class GastenboekMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef je keuze in: \n   * 1 voor lezen van gastenboek"
                + "\n   * 2 voor nieuwe boodschap ingeven \n   * 3 voor einde");
        String input = scanner.nextLine();
        while(input.equals("1") && input.equals("2") && input.equals("3")){
            System.out.println("Geef een correcte keuze in: \n   * 1 voor lezen van gastenboek"
                + "\n   * 2 voor nieuwe boodschap ingeven \n   * 3 voor einde");
            input = scanner.nextLine();
        }
        while (input == "1" || input == "2"){
            try{
                GastenboekManager gbm = new GastenboekManager();
                if (input == "1"){  
                    for (GastenboekEntry ge : gbm.geefAlleEntriesRecenteEerst()){
                        System.out.println(ge.toString());
                    }
                } else if(input == "2"){
                    String naam = "";
                    String boodschap;
                    System.out.println("Typ je naam:");
                    naam = scanner.nextLine();
                    while (naam!=null && !naam.equals("")){
                        System.out.println("Typ je boodschap:");
                        boodschap = scanner.nextLine();
                        gbm.voegEntryToe(naam, boodschap);
                        System.out.println("Typ je naam:");
                        naam = scanner.nextLine();
                    }
                }

            } catch (IOException e){
                System.err.println("be.vdab.main.GastenboekMain.main()" +  e.getMessage());
            }
            System.out.println("Geef je keuze in: \n   * 1 voor lezen van gastenboek"
                    + "\n   * 2 voor nieuwe boodschap ingeven \n   * 3 voor einde");
            input = scanner.nextLine();
        }
    }
}
