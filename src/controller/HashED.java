/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adrianaldairleyvasanchez
 */
public class HashED {
    private 
    private final int tam = 113;
    private String[] tabla = new String[tam];
    
    public int dispersion(String cadena){
        double hashcode;
        double val = 0;
        
        for(int i=0;i<cadena.length();i++){
            val = val + cadena.charAt(i) * Math.pow(31,cadena.length()-(i+1));
        }
        
        hashcode = val%tam;
        tabla[(int)hashcode] = cadena;
        return (int)hashcode;
    }

    public String[] getTabla() {
        return tabla;
    }
    
    
}
