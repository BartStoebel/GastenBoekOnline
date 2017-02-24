/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.main;

import be.vdab.exception.NewEntryException;
import be.vdab.gastenboek.GastenboekEntry;
import be.vdab.gastenboek.GastenboekManager;
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
        String naam = "";
        String boodschap;
        Scanner scanner = new Scanner(System.in);
        GastenboekManager gbm = new GastenboekManager();
        System.out.println("Typ je naam:");
        naam = scanner.nextLine();
        
        while (naam!=null && 
                !naam.equals("")){
            System.out.println("Typ je boodschap:");
            boodschap = scanner.nextLine();
            gbm.voegEntryToe(naam, boodschap);
            System.out.println("Typ je naam:");
            naam = scanner.nextLine();
        }
        for (GastenboekEntry ge : gbm.getGb().geefAlleEntries()){
            System.out.println(ge.toString());
        }
        
        
    }
    
}
