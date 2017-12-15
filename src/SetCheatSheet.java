import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetCheatSheet {
    public static void main(String[] args) {
        // Class reference: http://docs.oracle.com/javase/8/docs/api/index.html?java/util/HashMap.html
        // Tutorial: http://docs.oracle.com/javase/tutorial/collections/interfaces/set.html
        // (shows union, intersection, difference idioms)
        // Collections Framework Overview (with nice chart of all classes): http://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

        // Note: Sets only allow unique values

        // basic
        Set<Integer> items = new HashSet<Integer>();
        items.add(42);
        items.add(5);
        items.add(99);
        System.out.println(items);

        // creation, initialization and literals
        Set<Integer> odds = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13));

        // accessing
        items.isEmpty();
        items.size();
        items.contains(99);
        items.containsAll(Arrays.asList(5, 13));

        // mutating
        items.remove(6);
        items.addAll(Arrays.asList(2, 4, 6, 8, 11, 13));
        items.removeAll(Arrays.asList(2, 13));
        items.retainAll(Arrays.asList(42, 4, 6, 8, 11));
        items.removeIf(v -> v % 2 == 0);

        // copying
        Set<Integer> dupe = new HashSet<Integer>(items);
        dupe.clear();

        // iterating
        for (Integer i: items) {
            System.out.println(i);
        }
        items.forEach(val -> {
            System.out.println(val);
        });

        // conversion

    }
}
