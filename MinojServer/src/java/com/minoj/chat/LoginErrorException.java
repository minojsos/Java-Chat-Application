/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minoj.chat;

/**
 *
 * @author Minoj
 */
public class LoginErrorException extends Exception {
    
    public LoginErrorException() {
        super("Invalid Login ID or Password");
    }
    
}

class AlreadyExistsException extends Exception {
    
    public AlreadyExistsException() {
    
    }
    
    public AlreadyExistsException(String message) {
        super(message);
    }
    
}
