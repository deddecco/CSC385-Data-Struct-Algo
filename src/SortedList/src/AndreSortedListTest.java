package src.SortedList.src;

import static org.junit.jupiter.api.Assertions.*;

// Both my parents are CS professionals, and my dad in particular wrote the first few
// of these JUnit tests to help me work through my code, and then once I learned from him
// how to write them, I wrote a lot more of them myself
class AndreSortedListTest {

     @org.junit.jupiter.api.Test
     void isEmpty() {
          SortedList<Integer> sl = new SortedList<>();
          SortedList<Integer> sl2 = new SortedList<>();

          assertTrue(sl.isEmpty());

          sl.add(2);

          assertFalse(sl.isEmpty());

          sl.removeAt(0);
          assertTrue(sl.isEmpty());

          sl.add(2);
          sl.add(3);

          sl2.add(2);
          sl2.add(2);
          sl2.add(3);
          sl2.add(4);

          assertFalse(sl.isEmpty());

          sl.removeAll(sl2);

          assertTrue(sl.isEmpty());
     }

     @org.junit.jupiter.api.Test
     void clear() {
     }

     @org.junit.jupiter.api.Test
     void getSize() {

          SortedList<Integer> s1 = new SortedList<>();
          assertEquals(0, s1.size);
          s1.add(1);
          assertEquals(1, s1.size);
          s1.add(2);
          assertEquals(2, s1.size);
          s1.add(3);
          assertEquals(3, s1.size);
          s1.add(4);
          assertEquals(4, s1.size);
          s1.add(5);
          assertEquals(5, s1.size);
     }

     @org.junit.jupiter.api.Test
     void add() {
          SortedList<Integer> s1 = new SortedList<>();
          assertFalse(s1.contains(0));
          s1.add(0);
          assertTrue(s1.contains(0));
          s1.add(-1);
          assertTrue(s1.contains(-1));
          s1.add(1);
          assertTrue(s1.contains(1));
          s1.add(1);
          assertEquals(2, s1.count(1));
     }

     @org.junit.jupiter.api.Test
     void removeAt() {
          SortedList<Integer> s1 = new SortedList<>();
          s1.add(0);
          s1.add(2);
          s1.add(1);
          s1.add(4);
          s1.add(6);
          s1.add(3);
          s1.add(5);

          s1.removeAt(0);
          assertEquals(s1.toString(), "[1,2,3,4,5,6]");
          s1.removeAt(2);
          assertEquals(s1.toString(), "[1,2,4,5,6]");
     }

     @org.junit.jupiter.api.Test
     void get() {
          SortedList<Integer> s1 = new SortedList<>();

          s1.add(1);
          s1.add(2);
          s1.add(0);
          s1.add(3);
          s1.add(5);
          s1.add(4);
          assertEquals(s1.get(0), 0);
          assertEquals(s1.get(1), 1);
          assertEquals(s1.get(2), 2);
          assertEquals(s1.get(3), 3);
          assertEquals(s1.get(4), 4);
          assertEquals(s1.get(5), 5);
     }

     @org.junit.jupiter.api.Test
     void contains() {
          SortedList<Integer> s1 = new SortedList<>();
          assertFalse(s1.contains(0));
          s1.add(0);
          assertTrue(s1.contains(0));
     }

     @org.junit.jupiter.api.Test
     void find() {
     }

     @org.junit.jupiter.api.Test
     void count() {
          SortedList<Integer> sl1 = new SortedList<>();

          assertEquals(0, sl1.count(10));

          sl1.add(10);

          assertEquals(0, sl1.count(9));
          assertEquals(1, sl1.count(10));

          sl1.add(9);

          assertEquals(1, sl1.count(9));
          assertEquals(1, sl1.count(10));

          sl1.add(8);

          assertEquals(1, sl1.count(8));
          assertEquals(1, sl1.count(9));
          assertEquals(1, sl1.count(10));

          sl1.add(7);

          assertEquals(1, sl1.count(7));
          assertEquals(1, sl1.count(8));
          assertEquals(1, sl1.count(9));
          assertEquals(1, sl1.count(10));

          sl1.add(7);

          assertEquals(2, sl1.count(7));
          assertEquals(1, sl1.count(8));
          assertEquals(1, sl1.count(9));
          assertEquals(1, sl1.count(10));

          sl1.add(-1);

          assertEquals(1, sl1.count(-1));
          assertEquals(2, sl1.count(7));
          assertEquals(1, sl1.count(8));
          assertEquals(1, sl1.count(9));
          assertEquals(1, sl1.count(10));
     }

     @org.junit.jupiter.api.Test
     void removeAll() {
          SortedList<Integer> sl1 = new SortedList<>();
          SortedList<Integer> sl2 = new SortedList<>();

          sl1.removeAll(sl2);
          assertTrue(sl1.isEmpty() && sl2.isEmpty());

          sl1.clear();
          sl2.clear();

          sl2.add(1);
          sl2.add(1);
          sl2.add(2);
          sl2.add(2);

          sl1.removeAll(sl2);

          assertTrue(sl1.isEmpty());
          assertFalse(sl2.isEmpty());

          sl1.clear();
          sl2.clear();

          sl1.add(1);
          sl1.add(1);
          sl1.add(2);
          sl1.add(2);

          sl1.removeAll(sl2);

          assertFalse(sl1.isEmpty());
          assertTrue(sl2.isEmpty());

          sl1.clear();
          sl2.clear();

          sl1.add(1);
          sl1.add(1);
          sl1.add(2);
          sl1.add(2);
          sl1.add(3);
          sl1.add(3);

          sl2.add(1);
          sl2.add(3);

          sl1.removeAll(sl2);

          assertEquals("[2,2]", sl1.toString());

          sl1.clear();
          sl2.clear();

          sl1.add(1);
          sl1.add(2);
          sl1.add(3);
          sl1.add(4);

          assertEquals("[1,2,3,4]", sl1.toString());
          sl1.removeAll(sl1);
          assertEquals("[]", sl1.toString());
     }

     @org.junit.jupiter.api.Test
     void testToString() {
          SortedList<Integer> sl1 = new SortedList<>();

          assertEquals("[]", sl1.toString());

          sl1.add(10);

          assertEquals("[10]", sl1.toString());

          sl1.add(9);

          assertEquals("[9,10]", sl1.toString());

          sl1.add(8);

          assertEquals("[8,9,10]", sl1.toString());

          sl1.add(7);

          assertEquals("[7,8,9,10]", sl1.toString());

          sl1.add(7);

          assertEquals("[7,7,8,9,10]", sl1.toString());

          sl1.add(100);

          assertEquals("[7,7,8,9,10,100]", sl1.toString());

          sl1.add(-1);

          assertEquals("[-1,7,7,8,9,10,100]", sl1.toString());
     }
}