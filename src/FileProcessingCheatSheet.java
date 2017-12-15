import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileProcessingCheatSheet {
    public static void main(String[] args) throws IOException {
        // Come up with the whole way to write text to a file, read from a file, manipulate path names, etc.
        // There are lots of way to do this. Do I want to touch on all of them? Pick one and run with it?
        // Remember, there was an issue in clipboard where it wasn't reading files with newlines as you would expect (platform independent newlines)

        // FileReader/Writer are basic and only support writing characters and streams
        // Wrapping FileReader/Writer in BufferedReader/Writer adds buffering and line-oriented operations

        // basic
        // PrintWriter is similar to System.out
        PrintWriter w = new PrintWriter("test_data.txt"); // could also use a BufferedWriter
        w.println("line one"); // OS-independent line separator
        w.printf("line %d%n", 2); // %n = OS-independent line separator
        w.println("line three");
        w.close();

        BufferedReader i = new BufferedReader(new FileReader("test_data.txt"));
        String line;
        while ((line = i.readLine()) != null) { // .readline() consumes line terminator
            System.out.println("READ: " + line);
        }
        i.close();

        // console (simple prompts for input)
        // (also see InputCheatSheet)
        Console c = System.console();
        if (c == null) {
            System.out.println("No console. Skipping consle sample code.");
        } else {
            String inp = c.readLine("Enter text here Mr. %s", "Smith"); // Can be string literal, or empty for no prompt
            System.out.println("Entered: " + inp);
        }

        // write to a file (write vs append)
        PrintWriter appending = new PrintWriter(new FileWriter("test_data.txt", true));
        appending.println("New line appended"); // uses OS-independent line separator
        appending.printf("another line%n"); // %n - OS-independent line separator
        appending.println("final line");
        appending.close();

        // Note: java.io is older (From Java 1.4) where java.nio is newer
        //   - can use File.toPath() to convert from "old" to "new"
        // - java.nio.file.Path = core of file processing in Java
        //   - java.nio.file.Path replaces java.io.File (from Java 1.7)
        //   - file or directory corresponding to the Path might not exist
        //   - operate on path itself and don't access filesystem
        //   - Paths is a Path helper class
        // - java.nio.file.Files
        //   - static methods that take Path's to read, write, and manipulate files and directories on filesystems.
        Path p1 = Paths.get("c:\\abc\\def");
        System.out.println(p1);
//        Path p1b = Paths.get("aa", "bb", "cc", "dd"); // relative path
        Path p1b = Paths.get("aa\\bb\\cc\\dd"); // relative path
        System.out.println(p1b.toAbsolutePath());
        Path p2 = Paths.get("\\aa\\bb\\cc\\dd");
        System.out.println(p2);
        System.out.println(p2.toString());
        System.out.println(p2.getFileName());
        System.out.println(p2.getParent());
        System.out.println(p2.getRoot()); // null if a relative path
        System.out.println(p2.getNameCount());
        System.out.println(p2.getName(0));
        System.out.println(p2.subpath(1, 3));
        System.out.println(p2.toUri());
        System.out.println(p2.resolve("ee.txt")); // joining two Paths
        System.out.println(p2.resolve(Paths.get("yy\\zz"))); // joining two Paths
        System.out.println(Paths.get("home").relativize(Paths.get("home\\sally\\bar"))); // Result: sally\bar
        p1.equals(p2);
        p1.startsWith(p2);
        p1.endsWith(p2);
        for (Path path_name: p2) {
            System.out.println("Path: " + path_name);
        }
        //
        Path tmp = Paths.get("test_data.txt");
        Files.exists(tmp);
        Files.notExists(tmp);
        Files.isReadable(tmp);
        Files.isWritable(tmp);
        Files.isExecutable(tmp);
        Files.size(tmp);
        Files.isDirectory(tmp);
        Files.isRegularFile(tmp);
//        Files.getLastModifiedTime(tmp);
//        Files.setLastModifiedTime(tmp, FileTime.from(10000L, TimeUnit.DAYS));

        // read lines from a file
        List<String> lines = Files.readAllLines(tmp);
        for (String s: lines) {
            System.out.println("_" + s + "_");
        }

        // stream interface to read lines from a file
        Files.lines(tmp)
                .filter(s -> s.startsWith("line"))
                .forEach(s -> System.out.println("*" + s + "*"));

        Path tmp2 = Paths.get("temp2.txt");
        Path tmp3 = Paths.get("temp3.txt");
        Files.copy(tmp, tmp2);
        Files.move(tmp2, tmp3);
        Files.delete(tmp3);

        Files.createDirectory(Paths.get("mytempdir"));
        Files.delete(Paths.get("mytempdir"));

        // iterate over root directories in filesystem
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path p: dirs) {
            System.out.println(p);
        }

        // iterate over directory
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src"))) {
            for (Path file : stream) {
                System.out.println("In src: " + file.getFileName());
            }
        }
        // iterate over directory with glob matching
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("src"), "*.java")) {
            for (Path entry : stream) {
                System.out.println("Glob: " + entry.getFileName());
            }
        }
    }
}


/* IS THERE ANYTHING USEFUL IN HERE? I DELETED THIS FILE...
# Java File IO Cheat Sheet

### Read text from a file

Files.readAllBytes()

	File file = new File("mypath/myfile.txt");
	String dat = new String(Files.readAllBytes(file.toPath()));

Scanner

	Scanner in = new Scanner(Paths.get("stuff.txt"));
	while (in.hasNextLine()) {
	    System.out.println("LINE:" + in.nextLine());
	}


### Write text to a file

Print Writer

	PrintWriter out = new PrintWriter("stuff.txt");
	out.print("word");
	out.println("line");
	out.printf("f: %s %d\n", "hello", 42);
	out.close();

 */