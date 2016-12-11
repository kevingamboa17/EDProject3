package controller;
import java.util.ArrayList;
import model.Tweet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adrianaldairleyvasanchez
 */
public class Hash {
    private Tweet tweet;
    private final int size = 1000;
    private Object[] table = new String[size];

    public Hash() {
    }
    
    
    public int dispersion(){
        String userName = tweet.getUser().getScreen_name();
        double hashcode;
        double val = 0;
        
        /*for(int i=0;i<userName.length();i++){
            val = val + userName.charAt(i) * Math.pow(31,userName.length()-(i+1));
        }*/
        
        val = (userName.length()*278) + 2;
        
        hashcode = val%size;
        
        if(table[(int)hashcode] == null)
            table[(int)hashcode] = tweet.getText();
        else
            solveCollisions((int)hashcode, tweet.getText());
        
        
        return (int)hashcode;
    }

    
    private void solveCollisions(int hashcode, String TweetText){
        if(table[hashcode].getClass().isInstance(new ArrayList())){
            ArrayList list = (ArrayList)table[hashcode];
            list.add(TweetText);
        }else{
            ArrayList list = new ArrayList();
            list.add(table[hashcode]);
            list.add(TweetText);
            table[hashcode] = list;
        }
    }
    
    public Object[] getTable() {
        return table;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
    
    
    
    public static void main(String[] args) {
        Tweet tweet = new Tweet("I'm just testing my code", "AdrianLeyva");
        Hash hash = new Hash();
        hash.setTweet(tweet);
        System.out.println(hash.dispersion());
        System.out.println(hash.getTable()[60]);
    }
    
    
}
