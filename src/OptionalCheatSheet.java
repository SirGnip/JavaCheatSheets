import java.util.Optional;

public class OptionalCheatSheet {
    // Purpose: help design more-comprehensible APIs so that by just reading the signature of a method, you can tell
    // whether you can expect an optional value. (The implication is that if you see a reference to an object, it is
    // expected to exist.  So, a "Object obj" is expected to never be null (can this can be enforced), where an
    // "Optional<Object> obj" may be null.  It sounds like Optional is more of a way to communicate your intent.

    // Reference: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

    public static void main(String[] args) {
        // Creation
        Optional<String> empty = Optional.empty();
        Optional<String> a = Optional.of("hello");
        //Optional<String> b = Optional.of(null); // ERROR: .of() requires non-null value
        Optional<String> c = Optional.ofNullable("hello");
        Optional<String> d = Optional.ofNullable(null);

        // basics
        boolean present = a.isPresent();
        String s1 = a.get(); // If empty, get() throws NoSuchElementException
        String s2 = a.orElse("default");
        Optional<String> r1 = a.filter(x -> x.length() > 2); // if Optional contains a value and it passes filter, return Optional of it. All other cases return an empty Optional.

        // map() and flatMap() apply mapping function and returns result in an Optional IF incoming has a value. Otherwise returns empty Optional.
        // mapping function must return String here
        Optional<String> r2 = a.map(x -> x.toUpperCase());
        // mapping function must return Optional<String> here
        Optional<String> r3 = a.flatMap(x -> x.length() > 3 ? Optional.of("YUP") : Optional.empty());

        // orElse() - return value in Optional if present, otherwise return value in "orElse".
        String myDdefault = a.orElse("default");
        // if/else with Optional
        String result = a.map(val -> val.toUpperCase()).orElse(""); // returns result of map if Optional is present, otherwise return orElse

        // other
        a.ifPresent(x -> System.out.println(x));
    }
}
