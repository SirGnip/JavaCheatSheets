import java.util.Arrays;

public class StringCheatSheet {
    public static void main(String[] args) {
        // Class reference: http://docs.oracle.com/javase/8/docs/api/java/lang/String.html
        // Tutorial: http://docs.oracle.com/javase/tutorial/java/data/strings.html
        // Language specification: http://docs.oracle.com/javase/specs/jls/se8/html/jls-10.html
        // Apache Commons StringUtils: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html

        // Notes: Strings are immutable

        // create, initialize
        String unused = new String(); // zero length string
        String lang = new String("Java"); // many different constructor overloads
        String name = "John";
        name.length();
        name.charAt(3);
        lang.concat(name);
        lang = lang + " " + name;
        String other = new String(name); // copy contents
        name.equals(other); // == equality operator tests identity, not equality
        name.equalsIgnoreCase(other);

        // convert strings to numbers
        Integer v99 = Integer.valueOf("42");
        Float pi = Float.valueOf("3.141592654");
        String v2 = new Integer(42).toString();
        String msg1 = "I am " + 42 + " years old";
        // convert numbers to strings
        String v3 = Integer.toString(42);
        String v4 = Double.toString(3.141592654);

        // multiline string literal
        String format = "PI is %.2f" +
                "I checked it %d timeS!";
        // format string
        String msg = String.format(format, 3.1415926, 42);

        // common methods
        // (Most of these methods return new values. In these examples, I do not capture the return value for brevity's sake.)
        name.isEmpty();
        int diff = "first".compareTo("second");
        "hello abc world".contains("abc");
        "abc".startsWith("a");
        "xyz".endsWith("z");
        "  abc ".trim();
        "hello".toUpperCase();
        "HELLO".toLowerCase();
        "hello".substring(1, 3); // "el" inclusive,exclusive
        "John Michael Doe Michael".replace("Michael", "X"); // John X Doe X
        "axbxcxdxxex".replaceAll("x+", "__"); // replace regex matches
        String tokens[] = "abcx123x789".split("x");
        String[] items = {"abc", "def", "ghi"};
        String.join(",", items); // abc,def,ghi
        String.join(",", Arrays.asList("abc", "def", "ghi")); // abc,def,ghi
        int idx = "abcdef".indexOf("xx"); // 3 (-1 if not found)
        boolean matched = "abc123xyz".matches(".*123.*"); // regex match

        // StringBuilder
        // - think of it as a muteable string
        // - normally use String, but if manipulating strings is slow, try StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("abc").append(12345678).append(new Object()); // supports multiple datatypes and chaining
        sb.delete(2,4);
        sb.insert(7, "_hello_");
        sb.replace(3, 5, "************"); // inclusive, exclusive
        sb.reverse();

        // take a StringBuilder, append to it, convert String to use String method, create new StringBuilder from it
        StringBuilder sb2 = new StringBuilder("> ").append("abc");
        StringBuilder sb3 = new StringBuilder(sb2.toString().toUpperCase());
    }
}
