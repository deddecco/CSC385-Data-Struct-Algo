package MyQueue;

public class LinkedQueue<T> {
     private Node<T> front;
     private Node<T> back;
     private int size;

     private static class Node<E> {
          E data;
          Node<E> next;
/*
          public Node(Node<E> p, E data) {
               this.data = data;
               this.prev = p;
          }

          public E getData() {
               return data;
          }*/
     }

     public LinkedQueue() {
          clear();
     }

     private void clear() {
          front = null;
          back = null;
          size = 0;
     }

     public boolean isEmpty() {
          return size == 0;
     }

     public int getSize() {
          return size;
     }

     public void enqueue(T newData) {
          Node<T> newNode = new Node<>();
          newNode.data = newData;
          if (isEmpty()) {
               front = newNode;
               back = front;
          } else {
               back = newNode;
               back.next = newNode;
          }
          size++;
     }

     public T dequeue() {
          if (isEmpty()) {
               throw new EmptyQueueException("The queue is empty!");
          }
          Node<T> temp = front;
          if (size == 1) {
               clear();
          } else {
               front = front.next;
               temp.next = null;
               size--;
          }
          return temp.data;
     }

     public T getFront() {
          if (isEmpty()) {
               throw new EmptyQueueException("The queue is empty!");
          }
          return front.data;
     }
}