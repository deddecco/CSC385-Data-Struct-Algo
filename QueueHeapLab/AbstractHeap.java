package QueueHeapLab;

import java.util.ArrayList;

public abstract class AbstractHeap<T extends Comparable<? super T>> {
     protected ArrayList<T> heap;

     public void clear() {
          heap = new ArrayList<>();
          heap.add(null);
     }

     public AbstractHeap() {
          clear();
     }

     public int getSize() {
          return heap.size() - 1;
     }

     public boolean isEmpty() {
          return getSize() - 1 == 0;
     }

     protected T getLeft(int idx) {
          int leftIdx = idx * 2;
          if (leftIdx <= getSize()) {
               return heap.get(leftIdx);
          }
          return null;
     }

     protected T getRight(int idx) {
          int rightIdx = idx * 2 + 1;
          if (rightIdx <= getSize()) {
               return heap.get(rightIdx);
          }
          return null;
     }


     public void add(T data) {
          heap.add(data);
          reheapUp(getSize());
     }

     protected abstract void reheapUp(int idx);

     public T remove() {
          T toRemove = heap.get(1);
          swap(1, getSize());
          heap.remove(getSize());
          reheapDown(1);
          return toRemove;
     }

     protected abstract void reheapDown(int idx);

     protected void swap(int idx1, int idx2) {
          T tmp = heap.get(idx1);
          heap.set(idx1, heap.get(idx2));
          heap.set(idx2, tmp);
     }

     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          for (int i = 1; i < heap.size(); i++) {
               sb.append(heap.get(i));
               if (i < heap.size() - 1) {
                    sb.append(',');
               }
          }
          sb.append(']');
          return sb.toString();
     }
}
