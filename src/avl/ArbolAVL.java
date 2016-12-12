/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import persistence.Serializer;

/**
 *
 * @author Marco
 */
public class ArbolAVL implements Serializable{
    protected NodoAVL raiz;


    public ArbolAVL(Object o){
        raiz = new NodoAVL(o);
    }
    
    
    
    public void inOrden(){
        if(raiz!=null)
            raiz.inOrden();
    }
    
    public ArrayList doInOrden(){
        if(raiz!=null)
            return raiz.doInOrden();
        return null;
    }
    
    public void preOrden(){
        if(raiz!=null)
            raiz.preOrden();
    }
    
    public void posOrden(){
        if(raiz!=null)
            raiz.posOrden();
    }
    
    public void insertar(Object o){
        insertarOrdenado(raiz,o);
    }
    
    
    
    private void insertarOrdenado(NodoAVL n, Object o){
        String raiz = (String) n.getDato();
        if(raiz.compareTo((String) o) > 0){
            if(n.getIzq()==null){
                n.setIzq(new NodoAVL(o,null,null,n));
                recalcularFE(n);
            }
            else
                insertarOrdenado((NodoAVL)n.getIzq(),o);
        }
        else{
            if(raiz.compareTo((String) o) < 0){
            if(n.getDer()==null){
                n.setDer(new NodoAVL(o,null,null,n));
                recalcularFE(n);
            }
            else
                insertarOrdenado((NodoAVL)n.getDer(),o);
        }
    }
    }
    
    public void recalcularFE(NodoAVL nodo){
        if(nodo!=null){
            nodo.setFe(NodoAVL.altura((NodoAVL)nodo.getDer())- NodoAVL.altura((NodoAVL)nodo.getIzq()));
            if(nodo.getFe()==2 || nodo.getFe() == -2)
                balancear(nodo);
            else
                recalcularFE(nodo.getPadre());
        }
    }
    
    public void balancear(NodoAVL nodo){
    int feActual = nodo.getFe();
    if(feActual==2){
        switch(((NodoAVL)nodo.getDer()).getFe()){
            case 0:
            case 1:
                rotacionDD(nodo);
                //System.out.println("Rotacion DD");
                break;
            case -1:
                rotacionDI(nodo);
                //System.out.println("Rotacion DI");
                break;
            }
        }
    else{
        switch(((NodoAVL)nodo.getIzq()).getFe()){
            case 0:
            case -1:
                rotacionII(nodo);
                //System.out.println("Rotacion II");
                break;
            case 1:
                rotacionID(nodo);
                //System.out.println("Rotacion ID");
                break;
            }
        }
    }
    
    public void rotacionDD(NodoAVL nodo){
        NodoAVL padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getDer();
        NodoAVL B = (NodoAVL)Q.getIzq();
        
        if(padre!= null)
            if(padre.getDer()==P)
                padre.setDer(Q);
            else
                padre.setIzq(Q);
        else
            raiz= Q;
        //Reconstruir el arbol
        P.setDer(B);
        Q.setIzq(P);
        
        //Reasignar papas
        P.setPadre(Q);
        if(B!=null) B.setPadre(P);
        Q.setPadre(padre);
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
            
    }
    public void rotacionII(NodoAVL nodo){
        NodoAVL padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getIzq();
        NodoAVL B = (NodoAVL)Q.getDer();
        
        if(padre!= null)
            if(padre.getIzq()==P)
                padre.setIzq(Q);
            else
                padre.setDer(Q);
        else
            raiz= Q;
        //Reconstruir el arbol
        P.setIzq(B);
        Q.setDer(P);
        
        //Reasignar papas
        P.setPadre(Q);
        if(B!=null) B.setPadre(P);
        Q.setPadre(padre);
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
    }
    public void rotacionID(NodoAVL nodo){
        NodoAVL padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getIzq();
        NodoAVL R = (NodoAVL)Q.getDer();
        NodoAVL B = (NodoAVL)R.getIzq();
        NodoAVL C = (NodoAVL)R.getDer();
        
        if(padre!= null)
            if(padre.getDer()==nodo)
                padre.setDer(R);
            else
                padre.setIzq(R);
        else
            raiz=R;
        
        //Reconstruir el arbol
        Q.setDer(B);
        P.setIzq(C);
        R.setIzq(Q);
        R.setDer(P);
        
        //Reasignación de los padres
        R.setPadre(padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B!=null) B.setPadre(Q);
        if (C!=null) C.setPadre(P);
        
        //Asignar valores de los FE
        switch(R.getFe()){
            case -1:
                Q.setFe(0);
                P.setFe(1);
                break;
            case 0:
                Q.setFe(0);
                P.setFe(0);
                break;
            case 1:
                Q.setFe(-1);
                P.setFe(0);
                break;
        }
    }
    public void rotacionDI(NodoAVL nodo){
        NodoAVL padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getDer();
        NodoAVL R = (NodoAVL)Q.getIzq();
        NodoAVL B = (NodoAVL)R.getDer();
        NodoAVL C = (NodoAVL)R.getIzq();
        
        if(padre!= null)
            if(padre.getIzq()==nodo)
                padre.setIzq(R);
            else
                padre.setDer(R);
        else
            raiz=R;
        
        //Reconstruir el arbol
        Q.setIzq(B);
        P.setDer(C);
        R.setDer(Q);
        R.setIzq(P);
        
        //Reasignación de los padres
        R.setPadre(padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B!=null) B.setPadre(Q);
        if (C!=null) C.setPadre(P);
        
        //Asignar valores de los FE
        switch(R.getFe()){
            case -1:
                Q.setFe(0);
                P.setFe(1);
                break;
            case 0:
                Q.setFe(0);
                P.setFe(0);
                break;
            case 1:
                Q.setFe(-1);
                P.setFe(0);
                break;
        }
    }
    
    
    
    public ArrayList getUserAVL(ArbolAVL arbol) throws IOException{
        Serializer.serializeObject("ArbolAVL.txt", arbol);
        ArrayList<String> users = ((ArbolAVL)Serializer.deserializeObject("ArbolAVL.txt")).doInOrden();
        return users;
    }
     
    public void createAVL(String[] users){
        for(int i=1;i<users.length;i++){
            insertar(users[i]);
        }
    }
    
}
