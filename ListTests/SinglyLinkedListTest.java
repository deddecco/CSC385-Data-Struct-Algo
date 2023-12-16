package ListTests;

import SinglyLinkedList.SinglyLinkedList;

public class SinglyLinkedListTest {
     public static void main(String[] args) {
          SinglyLinkedList<Character> characterSinglyLinkedList = new SinglyLinkedList<Character>();
          System.out.println(characterSinglyLinkedList);
          characterSinglyLinkedList.add(0, 'a');
          System.out.println(characterSinglyLinkedList);
          characterSinglyLinkedList.add(1, 'b');
          System.out.println(characterSinglyLinkedList);
          characterSinglyLinkedList.add(2, 'c');
          System.out.println(characterSinglyLinkedList);
          characterSinglyLinkedList.prepend('e');
          System.out.println(characterSinglyLinkedList);
          System.out.println(characterSinglyLinkedList.indexOf('e'));
          characterSinglyLinkedList.removeFirst();
          System.out.println(characterSinglyLinkedList);
     }

}