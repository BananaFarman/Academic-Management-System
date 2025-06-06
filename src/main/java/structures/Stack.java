/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import structures.exceptions.StackException;
import structures.nodes.SingleNode;

/**
 * Implementacion de una pila utilizando una lista enlazada simple. Esta clase
 * implementa las operaciones básicas de una pila: apilar, desapilar, obtener el
 * ultimo elemento, verificar si esta vacia y obtener el tamaño de la pila.
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 * @param <T> Tipo de datos de los elementos almacenados en la pila.
 */
public class Stack<T> {

    private SingleNode<T> P;

    /**
     * Constructor de la clase LinkedListStack. Inicializa la pila vacia.
     */
    public Stack() {
        this.P = null;
    }

    /**
     * Añade un elemento al tope de la pila.
     *
     * @param value El dato a agregar a la pila.
     */
    public void push(T value) {
        SingleNode<T> newNode = new SingleNode<>(value);
        if (P == null) {
            P = newNode;
            return;
        }
        SingleNode<T> aux = P;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        aux.setNext(newNode);
    }

    /**
     * Elimina y devuelve el ultimo elemento de la pila.
     *
     * @return El último elemento de la pila.
     * @throws StackException Si la pila esta vacia.
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        if (getSize() == 1) {
            T data = P.getValue();
            P = null;
            return data;
        }
        SingleNode<T> aux = P;
        while (aux.getNext().getNext() != null) {
            aux = aux.getNext();
        }
        T data = aux.getNext().getValue();
        aux.setNext(null);
        return data;
    }

    /**
     * Devuelve el último elemento de la pila sin eliminarlo.
     *
     * @return El último elemento de la pila.
     * @throws StackException Si la pila esta vacia.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        SingleNode<T> aux = P;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        return aux.getValue();
    }

    /**
     * Verifica si la pila esta vacia.
     *
     * @return true si la pila esta vacia, false en caso contrario.
     */
    public boolean isEmpty() {
        return P == null;
    }

    /**
     * Devuelve el tamaño de la pila, es decir, la cantidad de elementos
     * presentes.
     *
     * @return El numero de elementos en la pila.
     */
    public int getSize() {
        int size = 0;
        SingleNode<T> aux = P;
        while (aux != null) {
            size++;
            aux = aux.getNext();
        }
        return size;
    }

    /**
     * Retorna el contenido de la pila en una cadena de texto
     *
     * @return String cadena con el contenido de la pila
     */
    public String getAllElementsAsString() {
        StringBuilder sb = new StringBuilder();
        SingleNode<T> current = P;
        while (current != null) {
            sb.append(current.getValue()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }

}
