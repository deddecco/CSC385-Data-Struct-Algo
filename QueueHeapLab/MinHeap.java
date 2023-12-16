package QueueHeapLab;

public class MinHeap<T extends Comparable<? super T>> extends AbstractHeap<T> {
     @Override
     protected void reheapUp(int idx) {
          int parentIdx = idx / 2;
          T current = heap.get(idx);
          while (idx > 1) {
               T parent = heap.get(parentIdx);
               int result = current.compareTo(parent);
               if (result < 0) {
                    swap(idx, parentIdx);
               } else {
                    break;
               }
               idx = parentIdx;
               parentIdx = idx / 2;
          }
     }

     @Override
     protected void reheapDown(int idx) {

          int size = getSize();
          T current = null;
          if (!isEmpty()) {
               current = heap.get(idx);
          }
          while (idx <= size) {
               T left = getLeft(idx);
               T right = getRight(idx);
               int swapIdx = -1;
               if (left != null && right != null) {
                    int res = left.compareTo(right);
                    if (res <= 0) {
                         res = left.compareTo(current);
                         if (res < 0) {
                              swapIdx = idx * 2;
                         }
                    } else {
                         res = right.compareTo(current);
                         if (res > 0) {
                              swapIdx = idx * 2 + 1;
                         }
                    }
               } else if (left != null) {
                    int res = left.compareTo(current);
                    if (res < 0) {
                         swapIdx = idx * 2;
                    }
               }
               if (swapIdx != -1) {
                    swap(idx, swapIdx);
                    idx = swapIdx;
               } else {
                    break;
               }
          }
     }
}