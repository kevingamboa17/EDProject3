/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import arboles.NodoBin;



/**
 *
 * @author Marco
 */
public class NodoAVL extends NodoBin{
    protected int fe;
    protected NodoAVL padre;
    
    public NodoAVL(){
        
    }
    
    public NodoAVL(Object dato){
        super(dato);
    }

    public NodoAVL(Object dato, NodoBin izq, NodoBin der) {
        super(dato, izq, der);
    }

    public NodoAVL(Object dato, NodoBin izq, NodoBin der, NodoAVL padre) {
        super(dato, izq, der);
        this.padre = padre;
    }

    public static int altura(NodoAVL a){
        if(a==null)
            return -1;
        else
            return 1 + Math.max(altura((NodoAVL)a.getIzq()), altura((NodoAVL)a.getDer()));
    }
    
    public void inOrden(){
        if(izq!=null)
            izq.inOrden();
        System.out.println(dato+" FE:" + fe);
        if(der!=null)
            der.inOrden();
    }
    
    public void preOrden(){
        System.out.println(dato+" FE:" + fe);
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
        System.out.println(dato+" FE:" + fe);
    }
    
    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public NodoAVL getPadre() {
        return padre;
    }

    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }
    
    
}
