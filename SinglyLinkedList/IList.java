package SinglyLinkedList;

public interface IList<T> {
     public T get(int index);
     public void set(int index, T t);
     public void add(int index, T t);
     public int indexOf(T t);
     public T remove(int index);
     public boolean remove(T t);
}