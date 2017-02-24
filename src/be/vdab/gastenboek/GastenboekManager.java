/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.gastenboek;

import be.vdab.exception.NewEntryException;
import java.io.IOException;

/**
 *
 * @author Vinnie
 */
public class GastenboekManager {
    private Gastenboek gb;
    
    public GastenboekManager() throws IOException{
        setGb(new Gastenboek());
    }
    
    public boolean voegEntryToe(String naam, String boodschap){
        try{
            GastenboekEntry ge = new GastenboekEntry(naam, boodschap);
            getGb().voegEntryToe(ge);
            return true;
        } catch (NewEntryException e){
            System.out.println("be.vdab.gastenboek.GastenboekManager.voegEntryToe()" + e.toString());
            System.err.println("Dit wordt niet toegevoegd in de lijst");
            return false;
        }
    }
    
    

    public Gastenboek getGb() {
        return gb;
    }

    public final void setGb(Gastenboek gb) {
        this.gb = gb;
    }
    
    
}
