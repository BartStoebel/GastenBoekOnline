/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.main;

import be.vdab.exception.NewEntryException;
import be.vdab.gastenboek.Gastenboek;
import be.vdab.gastenboek.GastenboekEntry;
import java.util.ArrayList;
import java.util.List;
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
        String naam = "-";
        String boodschap = "";
        Scanner scanner = new Scanner(System.in);
        Gastenboek gb = new Gastenboek();
        System.out.println("Typ je naam:");
        naam = scanner.nextLine();
        while (!naam.equals("")){
            System.out.println("Typ je boodschap:");
            boodschap = scanner.nextLine();
            try{
                GastenboekEntry ge = new GastenboekEntry(naam, boodschap);
                gb.voegEntryToe(ge);    
            } catch (NewEntryException e){
                System.err.println(e.toString());
                System.err.println("Dit wordt niet toegevoegd in de lijst!");
            }
            System.out.println("Typ je naam:");
            naam = scanner.nextLine();
        }
        for (GastenboekEntry ge : gb.getGastenlijst()){
            System.out.println(ge.toString());
        }
        
        
    }
    
}
