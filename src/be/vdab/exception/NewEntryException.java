/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.exception;

/**
 *
 * @author Vinnie
 */
public class NewEntryException extends Exception{
    private String message;
    
    public NewEntryException(String error, String message){
        super(error);
        setMessage(message);
    }

    public String getMessage() {
        return message; 
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
