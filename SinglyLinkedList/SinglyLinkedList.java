package SinglyLinkedList;

public class SinglyLinkedList<T> implements IList<T> {
     static class Node<G> {
          G data;
          Node<G> next;

          public Node(G data) {
               this.data = data;
          }
     }

     private Node<T> head;
     private int size;

     public SinglyLinkedList() {
          clear();
     }

     public void clear() {
          size = 0;
          head = null;
     }

     @Override
     public T get(int idx) {
          validateIndex(idx, 0, size - 1);
          Node<T> tmp = head;
          for (int i = 0; i < idx; i++) {
               tmp = tmp.next;
          }
          return tmp.data;
     }

     @Override
     public void set(int idx, T t) {
          validateIndex(idx, 0, size - 1);
          Node<T> tmp = head;
          for (int i = 0; i < idx; i++) {
               tmp = tmp.next;
          }
          tmp.data = t;
     }

     private void validateIndex(int idx, int lo, int hi) {
          if (!(idx >= lo && idx <= hi)) {
               throw new IndexOutOfBoundsException();
          }
     }

     public boolean isEmpty() {
          return size == 0;
     }

     @Override
     public void add(int idx, T t) {
          validateIndex(idx, 0, size);
          if (isEmpty()) {
               addToEmpty(t);
          } else if (idx == 0) {
               prepend(t);
          } else if (idx == size) {
               append(t);
          } else {
               Node<T> tmp = head;
               for (int i = 0; i < idx; i++) {
                    tmp = tmp.next;
               }
               Node<T> newNode = new Node<>(t);
               newNode.next = tmp.next;
               tmp.next = newNode;
               size++;
          }
     }

     private void addToEmpty(T t) {
          head = new Node<T>(t);
          size++;
     }

     public void append(T t) {
          if (isEmpty()) {
               addToEmpty(t);
          } else {
               Node<T> tmp = getNode(size - 1);
               tmp.next = new Node<>(t);
               size++;
          }
     }

     public void prepend(T t) {
          if (isEmpty()) {
               addToEmpty(t);
          } else {
               Node<T> newNode = new Node<>(t);
               newNode.next = head;
               head = newNode;
               size++;
          }
     }

     @Override
     public int indexOf(T t) {
          Node<T> tmp = head;
          for (int i = 0; i < size; i++) {
               if (tmp.data.equals(t)) {
                    return i;
               }
               tmp = tmp.next;
          }
          return -1;
     }

     @Override
     public T remove(int idx) throws EmptyCollectionException {
          validateIndex(idx, 0, size - 1);
          if (isEmpty()) {
               throw new EmptyCollectionException();
          }
          if (idx == 0) {
               return removeFirst();
          } else if (idx == size - 1) {
               return removeLast();
          } else {
               Node<T> toRemove = head;
               Node<T> prev = null;
               for (int i = 0; i < idx; i++) {
                    prev = toRemove;
                    toRemove = toRemove.next;
               }
               assert prev != null;
               prev.next = toRemove.next;
               toRemove.next = null;
               size--;
               return toRemove.data;
          }
     }

     public T removeFirst() throws EmptyCollectionException {
          if (isEmpty()) {
               throw new EmptyCollectionException();
          }

          Node<T> tmp = head;
          head = head.next;
          tmp.next = null;
          size--;

          return tmp.data;
     }

     public T removeLast() throws EmptyCollectionException {
          if (isEmpty()) {
               throw new EmptyCollectionException();
          }
          Node<T> tmp = getNode(size - 1);
          tmp.next = null;
          size--;

          return tmp.data;
     }

     @Override
     public boolean remove(T t) {
          int idx = indexOf(t);
          if (idx != -1) {
               remove(idx);
               return true;
          }
          return false;

     }

     private Node<T> getNode(int idx) {

          Node<T> tmp = head;
          for (int i = 0; i < idx; i++) {
               tmp = tmp.next;
          }
          return tmp;
     }

     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          if (!isEmpty()) {
               Node<T> tmp = head;
               for (int i = 0; i < size - 1; i++) {
                    sb.append(tmp.data.toString());
                    sb.append(" , ");
                    tmp = tmp.next;
               }
               sb.append(tmp.data.toString());
          }
          sb.append(']');
          return sb.toString();
     }
}