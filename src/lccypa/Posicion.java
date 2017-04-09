/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lccypa;

/**
 *
 * @author Armando
 */
public class Posicion {
    int elemento;
    int peso;
    Posicion siguiente;
    public int getPeso() {
        return peso;
    }

    public void setPeso(int p) {
        peso = p;
    }
 
    public Posicion(int dato, int p){
        elemento = dato;
        siguiente = null;
        peso = p;
    }
    
    public int getElemento(){
        return elemento;
    }
    
    public void setElemento(int dato){
        elemento = dato;
    }
    
    public Posicion getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(Posicion dato){
        siguiente = dato;
    }
    
    
}
