package MyStack;

public class LinkedStackTester {

     public static void main(String[] args) {
          LinkedStack<String> myNewLinkedStack = new LinkedStack<>();
          myNewLinkedStack.push("A");
          myNewLinkedStack.push("B");
          myNewLinkedStack.push("C");
          while (!myNewLinkedStack.isEmpty()) {
               System.out.println(myNewLinkedStack.pop());
          }
     }
}
