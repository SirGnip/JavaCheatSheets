import java.util.*;

public class MapCheatSheet {
    public static void main(String[] args) {
        // Class reference: http://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
        // Tutorial: http://docs.oracle.com/javase/tutorial/collections/interfaces/map.html
        // Collections Framework Overview (with nice chart of all classes): http://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

        // basic
        HashMap<String, String> days = new HashMap<>();
        days.put("Mon", "Monday");
        days.put("Tues", "Tuesday");
        String day = days.get("Mon");
        System.out.println(days);

        // accessing
        days.isEmpty();
        days.size();
        days.get("Tues");
        days.get("nothing"); // returns null
        days.getOrDefault("nothing", "DEAULT");
        days.containsKey("Mon");
        days.containsValue("Noday");

        // copy
        HashMap<String, String> daysCopy = new HashMap<>(days);

        // mutate
        daysCopy.clear();
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "January");
        String val = months.putIfAbsent("Jan", "NeverUsed"); // returns "January"
        months.putAll(days); // puts all elements from days into months
//      .merge() // ?
//      .compute() // ?
        months.remove("Mon");
        months.remove("Tues", "Tuesday"); // remove only if Tues is mapped ot Tuesday
        months.replace("Festivus", "Christmas"); // replace entry only if is currently mapped to some value
        months.replace("Jan", "NonJanuary", "January"); // replace entry only if is currently mapped to given value
        months.replaceAll((k, v) -> "NEW" + k + v); // replace each entry value with result of given function

        // iterating
        for (String key : days.keySet()) {
            System.out.println(days.get(key));
        }
        for (Map.Entry<String, String> entry: days.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }

//        for (int i = 0; i < a.size(); ++i) {
//            System.out.println(a.get(i));
//        }
//        for (Integer val: a) {
//            System.out.println(val);
//        }
//        a.forEach(val -> {
//            System.out.println(val);
//        });

        //////// conversion

        // List to Array
//        List<String> z = Arrays.asList("Beatrice", "Gerty", "Floyd");
//        String[] other = new String[z.size()];
//        String[] conv = z.toArray(other);

    }
}
