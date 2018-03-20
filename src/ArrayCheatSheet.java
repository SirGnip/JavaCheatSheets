import java.util.Arrays;
import java.util.List;

public class ArrayCheatSheet {
    public static void main(String[] args) {
        // Class reference: none
        // Tutorial: http://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
        // Language specification: http://docs.oracle.com/javase/specs/jls/se8/html/jls-10.html
        // Array Module: http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Array.html
        // Arrays Module: http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html

        // Notes:
        // - can not change size of array in Java
        // - when passed into a method, the contents of an array are muteable

        // basic
        int[] odds = {1, 3, 5, 7};
        System.out.println(odds); // prints out hash? id? pointer?
        System.out.println(Arrays.toString(odds)); // prints out items

        // creation, initialization and literals
        int[] b = new int[3]; // initialized to zeros (null for String)
        int[] a = {1, 3, 5}; // array literal
        int[] evens = new int[]{2, 4, 6};
        System.out.println(new int[]{2, 4, 6, 8, 10}); // pass array literal to function
        System.out.println(new String[]{"four", "score", "and", "seven"}); // pass array literal to function

        // indexing and assignment
        a[0] = 42; // assign to index
        int c = a[1]; // index into array
        b = a; // assigns each variable a reference to same data

        // iteration
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int val: a) {
            System.out.println(val);
        }

        // copying
        int[] trg = new int[7];
        System.arraycopy(odds, 0, trg, 0, odds.length); // (src, srcStart, trg, trgStart, length)

        // Multidimensional arrays
        // In Java, a multidimensional array is one whose components are themselves arrays
        int[][] grid = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        System.out.println(grid[1][3]); // [row][column]
        for (int[] row: grid) {
            for (int val: row) {
                System.out.println(val);
            }
        }
        // because Java arrays are "arrays-in-arrays", you can have ragged arrays
        int[][] ragged = {
                {1, 2, 3, 4, 5},
                {6, 7},
                {8, 9, 10}
        };

        // Arrays module (see reference link above)
        // (compare, sort, fill, search, copy, toString, etc.)
        System.out.println(Arrays.toString(a));

        // convert Array to List
        Integer[] x = {2, 4, 6, 8}; // List<T> must contain an object. Can't have List of primitive type.
        List<Integer> items = Arrays.asList(x); // returns a fixed-size list backed by the specified array
        System.out.println(x[1] + " " + items.get(1));
        x[1] = 999; // if you mutate backing array, you are also mutating the List
        System.out.println(x[1] + " " + items.get(1));
    }
}
