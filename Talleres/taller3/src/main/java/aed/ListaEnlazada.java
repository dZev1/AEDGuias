package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    private int longitud;
    private Nodo primero;

    private class Nodo {
        private T valor;
        private Nodo siguiente;
        private Nodo anterior;
        public Nodo(T val) {
            this.valor = val;
        }
    }

    public ListaEnlazada() {
        this.longitud = 0;
        this.primero = new Nodo(null);
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nodo = new Nodo(elem);
        Nodo nodoAux = this.primero;
        this.primero = nodo;
        this.primero.siguiente = nodoAux;
        this.longitud++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo =  new Nodo(elem);
        if (this.primero.valor == null) {
            this.primero = nuevoNodo;
        }
        else {
            Nodo ultimo = getNodo(this.longitud - 1);
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;
        }
        this.longitud++;
    }

    public T obtener(int i) {
        Nodo nodo = getNodo(i);
        return nodo.valor;
    }

    private Nodo getNodo(int i) {
        Nodo nodo = primero;
        int j = 0;
        while (j != i) {
            nodo = nodo.siguiente;
            j++;
        }
        return nodo;
    }

    public void eliminar(int i) {
        Nodo nodoAEliminar = getNodo(i);

        if (nodoAEliminar == primero) {
            primero = nodoAEliminar.siguiente;
            if (primero != null) {
                primero.anterior = null;
            }
        }
        else {
            nodoAEliminar.anterior.siguiente = nodoAEliminar.siguiente;
        }
        if (nodoAEliminar.siguiente != null) {
            nodoAEliminar.siguiente.anterior = nodoAEliminar.anterior;
        }
        this.longitud--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nodoAModificar = getNodo(indice);
        nodoAModificar.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
