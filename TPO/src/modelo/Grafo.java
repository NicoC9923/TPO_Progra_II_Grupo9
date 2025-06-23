package modelo;

import java.util.*;

import interfaces.IArista;
import interfaces.IGrafo;
import interfaces.INodo;

public class Grafo implements IGrafo {
    private Map<INodo, List<IArista>> adyacencias = new HashMap<>();

    public void agregarNodo(INodo nodo) {
        adyacencias.putIfAbsent(nodo, new ArrayList<>());
    }

    public void agregarArista(INodo origen, INodo destino, int peso) {
        adyacencias.get(origen).add(new Arista(origen, destino, peso));
        adyacencias.get(destino).add(new Arista(destino, origen, peso)); // no dirigido
    }

    public List<IArista> getAdyacentes(INodo nodo) {
        return adyacencias.get(nodo);
    }

    public Set<INodo> getNodos() {
        return adyacencias.keySet();
    }
}
