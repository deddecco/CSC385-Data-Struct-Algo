package QueueHeapLab;

import static QueueHeapLab.PriorityType.MIN;

public class TestPQ {
     public static void main(String[] args) {
          HeapPQ<Integer> heapPQ = new HeapPQ<>(MIN);

    /*      heapPQ.add(10, 100);
          heapPQ.add(5, 110);
          heapPQ.add(15, 105);*/
          heapPQ.add(10, 1);
          heapPQ.add(30, 2);
          heapPQ.add(01, 1);
          heapPQ.add(21, 1);
          heapPQ.add(02, 2);
          heapPQ.add(12, 1);
          heapPQ.add(32, 3);
          heapPQ.add(23, 1);
          heapPQ.add(33, 2);

          System.out.println(heapPQ);

     }
}
