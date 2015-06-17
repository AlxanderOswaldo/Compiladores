package Graficador;

import java.io.Serializable;

public class Enlace implements Serializable{
    private Arista arista;
    private NodoG nodo;

    /**
     * Constructor for objects of class Arista
     */
    public Enlace(){
        // initialise instance variables
        this(new Arista(),new NodoG());
    }
    public Enlace(Arista arista,NodoG nodo){
        // initialise instance variables
        this.arista = arista;
        this.nodo = nodo;
    }
    public void setArista(Arista arista){
        this.arista = arista;
    }
    public Arista getArista(){
        return arista;
    }
    public void setNodo(NodoG nodo){
        this.nodo = nodo;
    }
    public NodoG getNodo(){
        return nodo;
    }
}
