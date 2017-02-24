/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.gastenboek;

import be.vdab.exception.NewEntryException;
import be.vdab.util.MyComp;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

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
        if (boodschap.length()>60){
            System.out.println("De boodschap is te lang ... deze wordt niet toegevoegd");
            return false;
        } else {
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
    }
    public Set<GastenboekEntry> geefAlleEntriesRecenteEerst(){
        Set<GastenboekEntry> recenteEerst = new TreeSet(new MyComp());
        for (GastenboekEntry e : getGb().getGastenboek()){
            recenteEerst.add(e);
        }
        return recenteEerst;
    } 
    
    public Gastenboek getGb() {
        return gb;
    }
    public final void setGb(Gastenboek gb) {
        this.gb = gb;
    }
}
