package src.SortedList.src;

public class SortedList<T extends Comparable<? super T>> {

     //Fields
     Node first = null;
     int size = 0;

     //Constructor
     public SortedList() {
          clear();
     }

     public boolean isEmpty() {
          return size == 0;
     }

     // null out the pointer to first
     // set size to 0
     public void clear() {
          first = null;
          size = 0;
     }

     // return the size of the list
     public int getSize() {
          return size;
     }

     // find the proper place for an element given that a list must always be sorted, and put it there
     public void add(T data) {

          Node newNode = new Node(data);
          Node nodeBefore = getNodeBefore(data);

          if (isEmpty() || nodeBefore == null) {
               newNode.next = first;
               first = newNode;
          } else {
               newNode.next = nodeBefore.next;
               nodeBefore.next = newNode;
          }
          size++;
     }

     // locate the node that should come before the node which you want to insert
     private Node getNodeBefore(T data) {
          Node current = first;
          Node nodeBefore = null;
          while ((current != null) && data.compareTo(current.data) > 0) {
               nodeBefore = current;
               current = current.next;
          }
          return nodeBefore;
     }


     // remove a node at a given index from the list; if the list is empty or if the index is negative or too big,
     // throw the appropriate exception
     // if removal is allowed, return the data
     public T removeAt(int idx) {
          // handle edge cases
          if (idx < 0) {
               throw new IndexOutOfBoundsException();
          }
          if (size == 0) {
               throw new EmptyCollectionException();
          }

          if (idx <= size - 1) {
               // the data you will return
               T result;
               // if you want to remove the first node
               if (idx == 0) {
                    result = removeFirst();
               }
               // to remove any other node
               else {
                    result = removeOther(idx);
               }
               // return the data
               return result;
          } else {
               // if an index is too big, throw an exception
               throw new IndexOutOfBoundsException();
          }
     }

     // remove any element except the first and return its data
     private T removeOther(int index) {
          Node nodeBefore = getNodeBefore(get(index));
          Node toRemove = nodeBefore.next;
          T result = toRemove.data;
          nodeBefore.next = toRemove.next;
          size--;
          return result;
     }


     // remove the first element of a list and return its data
     private T removeFirst() {
          T result = first.data;
          first = first.next;
          size--;
          return result;
     }


     // return the data at a given index; if the collection is empty or the index
     // provided does not exist in the collection, throw an appropriate exception
     public T get(int idx) {
          // handle empty case
          if (size == 0) {
               throw new EmptyCollectionException();
          }

          //handle cases out of bounds
          if (idx < 0 || idx >= size) {
               throw new IndexOutOfBoundsException();
          }

          //start at first node
          // the index of that node is 0
          Node target = first;
          int indexOfNode = 0;

          // traverse while indexOfNode is less than the parameter
          while (indexOfNode < idx) {
               // if you get into the loop
               // move the node you want to get to the next one
               target = target.next;
               // move the index
               indexOfNode++;
          }

          // once the index reaches the parameter, return the data of that node.
          return target.data;

     }

     // return a boolean that is true if find() returns any number >=0 and false otherwise
     public boolean contains(T data) {
          return find(data) != -1;
     }


     // implement an indexOf()-like method that returns the first occurrence of a piece of data
     public int find(T data) {
          // start searching at the beginning
          Node currentNode = first;
          // index whee found for first time
          int i = 0;
          // while element isn't null
          while ((currentNode != null)) {
               // if data matches, report this index
               if (data.equals(currentNode.data)) {
                    return i;
               } else {
                    // otherwise move to the next node, and move the index by 1
                    currentNode = currentNode.next;
                    i++;
               }
          }

          // if the element is never found, return -1
          return -1;
     }

     // if an element is in the list, return how many times it shows up
     // if it is not in the list, return 0
     public int count(T data) {
          // if the data is not found, return 0
          if (find(data) == -1) {
               return 0;
          }

          // otherwise, count the length of the run of elements for which data is all the same as what was passed in
          int count = 0;
          for (int i = find(data); i < size; i++) {
               if (get(i).equals(data)) {
                    count++;
               }
          }

          return count;
     }

     // given the list that calls this method and the list that gets passed in
     // remove all the elements of the parameter list from the calling list
     public void removeAll(SortedList<T> otherList) {

          int index = 0;
          Node currentList1 = first;
          Node currentList2 = otherList.first;

          while ((currentList2 != null) && (currentList1 != null)) {
               // while l1 strictly less than l2
               // move l1
               // this is linear
               while (currentList1 != null && (currentList1.data.compareTo(currentList2.data) < 0)) {
                    currentList1 = currentList1.next;
                    index++;
               }

               // if l2 found in l1
               // remove

               while (currentList1 != null && currentList2.data.equals(currentList1.data)) {
                    currentList1 = currentList1.next;
                    removeAt(index);
               }
               currentList2 = currentList2.next;
          }


     }

     @Override
     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          if (!isEmpty()) {
               Node tmp = first;
               for (int i = 0; i < size - 1; i++) {
                    sb.append(tmp.data.toString());
                    sb.append(",");
                    tmp = tmp.next;
               }
               sb.append(tmp.data.toString());
          }
          sb.append(']');
          return sb.toString();
     }

     //Your node class.  You may move it to a different file, but
//you will need to change this to public class Node
     private class Node {
          private final T data;
          private Node next;

          public Node(T data) {
               this.data = data;
               this.next = null;
          }
     }
}