package interfaces;

import java.util.List;
import java.util.Set;

public interface IGrafo {
    void agregarNodo(INodo nodo);
    void agregarArista(INodo origen, INodo destino, int peso);
    List<IArista> getAdyacentes(INodo nodo);
    Set<INodo> getNodos();
}