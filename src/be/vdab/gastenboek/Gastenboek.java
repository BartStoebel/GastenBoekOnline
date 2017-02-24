/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.gastenboek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinnie
 */
public class Gastenboek {
    private List<GastenboekEntry> gastenboek;
    private File file;
    /**
     * Lees alle entries in het gastenboek.txt, en steek in List gastenboek
     */
    public Gastenboek() throws IOException{
        gastenboek = new ArrayList<>();
        this.file = new File("gastenboek.txt"); 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));){
            int size = ois.readInt();
            for (int i = 0; i < size ; i++){
                GastenboekEntry ge = (GastenboekEntry) ois.readObject();
                getGastenboek().add(ge);                
            }
        }catch(IOException e){ 
            throw e;            //throw this exception!!
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gastenboek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * voeg Entry toe aan de gestenlijst, en aan gastenboek.txt
     * @param ge
     * @return 
     */
    public boolean voegEntryToe(GastenboekEntry ge){
        gastenboek.add(ge);
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new 
                FileOutputStream(file));){
            oos.writeInt(getGastenboek().size());
            for (GastenboekEntry allge : getGastenboek()){
                oos.writeObject(allge);
            }
        } catch(IOException e){
            System.err.println("Schrijven niet gelukt");
        }
        return true;
    }
    
    public Set<GastenboekEntry> geefAlleEntriesRecenteEerst(){
        Set<GastenboekEntry> recenteEerst = new TreeSet(new MyComp());
        for (GastenboekEntry e : getGastenboek()){
            recenteEerst.add(e);
        }
        return recenteEerst;
    }

    @Override
    public String toString() {
        String temp = "";
        for (GastenboekEntry ge : gastenboek){
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
            return getGastenboek().equals(ge.getGastenboek());
        }
    }

    public List<GastenboekEntry> getGastenboek() {
        return gastenboek;
    }

    public void setGastenboek(List<GastenboekEntry> gastenboek) {
        this.gastenboek = gastenboek;
    }
    
    
    
}
class MyComp implements Comparator<GastenboekEntry>{

    @Override
    public int compare(GastenboekEntry t, GastenboekEntry t1) {
        return -t.getTijdstip().compareTo(t1.getTijdstip());
    }
    
}
