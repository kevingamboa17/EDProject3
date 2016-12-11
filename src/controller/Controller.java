/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Tweet;
import persistence.Persistence;

/**
 *
 * @author kevingamboa17
 */
public class Controller {

    public Controller() {
        
    }
    
    public ArrayList<Tweet> getTweets(String fileName){
        Persistence persistence = new Persistence();
        return initProcess(persistence.getLocalTweets(fileName));
    }
    
    private String[] extractUsers(ArrayList<Tweet> array){
        String[] userStrings= new String[array.size()];
        for(int i=0; i<array.size();i++){
            userStrings[i]= ((Tweet) array.get(i)).getUser().getScreen_name();
        }
        return userStrings;
    }
    
    public ArrayList<Tweet> initProcess(ArrayList<Tweet> arrayList){
        Hash hash = new Hash();
        
        return null;
    }
}
