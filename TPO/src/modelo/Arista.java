package modelo;

import interfaces.IArista;
import interfaces.INodo;

public class Arista implements IArista {
    private INodo origen;
    private INodo destino;
    private int peso;

    public Arista(INodo origen, INodo destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public INodo getOrigen() {
        return origen;
    }

    public INodo getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}