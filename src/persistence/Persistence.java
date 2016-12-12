/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import model.Tweet;

/**
 *
 * @author kevingamboa17
 */
public class Persistence {
    

    public Persistence() {
        
    }
    
    public ArrayList<Tweet> getLocalTweets(String fileName){
        ArrayList<Tweet> arrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fileName));

            for(int i=0; i<1000; i++){
              //while(sc.hasNextLine()) {
                arrayList.add(makeTweet(sc.nextLine()));
              //}  
            }

            
        } 
        catch (Exception e) {
            System.out.println("Algo salió mal :C");
        }
        return arrayList;
    }
    
    
    public Tweet makeTweet(String line){
        String[] tweetStrings=line.split("@");
        String user= tweetStrings[tweetStrings.length-1] ;
        String tweet="";
        for(int i=0;i<tweetStrings.length-1;i++){
            tweet += tweetStrings[i];
        }
        return new Tweet(tweet, user);
    }
}
