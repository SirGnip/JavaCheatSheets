import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCheatSheet {
    public static void main(String[] args) {
        // "Aggregate Operations" Tutorial: http://docs.oracle.com/javase/tutorial/collections/streams/index.html
        // Interface Stream<T> Reference: http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

        // Stream - a sequence of elements, carries values from a source through a pipeline
        // - not a data structure that stores elements
        //
        // A pipeline contains a sequence of aggregate operations (as it passes and transforms streams):
        // - a source - a collection or object
        // - zero or more intermediate operations - transform a stream into another stream
        // - a terminal/reduction operation - returns one value (or a collection) by combining the contents of a stream
        //
        // intermediate operations: filter, map. mapToInt
        // terminal/reduction operations: average, sum, min, max, count, forEach, reduce collect

        //// Setup
        List<String> names = new ArrayList<>(Arrays.asList("Bob", "Chris", "Fay", "Mary", "Fred", "Charlie", "Doyle", "Frank", "Marcus", "Don", "Jason", "Biff", "Francis"));

        //// Basic
        names.stream()
                .filter(n -> n.contains("a"))
                .forEach(System.out::println);

        //// Literal
        Stream.of("foo", "bar", "baz")
                .filter(s -> s.startsWith("b"))
                .forEach(System.out::println);

        //// Intermediate operations: filter & map
        names.stream()
                .filter(n -> n.startsWith("B")) // transforms stream into anothre stream
                .forEach(System.out::println);
        names.stream()
                .map(n -> n.length())  // transforms stream into another stream
                .forEach(System.out::println);
        names.stream()
                .mapToInt(p -> p.length())
                .sum();

        //// Terminal/reduction operation
        // Because streams are lazy, intermediate steps will NOT be execute if there is no terminal operation.
        names.stream().count();
        // reduce = general purpose terminal: repeatedly call reduction function
        // Reduction function must be of same type as incoming stream
        names.stream()
                .map(String::length)
                .reduce(0, (running, current) -> running + current);
        List<String> collect = names.stream()
                .collect(Collectors.toList());// .collect() can also be called in a general purpose mode where you pass in method references to mutate an object
        Map<String, List<String>> map = names.stream()
                .collect(Collectors.groupingBy(n -> n.substring(0,2)));
        for (String key: map.keySet()) {
            System.out.println("KEY:" + key + "   val:" + map.get(key));
        }
        names.stream()
                .forEach(n -> System.out.println(n));
        names.stream()
                .filter(n -> n.startsWith("B"))
                .findFirst() // returns an Optional<T>
                .orElse("nuthin"); // method on Optional

        // IntStream terminal/reduction operations
        int sum1 = names.stream()
                .mapToInt(n -> n.length())
                .sum();
        OptionalInt min = names.stream()
                .mapToInt(n -> n.length())
                .min();
        OptionalInt max = names.stream()
                .mapToInt(n -> n.length())
                .max();
        OptionalDouble average = names.stream()
                .mapToInt(n -> n.length())
                .average();
    }
}
