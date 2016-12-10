/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author adrianaldairleyvasanchez
 */
public class ArbolAVL {
    protected NodoAVL raiz;
    
    public ArbolAVL(Object o){
        raiz = new NodoAVL(o);
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
    
    private void insertarOrdenado(NodoAVL n, Object o){
        if((Integer)o < (Integer)n.getDato()){
            if(n.getIzq() == null){
                n.setIzq(new NodoAVL(o,null,null,n));
                recalcularFE(n);
            }else{
                insertarOrdenado((NodoAVL)n.getIzq(),o);
            }
        }else{
            if((Integer)o > (Integer)n.getDato()){
                if(n.getDer() == null){
                    n.setDer(new NodoAVL(o,null,null,n));
                    recalcularFE(n);
                }else{
                    insertarOrdenado((NodoAVL)n.getDer(),o);
                }
            }
        }
    }
    
    public void recalcularFE(NodoAVL nodo){
        if(nodo!=null){
            nodo.setFe(NodoAVL.altura((NodoAVL)nodo.getDer())-
                                        NodoAVL.altura((NodoAVL)nodo.getIzq()));
        
            if(nodo.getFe()==2 || nodo.getFe() == -2){
                balancear(nodo);
            }else{
                recalcularFE(nodo.getPadre());
            }
        }
    }
    
    public void balancear(NodoAVL nodo){
        int feActual = nodo.getFe();
        if(feActual == 2){
            switch(((NodoAVL)nodo.getDer()).getFe()){
                case 0:
                    break;
                case 1:
                    rotacionDD(nodo);
                    System.out.println("Rotación DD");
                    break;
                case -1:
                    rotacionDI(nodo);
                    System.out.println("Rotación DI");
                    break;
            }
        }else{
            switch(((NodoAVL)nodo.getDer()).getFe()){
                case 0:
                    break;
                case -1:
                    rotacionII(nodo);
                    System.out.println("Rotación II");
                    break;
                case 1:
                    rotacionID(nodo);
                    System.out.println("Rotación ID");
                    break;
            }
        }
    }
    
    public void rotacionDD(NodoAVL nodo){
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getDer();
        NodoAVL B = (NodoAVL)Q.getIzq();
        
        if(Padre!=null)
            if(Padre.getDer()==P)
                Padre.setDer(Q);
            else
                Padre.setIzq(Q);
        else
            raiz = Q;
        
        //Reconstruir el árbol
        P.setDer(B);
        Q.setIzq(P);
        
        //Reasignar padres
        P.setPadre(Q);
        if(B!=null)
            B.setPadre(P);
        Q.setPadre(Padre);
        
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
    }
    
    public void rotacionII(NodoAVL nodo){
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getIzq();
        NodoAVL B = (NodoAVL)Q.getDer();
        
        if(Padre!=null)
            if(Padre.getIzq()==P)
                Padre.setIzq(Q);
            else
                Padre.setDer(Q);
        else
            raiz = Q;
        
        //Reconstruir el árbol
        P.setIzq(B);
        Q.setDer(P);
        
        //Reasignar padres
        P.setPadre(Q);
        if(B!=null)
            B.setPadre(P);
        Q.setPadre(Padre);
        
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
    }
    
    public void rotacionID(NodoAVL nodo){
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getIzq();
        NodoAVL R = (NodoAVL)Q.getDer();
        NodoAVL B = (NodoAVL)R.getIzq();
        NodoAVL C = (NodoAVL)R.getDer();
        
        if(Padre!=null)
            if(Padre.getDer()==nodo)
                Padre.setDer(R);
            else
                Padre.setIzq(R);
        else
            raiz = R;
        
        //Reconstruir el árbol
        Q.setDer(B);
        P.setIzq(C);
        R.setIzq(Q);
        R.setDer(P);
        
        //Reasignar padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if(B!=null)
            B.setPadre(Q);
        if(C!=null)
            C.setPadre(P);
        
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
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL)P.getDer();
        NodoAVL R = (NodoAVL)Q.getIzq();
        NodoAVL B = (NodoAVL)R.getDer();
        NodoAVL C = (NodoAVL)R.getIzq();
        
        if(Padre!=null)
            if(Padre.getIzq()==nodo)
                Padre.setIzq(R);
            else
                Padre.setDer(R);
        else
            raiz = R;
        
        //Reconstruir el árbol
        Q.setIzq(B);
        P.setDer(C);
        R.setDer(Q);
        R.setIzq(P);
        
        //Reasignar padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if(B!=null)
            B.setPadre(Q);
        if(C!=null)
            C.setPadre(P);
        
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
    
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL((5));
        arbol.insertar(56);
        arbol.insertar(8);
        arbol.insertar(91);
        arbol.insertar(205);
        arbol.insertar(512);
        arbol.insertar(30);
        arbol.insertar(602);
        
        arbol.inOrden();
    }
}
