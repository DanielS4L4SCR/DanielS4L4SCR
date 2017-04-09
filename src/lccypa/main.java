/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lccypa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Luis Mauricio Salas
 */
public class main {

    public static void main(String[] args) {
       Grafo g1 = new Grafo(6);
       g1.iniciar(g1);
       g1.numVertices();
       g1.vacio();
       g1.numVerticesAd('P');
       g1.primerVerticeAdy('P');
       g1.siguienteVerticeAdy('P');
       g1.peso('P', 'Q');
       g1.peso('P', 'S');
       g1.peso('P', 'T');
       g1.peso('Q', 'S');
       g1.peso('Q', 'R');
       g1.peso('S', 'T');
       g1.peso('S', 'U');
       g1.peso('T', 'U');
       g1.peso('R', 'S');
       g1.peso('R', 'U');
       //g1.modificarPeso('S', 'T', 2);
       g1.peso('S', 'T');
       g1.existeArista('P', 'R');
       g1.eliminarrista('P', 'Q');
       g1.existeArista('P', 'Q');
       //g1.modificarEtiqueta('P', 'V');
       g1.imprimir();
       long matrizA[][] = {{0, 1, 6, 7, 999999999, 999999999}, {999999999, 0, 4, 999999999, 1, 999999999}, {999999999, 999999999, 0, 3, 999999999, 2}, {999999999, 999999999, 999999999, 0, 999999999, 2}, {999999999, 999999999, 2, 999999999, 0, 1}, {999999999, 999999999, 999999999, 999999999, 999999999, 0}};
       Floyd rutaFloyd = new Floyd();
       System.out.println(rutaFloyd.algoritmoFloyd(matrizA));
     
       //implementacion de Dikstra
       int num=0;
        System.out.println("---------Implementación del Algoritmo de Dijkstra--------");
        System.out.println("Numero de nodos que tiene el grafo a resolver? ");
        do { 
            try {
                InputStreamReader l1 = new InputStreamReader(System.in);
                BufferedReader l2 = new BufferedReader(l1);
                num=Integer.valueOf(l2.readLine()).intValue();
            } catch (IOException e) {
                System.out.println("Error: " +e);
                System.out.println("Ingresa el numero de nodos que tiene el grafo a resolver: ");
            }
            catch(NumberFormatException e2){
                System.out.println("Error: " +e2);
                System.out.println("ingresa el numero de nodos que tiene el grafo a resolver: ");
            }
            if (num<3|| num>26) 
                System.out.println(" El numero de nodos debe estar entre 3 y 26 ");
       }while (num<3|| num>26);            
            Dijkstra obj = new Dijkstra(6);
        }
    
    
  
}
