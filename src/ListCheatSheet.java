import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCheatSheet {
    public static void main(String[] args) {
        // Class Reference: http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#ArrayList--
        // Tutorial: http://docs.oracle.com/javase/tutorial/collections/interfaces/list.html
        // Collections Framework Overview (with nice chart of all classes): http://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

        // basic
        List<Integer> a = new ArrayList<>(); //
        a.add(42);
        a.add(99);
        System.out.println(a);

        // creation, initialization and literals
        Integer[] blah = {1, 2, 3};
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(blah));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(new Integer[]{2, 4, 6, 8}));
        d.addAll(c);
        ArrayList<Integer> clone = (ArrayList<Integer>)d.clone(); // requires cast?
        b.clear();
        List<Integer> testList = new ArrayList(); // lists are often created this way...
        List<Integer> nums = Arrays.asList(2, 4, 6, 8); // be careful as this is an array-backed, quasi-immuteable, special List
        List<String> strings = Arrays.asList("abc", "def", "ghi");
        List<String> arguments = Arrays.asList(args); // convert args array to List
        //List<Integer> blah = List.of(2, 4, 6); // Java 9 (shorter, safer)

        // accessing
        d.isEmpty();
        d.size();
        d.get(3);
        d.contains(42);
        d.indexOf(6); // first index where object is found, otherwise -1
        List<Integer> blah2 = d.subList(1, 3);
        blah2.set(1, 1243);

        // mutate
        d.set(1, 99); // set index 1 to value 99
        d.remove(2); // by index
        d.remove((Integer)8); // by value (cast used to force use of the Object overload
        d.removeAll(a); // removes all items in a from d
        d.removeIf(v -> v % 3 == 0);
        d.sort(Integer::compareTo); // should be able to drop the comparator argument in Java 8?
        Collections.sort(d);
        d.replaceAll(v -> v + 100); // replaces all elements with result of function (UnaryOperator, lambda, etc.)

        // iterating
        for (int i = 0; i < a.size(); ++i) {
            System.out.println(a.get(i));
        }
        for (Integer val: a) {
            System.out.println(val);
        }
        a.forEach(val -> {
            System.out.println(val);
        });

        //////// conversion

        // List to Array
        List<String> z = Arrays.asList("Beatrice", "Gerty", "Floyd");
        String[] other = new String[z.size()];
        String[] conv = z.toArray(other);
    }
}
