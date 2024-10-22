package aed;
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int cardinal;
    private int altura;
    private T minimo;
    private T maximo;

    private class Nodo {
        private T valor;
        private Nodo izq;
        private Nodo der;
        private Nodo padre;

        // Crear Constructor del nodo
        public Nodo(T val) {
            this.valor = val;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }

    public ABB() {
        this.cardinal = 0;
        this.altura = 0;
        this.raiz = null;
    }

    public int cardinal() {
        return this.cardinal;
    }

    public T minimo(){
        return this.minimo;
    }

    public T maximo(){
        return this.maximo;
    }

    public void insertar(T elem){
        if (this.raiz == null) {
            this.cardinal++;
            this.minimo = elem;
            this.maximo = elem;
            this.raiz = new Nodo(elem);
            return;
        }
        if (elem.compareTo(this.maximo) > 0) {
            this.maximo = elem;
        }
        if (elem.compareTo(this.minimo) < 0) {
            this.minimo = elem;
        }
        Nodo nodoActual = this.raiz;
        Nodo nodoPadre = null;
        if (pertenece(elem)) {
            return;
        }
        while (nodoActual != null) {
            nodoPadre = nodoActual;
            if (elem.compareTo(nodoActual.valor) < 0) {
                nodoActual = nodoPadre.izq;
            } else if (elem.compareTo(nodoActual.valor) > 0) {
                nodoActual = nodoPadre.der;
            }
        }
        Nodo nuevoNodo = new Nodo(elem);
        nuevoNodo.padre = nodoPadre;
        if (elem.compareTo(nodoPadre.valor) < 0) {
            nodoPadre.izq = nuevoNodo;
        } else {
            nodoPadre.der = nuevoNodo;
        }
        this.cardinal++;
    }

    public boolean pertenece(T elem){
        Nodo nodoActual = this.raiz;
        while (nodoActual != null) {
            if (elem.compareTo(nodoActual.valor) == 0) {
                return true;
            } else if (elem.compareTo(nodoActual.valor) < 0) {
                nodoActual = nodoActual.izq;
            } else {
                nodoActual = nodoActual.der;
            }
        }
        return false;
    }

    public void eliminar(T elem){
        this.raiz = eliminarRecursivo(this.raiz, elem);
        this.cardinal--;

        if (this.raiz != null) {
            this.minimo = encontrarMin(this.raiz).valor;
            this.maximo = encontrarMax(this.raiz).valor;
        } else {
            this.minimo = null;
            this.maximo = null;
        }
    }

    private Nodo eliminarRecursivo(Nodo nodoActual, T elem) {
        if (nodoActual == null) {
            return null;
        }
        if (elem.compareTo(nodoActual.valor) < 0) {
            nodoActual.izq = eliminarRecursivo(nodoActual.izq, elem);
            if (nodoActual.izq != null) {
                nodoActual.izq.padre = nodoActual;
            }
        } else if (elem.compareTo(nodoActual.valor) > 0) {
            nodoActual.der = eliminarRecursivo(nodoActual.der, elem);
            if (nodoActual.der != null) {
                nodoActual.der.padre = nodoActual;
            }
        } else {
            // No tiene hijos
            if (nodoActual.izq == null && nodoActual.der == null) {
                return null;
            }

            // Tiene un solo hijo
            if (nodoActual.izq == null) {
                return nodoActual.der;
            }
            if (nodoActual.der == null) {
                return nodoActual.izq;
            }

            // Tiene dos hijos
            Nodo sucesor = encontrarMin(nodoActual.der);
            nodoActual.valor = sucesor.valor;
            nodoActual.der = eliminarRecursivo(nodoActual.der, sucesor.valor);
            if (nodoActual.der != null) {
                nodoActual.der.padre = nodoActual;
            }
        }
        return nodoActual;
    }

    private Nodo encontrarMin(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    private Nodo encontrarMax(Nodo nodo) {
        while (nodo.der != null) {
            nodo = nodo.der;
        }
        return nodo;
    }

    private Nodo sucesor(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        Nodo res;

        if (nodo.der != null) {
            res = encontrarMin(nodo.der);
            return res;
        }

        res = nodo.padre;
        Nodo hijo = nodo;

        while (res != null && res.der.valor.compareTo(hijo.valor) == 0) {
            hijo = res;
            res = res.padre;
        }
        return res;
    }

    public String toString(){
        if (cardinal == 0)
        {
            return "{}";
        }
        String conjunto = "{";
        ABB_Iterador iterador = new ABB_Iterador();
        while (iterador.haySiguiente()) {
            conjunto += iterador.siguiente().toString();
            if (iterador.haySiguiente()) {
                conjunto += ",";
            }
        }
        conjunto += "}";
        return conjunto;

    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador() {
            this._actual = encontrarMin(raiz);
        }

        public boolean haySiguiente() {
            return _actual != null;
        }
    
        public T siguiente() {
            T valorActual = _actual.valor;
            _actual = sucesor(_actual);
            return valorActual;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
