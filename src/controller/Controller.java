/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import avl.ArbolAVL;
import java.io.IOException;
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
    
    public ArrayList<Tweet> getTweets(String fileName) throws IOException{
        Persistence persistence = new Persistence();
        return orderTweets(persistence.getLocalTweets(fileName));
    }
    
    private String[] extractUsers(ArrayList<Tweet> array){
        String[] userStrings= new String[array.size()];
        for(int i=0; i<array.size();i++){
            userStrings[i]= ((Tweet) array.get(i)).getUser().getScreen_name();
        }
        return userStrings;
    }
    
    private ArrayList<Tweet> orderTweets(ArrayList<Tweet> arrayList) throws IOException{
        Hash hash = new Hash();
        ArrayList<Tweet> tweetsOrdened = new ArrayList<>();
        //Create the hash table
        for(Tweet i: arrayList){
            hash.setTweet(i);
            hash.dispersion();
        }
        
        //Create and order the ArbolAVL with the users
        ArbolAVL arbol = new ArbolAVL(extractUsers(arrayList));
        ArrayList<String> usersOrdened =  arbol.getUserAVL(arbol);
        
        //Extract the tweets of the hashtable with the users ordered and make the tweets
        for(String user:usersOrdened){
            if (hash.getHashTableElement(user).getClass().isInstance(new ArrayList<String>())){
                for(String content: (ArrayList<String>)hash.getHashTableElement(user)){
                    tweetsOrdened.add(makeTweet(user, content));
                }
            }
            else
                tweetsOrdened.add(makeTweet(user, (String)hash.getHashTableElement(user)));        
        }
        return tweetsOrdened;
        
    }
    
    public Tweet makeTweet(String users, String tweetContent){
        return new Tweet(tweetContent, users);
    }
}
