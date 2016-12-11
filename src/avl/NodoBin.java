/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class NodoBin {
    protected Object dato;
    protected NodoBin izq;
    protected NodoBin der;

    public NodoBin(Object dato, NodoBin izq, NodoBin der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public NodoBin(Object dato) {
        this.dato = dato;
    }

    public NodoBin() {
    }
    
    //IRD
    public void inOrden(){
        
        if(izq!=null)
            izq.inOrden();
        System.out.println(dato);
        if(der!=null)
            der.inOrden();
        
        
    }
    
    public void preOrden(){
        
        System.out.println(dato);
        if(izq!=null)
            izq.preOrden();
        if(der!=null)
            der.preOrden();
        
        
    }
    
    public void posOrden(){
        
        if(izq!=null)
            izq.posOrden();
        if(der!=null)
            der.posOrden();
        
        System.out.println(dato);
        
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoBin getIzq() {
        return izq;
    }

    public void setIzq(NodoBin izq) {
        this.izq = izq;
    }

    public NodoBin getDer() {
        return der;
    }

    public void setDer(NodoBin der) {
        this.der = der;
    }
    
    
    
}
