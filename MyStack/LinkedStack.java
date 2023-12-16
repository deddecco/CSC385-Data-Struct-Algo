package MyStack;

import java.util.EmptyStackException;

public class LinkedStack<T> {
     private static class Node<E> {
          E data;
          Node<E> prev;
/*
          public Node(Node<E> p, E data) {
               this.data = data;
               this.prev = p;
          }

          public E getData() {
               return data;
          }*/
     }

     private Node<T> top;
     private int size;

     public LinkedStack() {
          clear();
     }

     private void clear() {
          top = null;
          size = 0;
     }

     public int getSize() {
          return size;
     }

     public boolean isEmpty() {
          return size == 0;
     }


     public void push(T newData) {
          Node<T> newNode = new Node<>();
          newNode.data = newData;
          if (!isEmpty()) {
               newNode.prev = top;
          }
          top = newNode;
          size++;
     }

     public T pop() {
          if (isEmpty()) {
               throw new EmptyStackException();
          }
          T data = top.data;
          Node<T> temp = top;
          top = top.prev;
          temp.prev = null;
          size--;
          return data;
     }

     public T peek() {
          if (isEmpty()) {
               throw new EmptyStackException();
          }
          return top.data;
     }
}