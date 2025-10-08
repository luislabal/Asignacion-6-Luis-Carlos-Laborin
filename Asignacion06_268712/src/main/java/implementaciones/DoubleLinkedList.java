package implementaciones;

import excepciones.ListException;
import interfaces.IDoubleList;
import java.util.Iterator;

/**
 *
 * @author Luis Carlos  
 * @param <T>
 */
public class DoubleLinkedList<T> implements IDoubleList<T>,
    Iterable<T> {
    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;
    private int nElementos;
    
    /**
     * metodo para agregar un nodo generico
     * @param o es de tipo generico
     * @throws ListException 
     */
    @Override
    public void append(T o) throws ListException {
        NodoDoble<T> nodoNuevo = new NodoDoble<>(o);
        if (inicio == null) {
        // Si la lista está vacía
        inicio = nodoNuevo;
        } else {
        // Si no, agrega el nuevo nodo al final de la lista
        fin.sig = nodoNuevo;
        nodoNuevo.ant = fin;
        }
        fin = nodoNuevo;
        nElementos++;
    }
    
    /**
     * metodo que inserta un nodo generico en el indice indicado
     * @param o es de tipo generico
     * @param i de tipo entero que recibe el indice
     * @throws ListException 
     */
    @Override
    public void insert(T o, int i) throws ListException {
        NodoDoble<T> nodoNuevo = new NodoDoble<>(o);
        if (i < 0 || i > nElementos) {
        throw new ListException("Indice fuera de limites");
        }
        if (i == 0) {
        // Si se va a insertar el elemento al inicio de la lista
        if (inicio == null) {
        // Si la lista esta vacia
        fin = nodoNuevo;
        } else {
        // Si no, conecta la lista al nodo nuevo
        nodoNuevo.sig = inicio;
        inicio.ant = nodoNuevo;
        }
        // Haz el nodo nuevo el primero de la lista
        inicio = nodoNuevo;
        } else {
        // Si se va a insertar el elemento en la posición i de
        // la lista
        NodoDoble<T> nodo = inicio;
        // Haz que nodo apunte al nodo anterior al punto de
        // insercion
        for (int j = 0; j < i - 1; j++) {
        nodo = nodo.sig;
        }
        // Agrega la lista a la derecha del punto de inserción
        // al nodo nuevo
        nodoNuevo.sig = nodo.sig;
        if (nodoNuevo.sig != null) {
        // Si el nodo insertado no es el ultimo
        nodoNuevo.sig.ant = nodoNuevo;
        } else {
        // Si el nodo insertado es el ultimo
        fin = nodoNuevo;
        }
        // Agrega el nodo nuevo a la lista a la izquierda del
        // punto de inserción
        nodoNuevo.ant = nodo;
        nodo.sig = nodoNuevo;
        }
        nElementos++;
    }
    
    /**
     * metodo que obtiene un nodo
     * @param i tipo entero que recibe el indice a obtener
     * @return retorna el nodo de tipo generico en el indice indicado
     * @throws ListException 
     */
    @Override
    public T get(int i) throws ListException {
    if (empty()) {
    throw new ListException("Lista vacia");
    }
            if (i < 0 || i >= nElementos) {
    throw new ListException("Indice fuera de limites");
    }
    NodoDoble<T> nodo = inicio;
    // Haz que nodo apunte al nodo a modificar
    for (int j = 0; j < i; j++) {
    nodo = nodo.sig;
    }
    // Regresa el dato en la posición i de la lista
    return nodo.dato;
    }
    
    /**
     * metodo remueve un nodo de tipo generico
     * @param i tipo entero que indica el indice
     * @return el nodo removido
     * @throws ListException 
     */
    @Override
    public T remove(int i) throws ListException {
        T o;
        if (empty()) {
        throw new ListException("Lista vacia");
        }
        if (i < 0 || i >= nElementos) {
        throw new ListException("Indice fuera de limites");
        }
        if (i == 0) {
        // Si el nodo a eliminar es el primero, obten el dato
        // a eliminar
        o = inicio.dato;
        // Quita el elemento al inicio de la lista
        inicio = inicio.sig;
        if (inicio != null) {
        // Si la lista no esta vacia
        inicio.ant = null;
        } else {
        // Si la lista esta vacia
        fin = null;
        }
        } else {
        // Si el nodo a eliminar esta en la posición i de la
        // lista
        NodoDoble<T> nodo = inicio;
        // Haz que nodo apunte al nodo anterior al nodo a
        // eliminar
        for (int j = 0; j < i - 1; j++) {
        nodo = nodo.sig;
        }
        // Obten el dato a eliminar
        o = nodo.sig.dato;
        // Quita el elemento a eliminar de la lista
        nodo.sig = nodo.sig.sig;
        if (nodo.sig != null) {
        // Si no es el ultimo nodo de la lista
        nodo.sig.ant = nodo;
        } else {
        // Si es el ultimo nodo de la lista
        fin = nodo;
        }
        }
        nElementos--;
        // Regresa el dato
        return o;
    }
    /**
     * metodo que valida el estado de la lista
     * @return el estado de la lista
     */
    @Override
    public boolean empty() {
        return inicio == null;
    }
    
    /**
     * metodo que indica el rango de la lista
     * @return la cantidad de elemntos
     */
    @Override
    public int size() {
        return nElementos;
    }
    
    /**
     * metodo iterador
     * @return la lista iterado
     */
    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedList.ListIterator(inicio);
    }
    
    /**
     * metodo que devuelve el valor en la ultima posicion
     * @param o tipo generico
     * @return el ultimo nodo generico
     * @throws ListException 
     */
    @Override
    public int lastIndexOf(T o) throws ListException {
        if (empty()) {
        return -1;
        }
        NodoDoble<T> nodo = fin;
        int index = nElementos - 1;
        while (nodo != null) {
            if (nodo.dato.equals(o)) {
                return index;
            }
            nodo = nodo.ant;
            index--;
        }
        return -1;
    }
    
    /**
     * metodo que remueve el nodo en el ultimo indice
     * @param o nodo generico a remover
     * @return false
     */
    @Override
    public boolean removeLast(T o) {
        if (empty()) {
        return false;
        }

        NodoDoble<T> nodo = fin;
        int index = nElementos - 1;
        while (nodo != null) {
            if (nodo.dato.equals(o)) {
                try {
                    remove(index); // usa remove(int i)
                } catch (ListException e) {
                    return false;
                }
                return true;
            }
            nodo = nodo.ant;
            index--;
        }
        return false;
    }
    
    /**
     * metodo que agrega un nodo en el indice indicado
     * @param o recine dato tipo generico
     * @param i indice donde se agrega el nodo
     * @throws ListException 
     */
    @Override
    public void set(T o, int i) throws ListException {
        if (empty()) {
        throw new ListException("Lista vacía");
        }
        if (i < 0 || i >= nElementos) {
            throw new ListException("Índice fuera de límites");
        }
        NodoDoble<T> nodo = inicio;
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig;
        }
        nodo.dato = o;
        }

    /**
     * metodo que remueve un nodo
     * @param o nodo a remover
     * @return false o true si se realizo la operacion con exito
     * @throws ListException 
     */
    @Override
    public boolean remove(T o) throws ListException {
        if (empty()) {
        throw new ListException("Lista vacía");
        }

        NodoDoble<T> nodo = inicio;
        int index = 0;
        while (nodo != null) {
            if (nodo.dato.equals(o)) {
                remove(index);
                return true;
            }
            nodo = nodo.sig;
            index++;
        }
        return false;
    }
    
    /**
     * metodo que retorna el indice de un nodo
     * @param o nodo generico a buscar
     * @return el indice del nodo generico
     * @throws ListException 
     */
    @Override
    public int indexOf(T o) throws ListException {
        if (empty()) {
        throw new ListException("Lista vacía");
        }
        NodoDoble<T> nodo = inicio;
        int index = 0;
        while (nodo != null) {
            if (nodo.dato.equals(o)) {
                return index;
            }
            nodo = nodo.sig;
            index++;
        }
        return -1;
    }

    /**
     * metodo que limpia la lista
     */
    @Override
    public void clear() {
        inicio = null;
        fin = null;
        nElementos = 0;
    }

    
    
    /**
    * Esta clase miembro representa un nodo de una lista
    * doblemente enlazada
    */
    private class NodoDoble<T> {
        private T dato;
        private NodoDoble<T> ant;
        private NodoDoble<T> sig;
        /**
        * Inicializa el atributo dato al valor de su parametro
        *
        * @param dato Dato a almacenar en el nodo
        */
        private NodoDoble(T dato) {
            this.dato = dato;
            this.sig = null;
            this.ant = null;
        }
    }
    
    /**
    * Esta clase miembro representa un iterador para esta lista
    */
    private class ListIterator<T> implements Iterator<T> {
        private NodoDoble<T> nodoActual;
        public ListIterator(NodoDoble<T> inicio) {
        nodoActual = inicio;
        }
        
        /**
         * metodo que indica si el nodo actual tiene un valor asignado
         * @return el estado del nodo true vacio false lleno
         */
        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }
        
        /**
         * metodo que pasa al siguiente nodo
         * @return el nodo actual
         */
        @Override
        public T next() {
            T dato = nodoActual.dato;
            nodoActual = nodoActual.sig;
            return dato;
        }
    }
    
    /**
     * metodo que establece los valores iniciales
     */
    public DoubleLinkedList() {
        inicio = null;
        fin = null;
        nElementos = 0;
    }
    
    /**
     * metodo que muestra los nodos genricos
     * @return lista con los nodos de tipo generico
     */
    @Override
    public String toString() {
        String s = "[";
        NodoDoble<T> nodo = inicio;
        while (nodo != null) {
        s += nodo.dato;
        if (nodo.sig != null) {
        s += ", ";
        }
        nodo = nodo.sig;
        }
        s += "]";
        return s;
    }
    
    
}
