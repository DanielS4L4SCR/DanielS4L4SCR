package lccypa;

import java.lang.String;
import java.util.Random;

/**
 *
 * @author Armando Nevares
 */
public class ListaPosicionada {

    int numElementos;
    Posicion cabeza;
    Posicion ultimo;

    //constructor
    ListaPosicionada() {
        cabeza = new Posicion(-1, -1);
        ultimo = new Posicion(-1, -1);
        numElementos = 0;
    }
    /*
    Efecto: Recupera o devuelve el elemento que se encuentra en la posición ‘p’ de la lista ‘L’
    Requiere: La existencia de la lista y que la misma no esté vacía.
    Modifica:
     */
    int recuperar(Posicion p) {
        return p.getElemento();
    }

    /*
    Efecto: Permite modificar el elemento ‘e’ que se encuentra en la posición ‘p’
    de la lista ‘L’.
    Requiere: La existencia de la lista y que la misma no esté vacía.
    Modifica: El elemento de una posición indicada.
     */
    void modificar(Posicion p, int e) {
        p.setElemento(e);
    }

    /*
    Efecto: Devuelve la primera posición de la lista.
    Requiere: Lista inicializada.
    Modifica:
     */
    Posicion primera() {
        return cabeza;
    }

    /*
    Efecto: Es un contador que aumenta uno cuando se inserta y resta uno cuando se borra.
    Requiere: La existencia de la lista.
    Modifica:
     */
    int numElementos() {
        return numElementos;
    }

    ;
    
    /*
    Efecto: Agrega a p2 como la posición siguiente a p1.
    Requiere: La existencia de la lista y de las dos posiciones.
    Modifica: El siguiente de p1.
    */
    void ponerSiguiente(Posicion p1, Posicion p2) {
        p1.setSiguiente(p2);
    }

    /*
    Efecto: Devuelve la posición del próximo elemento.
    Requiere: La existencia de la lista y que la misma no esté vacía.
    Además p una posición valida.
    Modifica:
     */
    Posicion siguiente(Posicion p) {
        return p.getSiguiente();
    }

    /*
    Efecto: Devuelve el último elemento de la lista.
    Requiere: Lista inicializada.
    Modifica:
     */
    Posicion ultimo() {
        return ultimo;
    }

    /*
    Efecto: Verifica si la lista está vacía y devuelve un booleano con verdadero si
    lo está y falso si no lo está.
    Requiere: lista inicializada.
    Modififca:
     */
    boolean vacia() {
        boolean resp = false;

        if (numElementos == 0) {
            resp = true;
        }

        return resp;
    }

    /*
    Efecto: Inserta en la lista, el elemento en la posición p.
    Requiere: La existencia de la lista y p valida.
    Modifica: El número de elementos de la lista.
     */
    void insertar(int e, int peso) { //este insertar es para aristas 
        Posicion nuevo = new Posicion(e, peso);
        if (!vacia()) {
            nuevo.setSiguiente(cabeza);
        } else {
            ultimo = nuevo;
        }
        cabeza = nuevo;
        numElementos++;
    }

    /*
     Efecto: Inserta al final de la lista, se deriva del anterior para respetar el tamaño lógico de la lista.
     Requiere: La existencia de la lista.
     Modifica: El número de elementos de la lista.
     */
    void insertarFinal(int e, int peso) {
        Posicion nuevo = new Posicion(e, peso);

        if (!vacia()) {
            ultimo().setSiguiente(nuevo);
        } else {
            cabeza = nuevo;
        }
        numElementos++;
    }

    /*
     Efecto: Devueleve el elemento anterior a p en la lista L.
     Requiere: La existencia de la lista y que la misma no esté vacía. Además p válida.
     Modifica: 
     */
    Posicion anterior(Posicion p) {
        Posicion tmp = cabeza;

        while (siguiente(tmp) != p) {
            tmp = siguiente(tmp);
        }

        return tmp;
    }

    /*
     Efecto: Borra el elemento ‘p’ de la lista ‘L’, no libera el espacio de memoria.
     Requiere: La existencia de la lista y que la misma no esté vacía. Además la p válida.
     Modifica: El número de elementos de la lista.
     */
    void borrar(Posicion p) {
        Posicion anterior = anterior(p);
        if (siguiente(p) != null) {
            anterior.setSiguiente(siguiente(p));
        } else {
            anterior.setSiguiente(null);
            ultimo = anterior;
        }
    }

    /*
     Efecto: guarda todos los elementos de una lista en un String y los retorna para imprimir.
     Requiere: La existencia de la lista y que la misma no esté vacía.
     Modifica: 
     */
    String imprimir() {
        String str = "";
        Posicion p = cabeza;
        while (siguiente(p) != null) {
            str += p.getElemento() + ",";
            p = siguiente(p);
        }
        str += p.getElemento();
        return str;
    }
 public void imprimir2(){
        System.out.println("Contenido de la lista");
        System.out.println("---------------------");
        Posicion temporal = cabeza; 
        while (temporal != null ) {            
            System.out.println("contenido de la lista: " + temporal.getElemento()); 
            temporal = temporal.getSiguiente();         
        }  
        
 }
    /*
     Efecto: intercambia los elementos de dos posiciones.
     Requiere: La existencia de la lista y que la misma no esté vacía.
     Modifica: los elementos de la lista al cambiar sus valores de lugar 
     */
    void intercambiar(Posicion p1, Posicion p2) {
        int aux = p1.getElemento();
        p1.setElemento(p2.getElemento());
        p2.setElemento(aux);
    }

    /*
     Efecto: devuelve la cabeza de la lista.
     Requiere: La existencia de la lista y que la misma no esté vacía.
     Modifica:  
     */
    Posicion getCabeza() {
        return cabeza;
    }

    public void insertarAleatorio(ListaPosicionada l1, int tam) {
        Random r1 = new Random();
        for (int i = 0; i < tam; i++) {

        }
    }

    public int sumaElementos(ListaPosicionada lista) {
        Posicion apunto = lista.cabeza;
        Posicion p;
        int acum = 0;
        while (apunto != null) {
            p = apunto.getSiguiente();
            while (p != null) {
                acum += lista.recuperar(apunto);
                p = p.getSiguiente();
            }
            apunto = apunto.getSiguiente();
        }
        return acum;
    }

    /*public int menor(ListaPosicionada lista) {
         
        int result = lista.recuperar(cabeza);
        for (int i = 0; i < lista.numElementos; i++) {
            if (lista.recuperar(i) < result) {
                result = lista.recuperar(i);
            }
        }
        return result;
    }*/
    public ListaPosicionada ordenarPorSelección(ListaPosicionada lista) {
        ListaPosicionada l = lista;
        Posicion apunto = lista.cabeza;
        Posicion p;
        Posicion menor = lista.cabeza;
        while (apunto != null) {
            p = apunto.getSiguiente();
            while (p != null) {
                if (menor.getElemento() > p.getElemento()) {
                    menor = p;
                }
                p = p.getSiguiente();
            }
            lista.intercambiar(apunto, menor);
            apunto = apunto.getSiguiente();
            menor = apunto;
        }
        return l;
    }

    public ListaPosicionada Burbuja(ListaPosicionada lista) {
        ListaPosicionada l = lista;
        Posicion apunto = lista.cabeza;
        Posicion p;
        while (apunto != null) {
            p = apunto.getSiguiente();
            while (p != null) {
                if (apunto.getElemento() > p.getElemento()) {
                    lista.intercambiar(apunto, p);
                }
                p = p.getSiguiente();
            }
            apunto = apunto.getSiguiente();
        }
        return l;
    }

    public void eliminar(int index) {
        if (index == 0) {
            cabeza = cabeza.getSiguiente();
        } else {
            int contador = 0;
            Posicion temporal = cabeza;
            while (contador < index - 1) {
                temporal = temporal.getSiguiente();
                contador++;
            }
            temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
        }
        numElementos--;
    }
}
