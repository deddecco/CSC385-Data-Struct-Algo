package TreeLab;

import src.SortedList.src.EmptyCollectionException;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
     private class Node {
          Node leftChild;
          Node rightChild;
          T data;

          public Node(T data) {
               this.data = data;
          }
     }

     public Node getRoot() {
          return root;
     }

     private Node root;
     private int size;

     public BinaryTree() {
          clear();
     }

     private void clear() {
          root = null;
          size = 0;
     }

     public boolean isEmpty() {
          return size == 0;
     }

     public int getSize() {
          return size;
     }

     public void add(T data) {
          if (isEmpty()) {
               root = new Node(data);
          } else {
               Node current = root;
               Queue<Node> q = new LinkedList<>();
               q.add(current);

               while (true) {
                    current = q.remove();
                    if (current.leftChild != null) {
                         q.add(current.leftChild);
                    } else {
                         break;
                    }
                    if (current.rightChild != null) {
                         q.add(current.rightChild);
                    } else {
                         break;
                    }
               }
               if (current.leftChild == null) {
                    current.leftChild = new Node(data);
               } else {
                    current.rightChild = new Node(data);
               }
          }
          size++;
     }

     public void remove(T toRemove) {
          if (isEmpty()) {
               throw new EmptyCollectionException();
          }
          if (root.data.equals(toRemove) && size == 1) {
               clear();
          } else {
               Node nodeToRemove = getNode(toRemove);
               if (nodeToRemove == null) {
                    throw new IllegalArgumentException("Element with this data doesn't exist");
               }

               if (isLeaf(nodeToRemove)) {
                    removeLeaf(nodeToRemove);
               } else {
                    Node deepestLeaf = deepest(nodeToRemove);
                    T tmp = deepestLeaf.data;
                    deepestLeaf.data = nodeToRemove.data;
                    nodeToRemove.data = tmp;
                    removeLeaf(deepestLeaf);
               }
               size--;
          }
     }

     private void removeLeaf(Node node) {
          Node parent = getParent(node);
          if (parent.leftChild == node) {
               parent.leftChild = null;
          } else {
               parent.rightChild = null;
          }
     }

     private Node deepest(Node rootOfSubtree) {

          Node current = rootOfSubtree;

          Queue<Node> q = new LinkedList<>();
          q.add(current);
          while (!q.isEmpty()) {
               current = q.remove();
               if (current.leftChild != null) {
                    q.add(current.leftChild);
               }
               if (current.rightChild != null) {
                    q.add(current.rightChild);
               }
          }

          return current;
     }

     private Node getParent(Node child) {
          Node result;
          Node current = root;
          Queue<Node> q = new LinkedList<>();
          q.add(current);


          while (true) {
               current = q.remove();

               if (current.leftChild == child || current.rightChild == child) {
                    result = current;
                    break;
               }

               if (current.leftChild != null) {
                    q.add(current.leftChild);
               }
               if (current.rightChild != null) {
                    q.add(current.rightChild);
               }
          }
          return result;
     }

     private Node getNode(T toGet) {
          Node result = null;
          Node current = root;
          Queue<Node> q = new LinkedList<>();
          q.add(current);
          while (!q.isEmpty()) {
               current = q.remove();
               if (current.data.equals(toGet)) {
                    result = current;
                    break;
               }
               if (current.leftChild != null) {
                    q.add(current.leftChild);
               }
               if (current.rightChild != null) {
                    q.add(current.rightChild);
               }
          }

          return result;
     }

     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          if (!isEmpty()) {
               levelOrderString(sb);
          }
          sb.append(']');

          return sb.toString();
     }

     private void levelOrderString(StringBuilder sb) {
          Node current = root;
          Queue<Node> q = new LinkedList<>();
          q.add(current);
          while (!q.isEmpty()) {
               current = q.remove();
               sb.append(current.data);

               if (current.leftChild != null) {
                    q.add(current.leftChild);
               }
               if (current.rightChild != null) {
                    q.add(current.rightChild);
               }

               if (current.rightChild != null || current.leftChild != null) {
                    sb.append(',');
               }

          }
     }

     private boolean isLeaf(Node node) {
          return node.rightChild == null && node.leftChild == null;
     }

     private void preorderPrint(Node current) {
          if (current != null) {
               System.out.println(current.data);
               preorderPrint(current.leftChild);
               preorderPrint(current.rightChild);
          }
     }

     public void preorderPrint() {
          preorderPrint(root);
     }

     public String inOrderToString() {
          StringBuilder sb = new StringBuilder();
          sb.append('[');
          inOrderToString(sb, root);
          sb.append(']');
          return sb.toString();
     }

     private void inOrderToString(StringBuilder sb, Node current) {
          if (current != null) {
               inOrderToString(sb, current.leftChild);
               if (current.leftChild != null) {
                    sb.append(',');
               }
               sb.append(current.data);
               inOrderToString(sb, current.rightChild);
               if (current.rightChild != null) {
                    sb.append(',');
               }
          }

     }

     public void postOrderToString(StringBuilder sb, Node current) {
          if (current != null) {
               postOrderToString(sb, current.leftChild);
               if (current.leftChild != null) {
                    sb.append(',');
               }
               postOrderToString(sb, current.rightChild);
               if (current.rightChild != null) {
                    sb.append(',');
               }
               sb.append(current.data);
          }
     }

     public int getHeight() {
          return getHeight(root) - 1;
     }

     private int getHeight(Node current) {
          if (current == null) {
               return 0;
          } else {
               int leftHeight = 1 + getHeight(current.leftChild);
               int rightHeight = 1 + getHeight(current.rightChild);

               return Math.max(leftHeight, rightHeight);
          }
     }

     public int getHeight(T subtree) {
          Node sub = new Node(subtree);
          if (sub == null) {
               throw new IllegalArgumentException("Element does not exist");
          }
          return getHeight(subtree) - 1;
     }

     public void printLeafNodes(Node node) { // base case
          if (node == null) {
               return;
          }
          if (node.leftChild == null && node.rightChild == null) {
               System.out.println(node.data);
          }
          printLeafNodes(node.leftChild);
          printLeafNodes(node.rightChild);
     }

}