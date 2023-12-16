package SinglyLinkedList;

public class EmptyCollectionException extends RuntimeException {
     public EmptyCollectionException() {
          super();
     }

     public EmptyCollectionException(String msg) {
          super(msg);
     }
}