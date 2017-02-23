/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.gastenboek;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinnie
 */
public class Gastenboek {
    private List<GastenboekEntry> gastenlijst;
    
    public Gastenboek(){
        gastenlijst = new ArrayList<>();
    }
    
    public boolean voegEntryToe(GastenboekEntry ge){
        gastenlijst.add(ge);
        return true;
    }
    
    public List<GastenboekEntry> geefAlleEntries(){
        return getGastenlijst();
    }

    @Override
    public String toString() {
        String temp = "";
        for (GastenboekEntry ge : gastenlijst){
            temp = temp + ge.toString();
        }
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Gastenboek)){
            return false;
        } else {
            Gastenboek ge = (Gastenboek) o;
            return getGastenlijst().equals(ge.getGastenlijst());
        }
    }

    public List<GastenboekEntry> getGastenlijst() {
        return gastenlijst;
    }

    public void setGastenlijst(List<GastenboekEntry> gastenlijst) {
        this.gastenlijst = gastenlijst;
    }
    
    
    
}
