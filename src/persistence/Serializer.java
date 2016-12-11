/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author adrianaldairleyvasanchez
 */
public class Serializer {
    
    public static void serializeObject(String path, Object object)throws IOException,FileNotFoundException{
        FileOutputStream fos = null;
        ObjectOutputStream output = null;
        
        try{
            fos = new FileOutputStream(path);
            output = new ObjectOutputStream(fos);
            output.writeObject(object);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null) 
                    fos.close();
                if(output!=null) 
                    output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static Object deserializeObject(String path) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        ObjectInputStream input = null;
        Object obj = null;
        
        try{
            fis = new FileInputStream(path);
            input = new ObjectInputStream(fis);
            obj = input.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (fis != null) {
                    fis.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return obj;
    }
    
    
}
