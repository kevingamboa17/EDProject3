package controller;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import model.Tweet;
import persistence.Serializer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adrianaldairleyvasanchez
 */
public class Hash implements Serializable{
    
    private Tweet tweet;
    private final int size = 1000;
    private Object[] table = new Object[size];

    public Hash() {
    }
    
    
    public int dispersion(){
        String userName = tweet.getUser().getScreen_name();
        double hashcode = 0;
        double val = 0;
        
        /*for(int i=0;i<userName.length();i++){
            val = val + userName.charAt(i) * Math.pow(31,userName.length()-(i+1));
        }*/
        
        val = (userName.length()*5);
        
        hashcode = val%size;
        if(table[(int)hashcode] == null)
            table[(int)hashcode] = tweet.getText();
        else
            solveCollisions((int)hashcode, tweet.getText());
        
        
        return (int)hashcode;
    }
    
    public Object getHashTableElement(String user){
        String userName = user;
        double hashcode = 0;
        double val = 0;
        
        /*for(int i=0;i<userName.length();i++){
            val = val + userName.charAt(i) * Math.pow(31,userName.length()-(i+1));
        }*/
        
        val = (userName.length()*5);
        
        hashcode = val%size;
        
        
        return table[(int)hashcode];
    }

    
    private void solveCollisions(int hashcode, String TweetText){
        if(table[hashcode].getClass().isInstance(new ArrayList<String>())){
            ArrayList<String> list = (ArrayList<String>)table[hashcode];
            list.add(TweetText);
        }else{
            ArrayList<String> list = new ArrayList<>();
            list.add((String)table[hashcode]);
        }
    }
    
    public Object[] getTable() throws IOException{
        Serializer.serializeObject("hashtable.txt", table);
        return (Object[])Serializer.deserializeObject("hashtable.txt");
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        Tweet tweet = new Tweet("This is another test to proof my code", "AdrianLeyvaSanchez");
        Tweet tweet2 = new Tweet("This is another test to proof my code22", "Leyva");
        
        Hash hash = new Hash();
        hash.setTweet(tweet);
        System.out.println(hash.dispersion());
        System.out.println(hash.getTable()[90]);

        hash.setTweet(tweet2);
        System.out.println(hash.dispersion());
        System.out.println(hash.getTable()[25]);
    }
    
    
}
