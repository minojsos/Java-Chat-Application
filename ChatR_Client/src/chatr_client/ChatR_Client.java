/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatr_client;

/**
 *
 * @author Minoj
 */
public class ChatR_Client {

    
    private static Users user = null; // Store the currently logged in user
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     * Set the User Object when user logs in.
     * @param userObj 
     */
    public static void setUser(Users userObj) {
        user = userObj;
    }
    
    /**
     * Retrieve the User object to obtain information about the logged in user.
     * @return 
     */
    public static Users getUser() {
        return user;
    }
    
    /**
     * Set the user variable to null when user logs out.
     */
    public static void deleteUser() {
        user = null;
    }
    
}
