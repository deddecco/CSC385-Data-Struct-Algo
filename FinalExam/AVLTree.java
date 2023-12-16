package FinalExam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static java.lang.Math.max;


public class AVLTree<T extends Comparable<? super T>> {

     private Node root;
     private int size;

     //Do Not Modify
     public boolean isEmpty() {
          return size == 0;
     }

     //Do Not Modify
     public boolean add(T item) {
          boolean added = false;
          if (isEmpty()) {
               root = new Node(item);
               size++;
               added = true;
          } else {
               added = add(null, root, item);
          }

          return added;
     }

     //Do Not Modify
     private boolean add(Node parent, Node current, T data) {
          boolean added = false;
          if (current == null) {
               int result = data.compareTo(parent.data);

               if (result < 0) {
                    parent.left = new Node(data);
               } else {
                    parent.right = new Node(data);
               }
               size++;
               return true;
          } else if (data.compareTo(current.data) < 0) {
               added = add(current, current.left, data);
          } else if (data.compareTo(current.data) > 0) {
               added = add(current, current.right, data);
          } else {
               return false;
          }

          fixHeight(current);

          if (added) {
               rebalance(parent, current);
          }

          return added;
     }

     //Do Not Modify
     private int getHeight(Node node) {
          if (node == null) {
               return -1;
          }

          return max(node.leftHeight, node.rightHeight);
     }

     //Do Not Modify
     private void fixHeight(Node node) {
          if (node != null) {
               node.leftHeight = getHeight(node.left) + 1;
               node.rightHeight = getHeight(node.right) + 1;
          }
     }

     //Do Not Modify
     private void rebalance(Node parent, Node node) {
          if (node == null) {
               return;
          }
          //Left
          if (balance(node) > 1) {
               //Handle Case III
               if (balance(node.left) < 0) {
                    //left rotation
                    node.left = leftRotation(node.left);
               }
               //right rotation
               if (parent == null) {
                    root = rightRotation(node);
               } else if (parent.left == node) {
                    parent.left = rightRotation(node);
               } else {
                    parent.right = rightRotation(node);
               }
               //Right
          } else if (balance(node) < -1) {
               //Handle Case IV
               if (balance(node.right) > 0) {
                    node.right = rightRotation(node.right);
               }

               //left rotation
               if (parent == null) {
                    root = leftRotation(node);
               } else if (parent.left == node) {
                    parent.left = leftRotation(node);
               } else {
                    parent.right = leftRotation(node);
               }
          }
     }

     //Do Not Modify
     private int balance(Node node) {
          return node.leftHeight - node.rightHeight;
     }

     //Do Not Modify
     private Node rightRotation(Node n) {
          Node c = n.left;
          Node t2 = c.right;

          c.right = n;
          n.left = t2;

          fixHeight(n);
          fixHeight(c);

          return c;
     }

     //Do Not Modify
     private Node leftRotation(Node n) {
          Node c = n.right;
          Node t2 = c.left;

          c.left = n;
          n.right = t2;

          fixHeight(n);
          fixHeight(c);

          return c;
     }

     /***********STUDENT CODE******************/

     //Final Part 2 Question
     public Set<T> outer() {
          // this is the set to be returned
          HashSet<T> outerElements = new HashSet<>();
          // a tree with a single node is blocked from the bottom
          if (size == 1) {
               outerElements.add(null);
               return outerElements;
          }

          // an empty tree has no nodes, so by definition it has no unblocked nodes
          if (root == null) {
               return outerElements;
          }
          // one method calls both the paths for the root to the max and root to the min
          addExtremes(outerElements);
          // then look through the whole tree to find other unblocked nodes
          // by recursively examining the left and right subtrees
          findUnblocked(root, outerElements);
          // this is a set, so even if a node is covered by multiple conditions, it'll only be added once
          return outerElements;
     }

     // method makes calls to both min and max paths
     private void addExtremes(HashSet<T> outerElements) {
          // put every element from the root to the min in the set
          outerElements.addAll(pathToMin(root));
          // and every element from the root to the max
          outerElements.addAll(pathToMax(root));
     }

     // traverse all the way right from the root to the maximum
     private Set<T> pathToMax(Node current) {
          HashSet<T> rootToMax = new HashSet<>();
          // current is always called as root
          // starting from there, until it's no longer possible, go right
          // add the data of every node you visit along the way to the set
          while (current != null) {
               rootToMax.add(current.data);
               current = current.right;
          }
          // return a set that represents the root, its right child, that node's right child, that node's right child....
          return rootToMax;
     }


     // traverse all the way left from the root to the minimum
     private Set<T> pathToMin(Node current) {
          HashSet<T> rootToMin = new HashSet<>();
          // current is always called as root
          // starting from there, until it's no longer possible, go left
          // add the data of every node you visit along the way to the set
          while (current != null) {
               rootToMin.add(current.data);
               current = current.left;
          }
          // return a set that represents the root, its left child, that node's left child, that node's left child....
          return rootToMin;
     }

     // find inner unblocked nodes by traversing recursively
     private void findUnblocked(Node node, Set<T> result) {
          // if the parameter node isn't null
          if (node != null) {
               // if it's NOT the case that both left and right of node are non-null-- that is, if at most one of them is--then the node isn't blocked
               if (node.left == null || node.right == null) {
                    // unblocked nodes should have their data added to the set
                    result.add(node.data);
               }
               // find the unblocked nodes in the left subtree and add them to the result set
               findUnblocked(node.left, result);
               // find the unblocked nodes in the right subtree and add them to the result set
               findUnblocked(node.right, result);
          }
     }

     /****************************************/

     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append("{ ");
          if (!isEmpty()) {
               Queue<Node> q = new LinkedList<>();
               Node temp = root;
               do {
                    sb.append(temp.data);
                    if (temp.left != null) {
                         q.add(temp.left);
                    }
                    if (temp.right != null) {
                         q.add(temp.right);
                    }
                    if (!q.isEmpty()) {
                         sb.append(", ");
                         temp = q.remove();
                    } else {
                         break;
                    }
               } while (true);
          }
          sb.append(" }");
          return sb.toString();
     }

     private class Node {
          private Node left;
          private Node right;
          private int leftHeight;
          private int rightHeight;
          private final T data;

          public Node(T data) {
               this.data = data;
          }
     }
}