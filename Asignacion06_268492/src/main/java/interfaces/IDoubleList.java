package interfaces;
/**
 *
 * @author Luis Carlos
 * @param <T>
 */
public interface IDoubleList<T> extends IList<T> {
    /**
    * Regresa el indice de la ultima ocurrencia del elemento del
    * parametro, en la lista o -1 si el elemento no existe.
    *
    * @param o Elemento a buscar en la lista
    * @return Regresa el indice de la ultima ocurrencia del elemento
    * del parámetro en la lista o -1 si el elemento no existe.
    */
    int lastIndexOf(T o);
    /**
    * Elimina la ultima ocurrencia del elemento del parametron, si
    * existe.
    *
    * @param o Elemento a eliminar
    * @return true si el elemento existe en la lista, false en caso
    * contrario.
    */
    boolean removeLast(T o);
}
