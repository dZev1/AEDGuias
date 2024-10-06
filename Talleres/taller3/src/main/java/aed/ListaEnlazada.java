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

        if (nodoAux != null) {
            nodoAux.anterior = this.primero;
        }

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
        this.longitud = lista.longitud;

        if (this.longitud == 0) {
            this.primero = new Nodo(null);
        }

        else {
            this.primero = new Nodo(lista.primero.valor);
            Nodo nodoActualNuevo = this.primero;
            Nodo nodoActualOriginal = lista.primero.siguiente;

            while (nodoActualOriginal != null) {
                Nodo nuevoNodo = new Nodo(nodoActualOriginal.valor);
                nodoActualNuevo.siguiente = nuevoNodo;
                nuevoNodo.anterior = nodoActualNuevo;

                nodoActualNuevo = nuevoNodo;
                nodoActualOriginal = nodoActualOriginal.siguiente;
            }
        }
    }
    
    @Override
    public String toString() {
        Nodo nodoActual = this.primero;
        String str = "[";
        while (nodoActual != null) {
            str += nodoActual.valor;
            nodoActual = nodoActual.siguiente;
            if (nodoActual != null) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    private class ListaIterador implements Iterador<T> {
        int indice;

        void ListaIterador() {
            this.indice = 0;
        }

        public boolean haySiguiente() {
            return this.indice < longitud();
        }
        
        public boolean hayAnterior() {
            return this.indice > 0;
        }

        public T siguiente() {
	        T elem = getNodo(this.indice).valor;
            this.indice++;
            return elem;
        }
        

        public T anterior() {
            this.indice--;
            return getNodo(this.indice).valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
