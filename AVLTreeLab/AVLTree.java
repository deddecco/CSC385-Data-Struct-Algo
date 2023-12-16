package AVLTreeLab;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<? super T>> {

     private Node root;
     private int size;

     public void clear() {
          root = null;
          size = 0;
     }

     public int getSize() {
          return size;
     }

     public int getHeight() {
          return getHeight(root);
     }

     private int getHeight(Node node) {
          if (node == null) {
               return -1;
          }
          return Math.max(node.leftHeight, node.rightHeight);
     }

     private void fixHeight(Node node) {
          if (node != null) {
               node.leftHeight = getHeight(node.left) + 1;
               node.rightHeight = getHeight(node.right) + 1;
          }
     }

     public boolean isEmpty() {
          return size == 0;
     }

     public boolean add(T item) {
          boolean added = false;
          if (isEmpty()) {
               root = new Node(item);
               size += 1;
               added = true;
          } else {
               added = add(null, root, item);
          }

          return added;
     }

     private boolean add(Node parent, Node current, T data) {
          boolean added = false;
          if (current == null) {
               int result = data.compareTo(parent.data);

               if (result < 0) {
                    parent.left = new Node(data);
               } else {
                    parent.right = new Node(data);
               }
               size += 1;
               return true;
          } else if (data.compareTo(current.data) < 0) {
               added = add(current, current.left, data);
          } else if (data.compareTo(current.data) > 0) {
               added = add(current, current.right, data);
          } else {
               return false;
          }


          fixHeight(current);
          return added;
     }

     public boolean remove(T item) {
          if (isEmpty()) {
               return false;
          } else if (size == 1 && root.data.equals(item)) {
               clear();
               return true;
          } else if (removeTraversal(null, root, item)) {
               size -= 1;
               return true;
          } else {
               return false;
          }
     }

     private boolean removeTraversal(Node parent, Node current, T data) {
          boolean removed = true;
          if (current == null) {
               return false;
          } else if (data.compareTo(current.data) < 0) {
               removed = removeTraversal(current, current.left, data);
          } else if (data.compareTo(current.data) > 0) {
               removed = removeTraversal(current, current.right, data);
          } else {
               removeNode(parent, current);
          }

          fixHeight(current);
          if (removed) {
               rebalance(parent, current);
          }

          return removed;
     }

     private int balance(Node node) {
          return node.leftHeight - node.rightHeight;
     }

     private Node rightRotate(Node n) {
          Node c = n.left;
          Node t2 = c.right;

          c.right = n;
          n.left = t2;
          fixHeight(n);
          fixHeight(c);

          return c;
     }

     private Node leftRotate(Node n) {
          Node c = n.right;
          Node t2 = c.left;

          c.left = n;
          n.right = t2;
          fixHeight(n);
          fixHeight(c);

          return c;
     }

     private void rebalance(Node parent, Node node) {
          if (node == null) {
               return;
          }
          if (balance(node) > 1) {
               if (balance(node.left) < 0) {
                    node.left = leftRotate(node.left);
               }
               if (parent == null) {
                    root = rightRotate(node);
               } else if (parent.left == node) {
                    parent.left = rightRotate(node);
               } else {
                    parent.right = rightRotate(node);
               }
          } else if (balance(node) < -1) {
               if (balance(node.right) > 0) {
                    node.right = rightRotate(node.right);
               }
               if (parent == null) {
                    root = leftRotate(node);
               } else if (parent.left == node) {
                    parent.left = leftRotate(node);
               } else {
                    parent.right = leftRotate(node);
               }
          }
     }

     private void removeNode(Node parent, Node current) {
          if (current.left == null && current.right == null) {
               //Remove leaf node
               removeCase1(parent, current);
          } else if (current.left != null && current.right == null) {
               //Remove node with no right child
               removeCase2(parent, current);
          } else if (current.left == null) {
               //Remove node with no left child
               removeCase3(parent, current);
          } else {
               //Remove node with both children
               removeCase4(parent, current);
          }

     }

     private void removeCase1(Node parent, Node current) {
          if (parent == null) {
               root = null;
          } else if (parent.left == current) {
               parent.left = null;
          } else {
               parent.right = null;
          }
     }

     private void removeCase2(Node parent, Node current) {
          if (parent == null) {
               root = root.left;
          } else if (parent.left == current) {
               parent.left = current.left;
          } else {
               parent.right = current.left;
          }
          current.left = null;
     }

     private void removeCase3(Node parent, Node current) {
          if (parent == null) {
               root = root.right;
          } else if (parent.left == current) {
               parent.left = current.right;
          } else {
               parent.right = current.right;
          }
          current.right = null;
     }

     private void removeCase4(Node parent, Node current) {
          Node leftMost = current.right;
          Node leftMostParent = current;

          while (leftMost.left != null) {
               leftMostParent = leftMost;
               leftMost = leftMost.left;
          }

          current.data = leftMost.data;

          removeNode(leftMostParent, leftMost);
          rebalance(current, current.right);
     }

     @Override
     public String toString() {
          return levelOrderString();
     }

     public String levelOrderString() {
          StringBuilder sb = new StringBuilder();

          sb.append("{");

          if (!isEmpty()) {
               Queue<Node> q = new LinkedList<>();

               q.add(root);
               Node current = null;

               while (!q.isEmpty()) {

                    current = q.remove();
                    if (current.left != null) {
                         q.add(current.left);
                    }

                    if (current.right != null) {
                         q.add(current.right);
                    }

                    sb.append(current.data);
                    if (!q.isEmpty()) {
                         sb.append(", ");
                    }
               }

          }

          sb.append("}");

          return sb.toString();
     }

     private class Node {
          private Node left;
          private Node right;

          private int leftHeight;
          private int rightHeight;

          private T data;

          public Node(T data) {
               this.data = data;
          }
     }
}











