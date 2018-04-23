/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minoj.chat;

import com.minoj.chat.service.MessagesFacadeREST;
import com.minoj.chat.service.ThreadsFacadeREST;
import com.minoj.chat.service.UsersFacadeREST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.Query;

/**
 *
 * @author Minoj
 */
@WebService(serviceName = "ChatR")
public class ChatR {

    @EJB
    private MessagesFacadeREST messagesFacadeREST;

    @EJB
    private ThreadsFacadeREST threadsFacadeREST;

    @EJB
    private UsersFacadeREST usersFacadeREST;


    /**
     * Web service operation to register.
     * @param login_id Login ID of the user that needs to be created.
     * @param nickname Nickname of the user that needs to be created.
     * @param password Password of the user that needs to be created.
     * @return true - If registration is successful, false - If registration has failed.
     * @throws com.minoj.chat.AlreadyExistsException If Login ID already exists or if the Nickname already exists.
     */
    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "login_id") String login_id, @WebParam(name = "nickname") String nickname, @WebParam(name = "password") String password) throws AlreadyExistsException {
        Users user;
        
        try {
        
            Query query = usersFacadeREST.getEntityManager().createNamedQuery("Users.findByLoginId").setParameter("loginId", login_id);
            List rs = query.getResultList();
        
            // Check if Login ID and Nickname already exists
        
            if(rs != null) {
                // Login ID Exists
                if(rs.size() > 0) {
                    for(int i = 0; i < rs.size(); i++) {
                        Users u = (Users) rs.get(i);
                    
                        if(u.getLoginId().equals(login_id)) {
                            throw new AlreadyExistsException("Login ID Already exists!");
                        }
                    }
                } else {
                    // Check if Nickname exists if Login ID doesn't
                    query = usersFacadeREST.getEntityManager().createNamedQuery("Users.findByNickname").setParameter("nickname", nickname);
                    rs = query.getResultList();
        
                    if(rs != null) {
                        if(rs.size() > 0) {
                            for(int i = 0; i < rs.size(); i++) {
                                Users u = (Users) rs.get(i);
                            
                                if(u.getNickname().equals(nickname)) {
                                    throw new AlreadyExistsException("Nickname Already exists!");
                                }
                            }
                        } else {
                            // If Nickname also doesn't exist already (Login ID doesn't exist)
                            user = new Users();
                            user.setLoginId(login_id);
                            user.setNickname(nickname);
                            user.setPassword(password);
                            user.setRegisteredDate(new Date());
                        
                            usersFacadeREST.create(user);
                        
                            return true;
                        }
                    }
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return false;
    }

    /**
     * Web service operation to login
     * Check if entered Login ID exists and matches with the input password.
     * @param login_id
     * @param password
     * @return true - If user exists, false - If user with the provided Login ID and Password combination doesn't exist.
     * @throws com.minoj.chat.LoginErrorException If Login ID doesn't exist or Login ID and password combination doesn't exist.
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "login_id") String login_id, @WebParam(name = "password") String password) throws LoginErrorException{
        
        Query query = usersFacadeREST.getEntityManager().createNamedQuery("Users.findByLoginId").setParameter("loginId", login_id);
        List rs = query.getResultList();
        
        if(rs != null) {
            // If Login ID Exists
            if(rs.size() > 0) {
                for(int i = 0; i < rs.size(); i++) {
                    Users u = (Users) rs.get(i);
                    
                    // If Password matches with the Login ID
                    if (u.getPassword().equals(password)) {
                        return true;
                    } else {
                        throw new LoginErrorException();
                    }
                }
            } else {
                throw new LoginErrorException();
            }
        } else {
            throw new LoginErrorException();
        }
        
        return false;
    }

    /**
     * Web service operation to retrieve the threads
     * @return List<Threads> A List of Threads
     */
    @WebMethod(operationName = "getThreads")
    public List<Threads> getThreads() {
        
        List<Threads> threads = threadsFacadeREST.findAll();
        
        return threads;
    }

    /**
     * Web service operation to retrieve the messages of a specific thread.
     * @param thread of which the messages need to be retrieved.
     * @return List<Messages> A List of Messages belonging to the specific thread
     */
    @WebMethod(operationName = "getMessages")
    public List<Messages> getMessages(@WebParam(name = "thread_id") Threads thread) {
        
        Query query = messagesFacadeREST.getEntityManager().createNamedQuery("Messages.findByThread").setParameter("thread", thread);
        List<Messages> messages = query.getResultList();
        
        return messages;
    }

    /**
     * Web service operation to retrieve the user given the login id of the user.
     * @param login_id Login ID of the user
     * @return Users Object of the user.
     */
    @WebMethod(operationName = "getUsers")
    public Users getUsers(@WebParam(name = "login_id") String login_id) {
        
        Query query = usersFacadeREST.getEntityManager().createNamedQuery("Users.findByLoginId").setParameter("loginId", login_id);
        List rs = query.getResultList();
        
        return (Users) rs.get(0);
    }

    /**
     * Web service operation to update the Password.
     * @param user User of whom the password needs to be updated.
     * @return true - if password updates successfully, false - if password update failed.
     */
    @WebMethod(operationName = "updatePassword")
    public boolean updatePassword(@WebParam(name = "user") Users user) {
        try {
            usersFacadeREST.edit(user.getId(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Web service operation to create a New Thread.
     * @param thread Thread that needs to be created
     * @return true - if thread has been created successfully, false - if thread creation has failed.
     */
    @WebMethod(operationName = "createThread")
    public boolean createThread(@WebParam(name = "thread") Threads thread) {
        try {
            threadsFacadeREST.create(thread);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Web service operation to update a Thread.
     * @param thread Thread that needs to be updated - Contains the updated data.
     * @return true - if thread has been updated successfully, false - if thread update has failed.
     */
    @WebMethod(operationName = "updateThread")
    public boolean updateThread(@WebParam(name = "thread") Threads thread) {
        try {
            threadsFacadeREST.edit(thread.getId(), thread);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Web service operation to create a Message.
     * @param message Message that needs to be created.
     * @return true - if message has been created, false - if message creation failed.
     */
    @WebMethod(operationName = "createMessage")
    public boolean createMessage(@WebParam(name = "message") Messages message) {
        try {
            messagesFacadeREST.create(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Web service operation to Search Threads by title.
     * @param title Search Term used to search the title of threads.
     * @return List<Threads> containing the result of the Search.
     */
    @WebMethod(operationName = "findThreadByTitle")
    public List<Threads> findThreadByTitle(@WebParam(name = "title") String title) {
        
        Query query = threadsFacadeREST.getEntityManager().createNamedQuery("Threads.searchByTitle").setParameter("title", "%"+title+"%");
        List rs = query.getResultList();
        
        return rs;
    }

    /**
     * Web service operation to retrieve the Participants of a Thread.
     * @param thread Participants of the specified thread will be retrieved.
     * @return List<Users> containing the participants of specified Thread.
     */
    @WebMethod(operationName = "getParticipants")
    public List<Users> getParticipants(@WebParam(name = "thread") Threads thread) {
        
        Query query = messagesFacadeREST.getEntityManager().createNamedQuery("Messages.distinctAuthor").setParameter("thread", thread);
        List rs = query.getResultList();
        
        return rs;
    }

    /**
     * Web service operation to retrieve the Personal Messages.
     * @param author Author / Receiver of the Personal Messages that needs to be retrieved.
     * @param receiver Author / Receiver of the Personal Messages that needs to be retrieved.
     * @return List<Messages> containing the personal messages between the two specified users.
     */
    @WebMethod(operationName = "getPersonalMessages")
    public List<Messages> getPersonalMessages(@WebParam(name = "author") Users author, @WebParam(name = "receiver") Users receiver) {
        
        // Messages where Receiver - receiver and Author - author.
        Query query = messagesFacadeREST.getEntityManager().createNamedQuery("Messages.findByReceiver").setParameter("receiver", receiver).setParameter("author", author);
        List rs1 = query.getResultList();
        
        // Messages where Receiver - author and Author - receiver.
        query = messagesFacadeREST.getEntityManager().createNamedQuery("Messages.findByReceiver").setParameter("receiver", author).setParameter("author", receiver);
        List rs2 = query.getResultList();
        
        // Add the Two resulting lists
        List rs = new ArrayList();
        rs.addAll(rs1);
        rs.addAll(rs2);
        
        // Sort the list according to the date - ascending order
        Collections.sort(rs, new Comparator<Messages>() {
            @Override
            public int compare(Messages o1, Messages o2) {
                return o1.getPostedAt().compareTo(o2.getPostedAt());
            }
            
        });
        
        return rs;
    }

}
