package QueueHeapLab;

import static java.lang.String.format;

public class HeapPQ<T> {

     private AbstractHeap<PriorityNode> heap;

     public HeapPQ(PriorityType pt) {
          switch (pt) {
               case MAX:
                    heap = new MaxHeap<>();
               case MIN:
                    heap = new MinHeap<>();
          }
     }

     public void clear() {
          heap.clear();
     }

     public int getSize() {
          return heap.getSize();
     }

     public T remove() {
          return heap.remove().data;
     }

     public boolean isEmpty() {
          return heap.isEmpty();
     }

     public void add(T data, int priority) {
          PriorityNode pNode = new PriorityNode(data, priority);
          heap.add(pNode);
     }

     public String toString() {
          return heap.toString();
     }

     private class PriorityNode implements Comparable<PriorityNode> {
          private T data;
          private int priority;

          public PriorityNode(T data, int priority) {
               this.data = data;
               this.priority = priority;
          }

          @Override
          public int compareTo(PriorityNode other) {
               return this.priority - other.priority;
          }

          public String toString() {
               return format("(%s, priority = %d)", data.toString(), priority);
          }
     }
}
