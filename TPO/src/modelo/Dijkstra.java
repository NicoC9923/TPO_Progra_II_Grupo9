package modelo;

import java.util.*;
//se creó una clase extra para el algoritmo Dijkstra, así de esta forma se aplica la teoria de TDA
import interfaces.IDijkstra;
import interfaces.IGrafo;
import interfaces.INodo;
import interfaces.IArista;
public class Dijkstra implements IDijkstra {
//una de las principales diferencias con el algoritmo visto en clase
    public void mostrarRuta(IGrafo grafo, INodo origen, INodo destino) {
        Map<INodo, Integer> distancias = new HashMap<>();
        Map<INodo, INodo> anteriores = new HashMap<>();
        PriorityQueue<INodo> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (INodo nodo : grafo.getNodos()) {
            distancias.put(nodo, Integer.MAX_VALUE);
            anteriores.put(nodo, null);
        }

        distancias.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            INodo actual = cola.poll();

            for (IArista arista : grafo.getAdyacentes(actual)) {
                INodo vecino = arista.getDestino();
                int nuevaDistancia = distancias.get(actual) + arista.getPeso();

                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    anteriores.put(vecino, actual);
                    cola.remove(vecino);
                    cola.add(vecino);
                }
            }
        }

        List<INodo> camino = new ArrayList<>();
        for (INodo at = destino; at != null; at = anteriores.get(at)) {
            camino.add(at);
        }
        Collections.reverse(camino);

        System.out.println("Ruta más corta de " + origen + " a " + destino + ":");
        for (INodo nodo : camino) {
            System.out.print(nodo + " ");
        }
        System.out.println("\nDificultad total: " + distancias.get(destino));
    }
}
