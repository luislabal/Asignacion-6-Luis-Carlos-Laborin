package interfaces;

import excepciones.ListException;
import java.util.Iterator;
/**
 * IList.java
 * Interfaz que tiene los metodos necesarios para la lista
 * @author Luis Carlos
 * @param <T> Tipo que sera la lista
 */
public interface IList<T>{

    /**
     * public void que agrega un valor al IList
     * @param o tipo generico valor definido al momento de
     * implementarse el IList
     * @throws ListException 
     */
    public void append(T o )throws ListException;
    
    /**
     * public void que inserta un valor en IList
     * @param o tipo generico valor definido al momento de
     * implementarse el IList 
     * @param i tipo entero que indica el indice 
     * donde se agrega el parametro o
     * @throws ListException 
     */    
    public void insert (T o, int i) throws ListException;
    
    /**
     * public generico que obtiene un valor del IList
     * @param i tipo entero que indica el indice del valor 
     * @return el valor en el indice indicado
     * @throws ListException 
     */
    public T get(int i) throws ListException;
    
    /**
     * public generico que remueve un valor del IList
     * @param i tipo entero que indica el indice a remover
     * @return el valor removido
     * @throws ListException 
     */
    public T remove(int i) throws ListException;
    
    /**
     * public boolean que verifica el estado del IList
     * @return valor bool dependiendo el estado del IList vacio o lleno
     */
    public boolean empty();
    
    /**
     * public int que indica la dimension del IList
     * @return valor int con el tamanio del IlIT
     */
    public int size();
    
    /**
     * public Iterator generico
     * @return generico iterado del IList
     */
    public Iterator<T> iterator();
    
    /**
     * 
     * @param o 
     * @param i 
     * @throws ListException 
     */
    void set(T o, int i)throws ListException;
    
    /**
     * 
     * @param o 
     * @return 
     * @throws ListException 
     */
    boolean remove(T o)throws ListException;
    
    /**
     * 
     * @param o
     * @return
     * @throws ListException 
     */
    int indexOf(T o)throws ListException;
    
    /**
     * 
     */
    void clear();
}
