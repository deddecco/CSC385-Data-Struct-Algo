package TreeLab;

public class TreeTest {
     public static void main(String[] args) {
          BinaryTree<String> schools = new BinaryTree<>();
         // System.out.println(schools);
          schools.add("UIS");
          schools.add("UIUC");
          schools.add("SIUE");
          schools.add("SIUC");
          schools.add("NYC");
          schools.add("NWU");
          schools.add("LLCC");
          schools.printLeafNodes(schools.getRoot());
     }
}
