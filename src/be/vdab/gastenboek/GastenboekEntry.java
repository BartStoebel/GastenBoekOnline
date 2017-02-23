/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.gastenboek;

import be.vdab.exception.NewEntryException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Vinnie
 */
public class GastenboekEntry implements Comparable<GastenboekEntry>{
    private LocalDateTime tijdstip;
    private String schrijver;
    private String boodschap;
    
    public GastenboekEntry(String schrijver, String boodschap) throws NewEntryException{
        setTijdstip(LocalDateTime.now());
        setSchrijver(schrijver);
        setBoodschap(boodschap);
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public final void setTijdstip(LocalDateTime tijdstip) {
        if(tijdstip != null ){
            this.tijdstip = tijdstip;
        } else {
            this.tijdstip = LocalDateTime.now();
        }
    }

    public String getSchrijver() {
        return schrijver;
    }

    public final void setSchrijver(String schrijver) throws NewEntryException {
        if(schrijver != null && !schrijver.isEmpty()){
            this.schrijver = schrijver;
        } else {
            throw new NewEntryException("Naam schrijver is niet opgegeven", "");
        }
    }

    public String getBoodschap() {
        return boodschap;
    }

    public final void setBoodschap(String boodschap) throws NewEntryException {
        if(boodschap != null && !boodschap.isEmpty()){
            this.boodschap = boodschap;
        } else {
            throw new NewEntryException("Geen boodschap is ingegeven", "");
        }
    }

    @Override
    public String toString() {
        return "GastenboekEntry{" + "tijdstip= " + tijdstip + ", schrijver= " + schrijver + ", boodschap= " + boodschap + '}';
    }

    @Override
    public int compareTo(GastenboekEntry t) {
        return this.getTijdstip().compareTo(t.getTijdstip());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof GastenboekEntry)){
            return false;
        } else{
            GastenboekEntry ge = (GastenboekEntry) o;
            if (this.getBoodschap() == ge.getBoodschap() && this.getTijdstip() == ge.getTijdstip()){
                return true;
            }
        }
        
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return 5*71*Objects.hashCode(this.tijdstip);
    }
}
