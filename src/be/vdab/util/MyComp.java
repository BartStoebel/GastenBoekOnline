/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import be.vdab.gastenboek.GastenboekEntry;
import java.util.Comparator;

/**
 *
 * @author Vinnie
 */
public class MyComp implements Comparator<GastenboekEntry>{
/**
 * Vergelijkt 2 GastenBoekEntries, en sorteert de recentste eerst!
 * @param t
 * @param t1
 * @return 
 */
    @Override
    public int compare(GastenboekEntry t, GastenboekEntry t1) {
        return -t.getTijdstip().compareTo(t1.getTijdstip());
    }
    
}