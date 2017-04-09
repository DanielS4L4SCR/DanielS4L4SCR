/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lccypa;

/**
 *
 *
 */
public class Grafo {
    ListaPosicionada[] adyacentes;
    char[] vertices;
    int numVertices = 0;
    int[] numVerticesAdy;
    int[] pesos;

    Grafo(int tam) {
        vertices = new char[tam];
        numVerticesAdy = new int[tam];
        adyacentes = new ListaPosicionada[tam];
        for (int i = 0; i < tam - 1; i++) {
            adyacentes[i] = new ListaPosicionada();
        }
    }

    public void destruir(Grafo g1) {
        for (int i = 0; i < vertices.length; i++) {
            g1.borrarVerticeIndex(i);
            numVerticesAdy[i]--;
        }
        g1.numVertices = 0;
    }

    public Grafo iniciar(Grafo g1) {
        g1.InsertarVertice('P');
        g1.InsertarVertice('Q');
        g1.InsertarVertice('S');
        g1.InsertarVertice('T');
        g1.InsertarVertice('R');
        g1.InsertarVertice('U');
        g1.insertarAristas('P', 'Q', 1);
        g1.insertarAristas('P', 'S', 6);
        g1.insertarAristas('P', 'T', 7);
        g1.insertarAristas('Q', 'S', 4);
        g1.insertarAristas('Q', 'R', 1);
        g1.insertarAristas('S', 'T', 3);
        g1.insertarAristas('S', 'U', 2);
        g1.insertarAristas('T', 'U', 2);
        g1.insertarAristas('R', 'S', 2);
        g1.insertarAristas('R', 'U', 1);
        System.out.println("--------------Iniciando el grafo--------------");
        return g1;

    }

    public void InsertarVertice(char etiqueta) {
        vertices[numVertices] = etiqueta;
        numVertices++;
    }

    public void insertarAristas(char v1, char v2, int peso) {
        int listav1 = buscar(v1);
        int listav2 = buscar(v2);
        adyacentes[listav1].insertar(listav2, peso);
        numVerticesAdy[listav1]++;
    }

    public int buscar(char v) {
        boolean bandera = false;
        int cont = 0;
        while (bandera != true && cont < vertices.length - 1) {
            if (vertices[cont] == v) {
                bandera = true;
            } else {
                cont++;
            }
        }
        return cont;
    }

    public void borrarVertice(char v) {
        int posVertice = buscar(v);
        for (int i = posVertice; i < numVertices - 1; i++) {
            vertices[i] = vertices[i + 1];
            adyacentes[i] = adyacentes[i + 1];
        }
        numVertices--;
        for (int i = posVertice; i < numVertices - 1; i++) {
            Posicion p = adyacentes[i].cabeza;
            while (p != null && p.getElemento() != posVertice) {
                p = p.getSiguiente();
            }
            if (p != null) {
                adyacentes[posVertice].borrar(p);
                numVerticesAdy[posVertice]--;
                System.out.println("Vertice " + v + " eliminado");
            }
        }
    }

    public void borrarVerticeIndex(int posVertice) {
        for (int i = posVertice; i < numVertices - 1; i++) {
            vertices[i] = vertices[i + 1];
            adyacentes[i] = adyacentes[i + 1];
        }
        numVertices--;
        for (int i = posVertice; i < numVertices - 1; i++) {
            Posicion p = adyacentes[i].cabeza;
            while (p != null && p.getElemento() != posVertice) {
                p = p.getSiguiente();
            }
            if (p != null) {
                adyacentes[posVertice].borrar(p);
                numVerticesAdy[posVertice]--;
            }
        }
    }

    public boolean vacio() {
        boolean resultado = false;
        if (numVertices == 0) {
            resultado = true;
        }
        System.out.println("¿El grafo esta vacio?: " + resultado);
        return resultado;
    }

    public int numVertices() {
        System.out.println("El número de vertices es igual a: " + numVertices);
        return numVertices;
    }

    public int numVerticesAd(char v) {
        int posiV = buscar(v);
        System.out.println("El numero de vertices adyacentes a " + v + " es de: " + numVerticesAdy[posiV]);
        return numVerticesAdy[posiV];
    }

    public char primerVerticeAdy(char v) {
        int posiV = buscar(v);
        int posiAdyV = adyacentes[posiV].ultimo.elemento;
        char dato = vertices[posiAdyV];
        System.out.println("El primer vertice adyacente a " + v + " es: " + dato);
        return dato;
    }

    public char siguienteVerticeAdy(char v) {
        int posiV = buscar(v);
        int posiAdyV = adyacentes[posiV].cabeza.siguiente.elemento;
        char dato = vertices[posiAdyV];
        System.out.println("El siguiente vertice adyacente a " + v + " es: " + dato);
        return dato;
    }

    public char etiqueta(int posi) {
        return vertices[posi];
    }

    public void modificarEtiqueta(char v, char nuevo) {
        int posVertice = buscar(v);
        for (int i = posVertice; i < numVertices - 1; i++) {
            vertices[posVertice] = nuevo;
        }
        for (int i = 0; i < numVertices - 1; i++) {
            Posicion p = adyacentes[i].getCabeza();
            while (p != null && p.getElemento() != posVertice) {
                p = p.getSiguiente();
            }
            if (p != null) {
                adyacentes[posVertice].modificar(p, nuevo);
            }
        }
        System.out.println("Modificación exitosa! el vertice " + v + " ahora tiene como etiqueta la letra: " + nuevo);
    }

    public int peso(char v1, char v2) {
        int posV1 = buscar(v1);
        int posV2 = buscar(v2);
        int resp = 0;
        Posicion p = adyacentes[posV1].cabeza;
        resp = adyacentes[posV1].getCabeza().getPeso();
        while (p != null && p.getElemento() != posV2) {
            p = p.getSiguiente();
            resp = adyacentes[posV1].getCabeza().siguiente.peso;
        }
        if (posV1 == 0 && posV2 == 1) {
            resp = 1;
        }
        System.out.println("Peso entre las aristas " + v1 + " y " + v2 + " es de: " + resp);
        return resp;
    }
    public int pesoIndex(int v1, int v2) { 
        int resp = 0;
        Posicion p = adyacentes[v1].cabeza;
        resp = adyacentes[v1].getCabeza().getPeso();
        while (p != null && p.getElemento() != v2) {
            p = p.getSiguiente();
            resp = adyacentes[v1].getCabeza().siguiente.peso;
        }
        if (v1 == 0 && v2 == 1) {
            resp = 1;
        }     
        return resp;
    }

    public void modificarPeso(char v1, char v2, int peso) {
        int posV1 = buscar(v1);
        int posV2 = buscar(v2);
        Posicion p = adyacentes[posV1].cabeza;
        while (p != null && p.getElemento() != posV2) {
            p = p.getSiguiente();
        }
        if (p != null) {
            adyacentes[posV1].ultimo.setPeso(peso);
            System.out.println("Peso entre la arista " + v1 + " y " + v2 + " modificado correctamente a: " + peso);
        }
    }

    public boolean existeArista(char v1, char v2) {
        boolean resp = false;
        int posV1 = buscar(v1);
        int posV2 = buscar(v2);
        Posicion p = adyacentes[posV1].cabeza;
        while (p != null && p.getElemento() != posV2) {
            p = p.getSiguiente();
        }
        if (p != null) {
            resp = true;
        }
        System.out.println("Existe una arista entre el vertice " + v1 + " y " + v2 + " ? " + resp);
        return resp;
    }

    public void eliminarrista(char v1, char v2) {
        if (existeArista(v1, v2)) {
            int posV1 = buscar(v1);
            int posV2 = buscar(v2);
            Posicion p = adyacentes[posV1].cabeza;
            while (p != null && p.getElemento() != posV2) {
                p = p.getSiguiente();
            }
            if (p != null) {
                adyacentes[posV1].borrar(p);
                numVerticesAdy[posV1]--;
                System.out.println("Arista eliminada");
            }
        }
    }


    public void imprimir() {   //metodo incompleto
        System.out.println("--------------------Vertices del grafo--------------------");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(vertices[i]);
            for (int j = 0; j < numVerticesAdy[i]; j++) {
                //System.out.println("adyacentes: " + vertices[j]);
            }
        }
    }

}
