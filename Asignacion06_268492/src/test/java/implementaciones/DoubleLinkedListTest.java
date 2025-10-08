package implementaciones;

import excepciones.ListException;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
* DoubleLinkedListTest.java
*
* Clase de prueba de la clase DoubleLinkedListTest
*
* @author Luis Carlos 
*/

public class DoubleLinkedListTest {
    
    public DoubleLinkedListTest() {
    }
    /**
    * Prueba del metodo append(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testAppend_Integer() {
        System.out.println("Prueba del metodo append(), de la clase DoubleLinkedList<Integer>");
        Integer expResult;
        Integer result;
        int expNElementos;
        int nElementos;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba que se agrega al final de la lista
        intList.append(0);
        expResult = 0;
        result = intList.get(0);
        assertEquals(expResult, result);
        expNElementos = 1;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        intList.append(1);
        expResult = 1;
        result = intList.get(1);
        assertEquals(expResult, result);
        expNElementos = 2;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Llena la lista
        intList.append(2);
        intList.append(3);
        intList.append(4);
        expNElementos = 5;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
    }   

    /**
    * Prueba del metodo insert(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testInsert_Integer() {
        System.out.println("Prueba del metodo insert(), de la clase DoubleLinkedList, de la clase DoubleLinkedList<Integer>");
        Integer expResult;
        Integer result;
        int expNElementos;
        int nElementos;
        Exception e;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba que se inserta en la lista vacia
        intList.insert(0, 0);
        expResult = 0;
        result = intList.get(0);
        assertEquals(expResult, result);
        expNElementos = 1;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que se inserta al inicio de la lista
        intList.insert(1, 0);
        expResult = 1;
        result = intList.get(0);
        assertEquals(expResult, result);
        expNElementos = 2;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que se inserta dentro de la lista
        intList.insert(2, 1);
        expResult = 2;
        result = intList.get(1);
        assertEquals(expResult, result);
        expNElementos = 3;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que se inserta al final de la lista
        intList.insert(3, 3);
        expResult = 3;
        result = intList.get(3);
        assertEquals(expResult, result);
        expNElementos = 4;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que lanza una excepción si se intenta insertar el
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> intList.insert(4, -1));
        // Prueba que lanza una excepción si se intenta insertar el
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> intList.insert(5, 5));
    }
    
    /**
    * Prueba del metodo get(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testGet_Integer() {
        System.out.println("Prueba del metodo get(), de la clase DoubleLinkedList<Integer>");
        Integer expResult;
        Integer result;
        Exception e;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba que lanza una excepción si se intenta obtener un
        // elemento de la lista vacia
        e = assertThrows(ListException.class,
        () -> intList.get(0));
        intList.append(0);
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);
        // Prueba obtener un elemento al inicio de la lista
        expResult = 0;
        result = intList.get(0);
        assertEquals(expResult, result);
        // Prueba obtener un elemento en medio de la lista
        expResult = 2;
        result = intList.get(2);
        assertEquals(expResult, result);
        // Prueba obtener un elemento al final de la lista
        expResult = 4;
        result = intList.get(4);
        assertEquals(expResult, result);
        // Prueba que lanza una excepción si se intenta obtener un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> intList.get(-1));
        // Prueba que lanza una excepción si se intenta obtener un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,   
        () -> intList.get(5));
    }    
    
    /**
    * Prueba del metodo remove(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testRemove_int_Integer() {
        System.out.println("Prueba del metodo remove(), de la clase DoubleLinkedList<Integer>");
        Integer expResult;
        Integer result;
        int expNElementos;
        int nElementos;
        Exception e;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba que lanza una excepción si se intenta eliminar un
        // elemento de una lista vacia
        e = assertThrows(ListException.class,
        () -> intList.remove(0));
        intList.append(0);
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);
        // Prueba eliminar un elemento al inicio de la lista
        expResult = 0;
        result = intList.remove(0);
        assertEquals(expResult, result);
        expNElementos = 4;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba eliminar un elemento en medio de la lista
        expResult = 3;
        result = intList.remove(2);
        assertEquals(expResult, result);
        expNElementos = 3;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba eliminar un elemento al inicio de la lista
        expResult = 4;
        result = intList.remove(2);
        assertEquals(expResult, result);
        expNElementos = 2;
        nElementos = intList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que lanza una excepción si se intenta eliminar un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> intList.remove(-1));
        // Prueba que lanza una excepción si se intenta eliminar un
        // elemento fuera de los limites de la lista    
        e = assertThrows(ListException.class,
        () -> intList.remove(3));
    }

    /**
    * Prueba del metodo empty(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testEmpty_Integer() {
        System.out.println("Prueba del metodo empty(), de la clase DoubleLinkedList<Integer>");
        boolean result;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba con una lista vacia
        result = intList.empty();
        assertTrue(result);
        // Prueba con una lista no vacia
        intList.append(0);
        result = intList.empty();
        assertFalse(result);
    }    
    
    /**
    * Prueba del metodo size(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testSize_Integer() {
        System.out.println("Prueba del metodo size(), de la clase DoubleLinkedList<Integer>");
        int result;
        int expResult;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba con una lista vacia
        result = intList.size();
        expResult = 0;
        assertEquals(expResult, result);
        // Prueba con una lista no vacia
        intList.append(0);
        result = intList.size();
        expResult = 1;
        assertEquals(expResult, result);
    }    

    /**
    * Prueba del metodo iterator(), de la clase
    * DoubleLinkedList< Intege r>.
    */
    @Test
    public void testIterator_Integer() {
        System.out.println("Prueba del metodo iterator(), de la clase DoubleLinkedList<Integer>");
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        Iterator result = intList.iterator();
        assertNotNull(result);
    }
    
    /**
    * Prueba del metodo toString(), de la clase
    * DoubleLinkedList< Integer >.
    */
    @Test
    public void testToString_Integer() {
        System.out.println("Prueba del metodo toString(), de la clase DoubleLinkedList<Integer>");
        String expResult;
        String result;
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        // Prueba con una lista vacia
        expResult = "[]";
        result = intList.toString();
        assertEquals(expResult, result);
        intList.append(0);
        intList.append(1);
        intList.append(2);
        intList.append(3);
        intList.append(4);
        // Prueba con una lista vacia
        expResult = "[0, 1, 2, 3, 4]";
        result = intList.toString();
        assertEquals(expResult, result);
    }   
    
    /**
    * Prueba del metodo append(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testAppend_String() {
        System.out.println("Prueba del metodo append(), de la clase DoubleLinkedList<String>");
        String expResult;
        String result;
        int expNElementos;
        int nElementos;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba que se agrega al final de la lista
        strList.append("Alma");
        expResult = "Alma";
        result = strList.get(0);
        assertEquals(expResult, result);
        expNElementos = 1;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        strList.append("Bernardo");    
        expResult = "Bernardo";
        result = strList.get(1);
        assertEquals(expResult, result);
        expNElementos = 2;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Llena la lista
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");
        expNElementos = 5;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
    }

    /**
    * Prueba del metodo insert(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testInsert_String() {
        System.out.println("Prueba del metodo insert(), de la clase DoubleLinkedList, de la clase DoubleLinkedList<String>");
        String expResult;
        String result;
        int expNElementos;
        int nElementos;
        Exception e;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba que se inserta en la lista vacia
        strList.insert("Alma", 0);
        expResult = "Alma";
        result = strList.get(0);
        assertEquals(expResult, result);
        expNElementos = 1;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que se inserta al inicio de la lista
        strList.insert("Bernardo", 0);
        expResult = "Bernardo";
        result = strList.get(0);
        assertEquals(expResult, result);
        expNElementos = 2;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que se inserta dentro de la lista
        strList.insert("Clara", 1);
        expResult = "Clara";
        result = strList.get(1);
        assertEquals(expResult, result);
        expNElementos = 3;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que se inserta al final de la lista
        strList.insert("David", 3);    
        expResult = "David";
        result = strList.get(3);
        assertEquals(expResult, result);
        expNElementos = 4;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que lanza una excepción si se intenta insertar el
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> strList.insert("Eva", -1));
        // Prueba que lanza una excepción si se intenta insertar el
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> strList.insert("Felipe", 5));
    }

    /**
    * Prueba del metodo get(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testGet_String() {
        System.out.println("Prueba del metodo get(), de la clase DoubleLinkedList<String>");
        String expResult;
        String result;
        Exception e;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba que lanza una excepción si se intenta obtener un
        // elemento de la lista vacia
        e = assertThrows(ListException.class,
        () -> strList.get(0));
        strList.append("Alma");
        strList.append("Bernardo");
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");
        // Prueba obtener un elemento al inicio de la lista
        expResult = "Alma";
        result = strList.get(0);
        assertEquals(expResult, result);
        // Prueba obtener un elemento enmedio de la lista
        expResult = "Clara";
        result = strList.get(2);
        assertEquals(expResult, result);
        // Prueba obtener un elemento al final de la lista
        expResult = "Eva";
        result = strList.get(4);
        assertEquals(expResult, result);
        // Prueba que lanza una excepción si se intenta obtener un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class, () -> strList.get(-1));   
        // Prueba que lanza una excepción si se intenta obtener un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class, () -> strList.get(5));
    }
    
    /**
    * Prueba del metodo remove(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testRemove_int_String() {
        System.out.println("Prueba del metodo remove(), de la clase DoubleLinkedList<String>");
        String expResult;
        String result;
        int expNElementos;
        int nElementos;
        Exception e;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba que lanza una excepción si se intenta eliminar un
        // elemento de una lista vacia
        e = assertThrows(ListException.class,
        () -> strList.remove(0));
        strList.append("Alma");
        strList.append("Bernardo");
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");
        // Prueba eliminar un elemento al inicio de la lista
        expResult = "Alma";
        result = strList.remove(0);
        assertEquals(expResult, result);
        expNElementos = 4;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba eliminar un elemento en medio de la lista
        expResult = "David";
        result = strList.remove(2);
        assertEquals(expResult, result);
        expNElementos = 3;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba eliminar un elemento al inicio de la lista
        expResult = "Eva";
        result = strList.remove(2);
        assertEquals(expResult, result);
        expNElementos = 2;
        nElementos = strList.size();
        assertEquals(expNElementos, nElementos);
        // Prueba que lanza una excepción si se intenta eliminar un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> strList.remove(-1));    
        // Prueba que lanza una excepción si se intenta eliminar un
        // elemento fuera de los limites de la lista
        e = assertThrows(ListException.class,
        () -> strList.remove(3));
    }    

    /**
    * Prueba del metodo empty(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testEmpty_String() {
        System.out.println("Prueba del metodo empty(), de la clase DoubleLinkedList<String>");
        boolean result;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba con una lista vacia
        result = strList.empty();
        assertTrue(result);
        // Prueba con una lista no vacia
        strList.append("Alma");
        result = strList.empty();
        assertFalse(result);
    }    
    
    /**
    * Prueba del metodo size(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testSize_String() {
        System.out.println("Prueba del metodo size(), de la clase DoubleLinkedList<String>");
        int result;
        int expResult;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba con una lista vacia
        result = strList.size();
        expResult = 0;
        assertEquals(expResult, result);
        // Prueba con una lista no vacia
        strList.append("Alma");
        result = strList.size();
        expResult = 1;
        assertEquals(expResult, result);
    }    
    
    /**
    * Prueba del metodo iterator(), de la clase
    * DoubleLinkedList< Intege r>.
    */
    @Test
    public void testIterator_String() {    
        System.out.println("Prueba del metodo iterator(), de la clase DoubleLinkedList<String>");
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        Iterator result = strList.iterator();
        assertNotNull(result);
    }

    /**
    * Prueba del metodo toString(), de la clase
    * DoubleLinkedList< String >.
    */
    @Test
    public void testToString_String() {
        System.out.println("Prueba del metodo toString(), de la clase DoubleLinkedList<String>");
        String expResult;
        String result;
        DoubleLinkedList<String> strList = new DoubleLinkedList<>();
        // Prueba con una lista vacia
        expResult = "[]";
        result = strList.toString();
        assertEquals(expResult, result);
        strList.append("Alma");
        strList.append("Bernardo");
        strList.append("Clara");
        strList.append("David");
        strList.append("Eva");
        // Prueba con una lista no vacia
        expResult = "[Alma, Bernardo, Clara, David, Eva]";
        result = strList.toString();
        assertEquals(expResult, result);
    }
 
}
