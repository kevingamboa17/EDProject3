/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.Objects;

/**
 *
 * @author adrianleyva
 */
public class ArbolBB {
    protected NodoBin raiz;
    
    public ArbolBB(Object o){
        raiz = new NodoBin(o);
    }
    
    public void inOrden(){
        if(raiz!=null)
            raiz.inOrden();
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
    
    public void insertarOrdenado(NodoBin n, Object o){
        if((Integer)o < (Integer)n.getDato())
            if(n.getIzq()==null)
                n.setIzq(new NodoBin(o));
            else
                insertarOrdenado(n.getIzq(), o);
        else
            if((Integer)o > (Integer)n.getDato())
                if(n.getDer()==null)
                    n.setDer(new NodoBin(o));
                else
                    insertarOrdenado(n.getDer(), o);
    }
    
    public boolean buscar(Object o){
        return buscar(raiz,o);
    }
    
    private boolean buscar(NodoBin n, Object o){
        if(Objects.equals((Integer)n.getDato(), (Integer)o)){
            return true;
        }else if((Integer)o > (Integer)n.getDato() && n.getDer()!=null){
                return buscar(n.getDer(),o);
        }else if((Integer)o < (Integer)n.getDato() && n.getIzq()!=null){
            return buscar(n.getIzq(),o);
        }
        return false;
    }
    
    public void borrar(Object o){
        borrar(raiz,o);
    }
    
    private NodoBin borrar(NodoBin n, Object o){
        if(n==null)
            return null;
        else{
            if((Integer)o < (Integer)n.getDato())
                n.setIzq(borrar(n.getIzq(),o));
            else
                if((Integer)o > (Integer)n.getDato())
                    n.setDer(borrar(n.getDer(),o));
                else //Ya encontré el que quiero eliminar
                    if(n.getIzq()!=null && n.getDer()!=null)
                        //Es decir que tiene a los dos hijos
                        //Aplicamos el criterio del más a la izquierda del hijo derecho
                    {
                        NodoBin minimo = buscarMin(n.getDer());
                        n.setDato(minimo.getDato());
                        n.setDer(borrarMin(n.getDer()));
                    }
                    else //No tiene dos hijos, puede tener 1 o ninguno
                        n = (n.getIzq()!=null)? n.getIzq():n.getDer();
        }
        return n;
    }
    
    private NodoBin buscarMin(NodoBin n){
        while(n.getIzq()!=null)
            n.getIzq();
        return n;
    }
    
    private NodoBin borrarMin(NodoBin n){
        if(n.getIzq()!=null){
            n.setIzq(borrarMin(n.getIzq()));
            return n;
        }else{
            return n.getDer();
        }
    }
    
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB((28));
        arbol.insertar(92);
        arbol.insertar(14);
        arbol.insertar(73);
        arbol.insertar(1);
        arbol.insertar(91);
        arbol.insertar(100);
        arbol.insertar(15);
        arbol.insertar(74);
        arbol.insertar(2000);
        arbol.insertar(602);
        //arbol.posOrden();
        /*if(arbol.buscar(15))
            System.out.println("El dato sí se encuentra");
        else
            System.out.println("El dato no se encuentra");
        */
        arbol.borrar(28);
        arbol.inOrden();
    }
}
