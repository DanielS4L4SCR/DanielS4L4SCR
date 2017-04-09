/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lccypa;

/**
 *
 * @author Luis Mauricio Salas
 */
public class Floyd {
    public String algoritmoFloyd(long[][] Ady) {  
        int vertices = Ady.length;
        long matrizAdyacencia[][] = Ady;
        String caminos[][] = new String[vertices][vertices];
        String caminosAuxiliares[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1;
        float temporal2;
        float temporal3;
        float temporal4;
        float minimo;
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAuxiliares[i][j] = "";
            }
        }
        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //encontrando el minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAuxiliares, caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }

        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 1000000000) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por...(" + (i + 1) + "," + (j + 1) + ")\n";
                        } else {
                            caminitos += "De (" + (i + 1) + "--->" + (j + 1) + ") Irse por...(" + (i + 1) + "," + caminos[i][j] + ", " + (j + 1) + ")\n";

                        }
                    }
                }
            }
        }
        System.out.println("----------los vertices están expresados en posiciones----------");
        return "La Matriz de caminos Mas cortos entre los diferentes vertices es: \n" + cadena
                + "\nLos Diferentes Caminos Mas cortos Entre Vertices son:\n" + caminitos;
    }
    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorridos) {
        if (caminosAuxiliares[i][k].equals("")) {
            return "";
        } else {
            caminoRecorridos += caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorridos) + (Integer.parseInt(caminosAuxiliares[i][k].toString()) + 1) + ", ";
        }
        return caminoRecorridos;
    }
   
}
