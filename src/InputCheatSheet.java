import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/** Reference: https://stackoverflow.com/a/26473083 */
public class InputCheatSheet {
    public static void main(String[] args) throws IOException {
        // demonstrate different ways to read from stdin
        readFromScanner();
        readFromConsole();
        readFromBufferedReader();
        parsingExample();
    }

    private static void readFromScanner() {
        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("NAME: " + name);
    }

    /** Does not work when run from inside IntelliJ, System.console() returns null */
    private static void readFromConsole() {
        Console console = System.console();
        if (console != null) {
            String name = console.readLine("Enter your name: ");
            System.out.println("NAME: " + name);
        } else {
            System.out.println("ERROR: Console not supported");
        }
    }

    private static void readFromBufferedReader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String name = br.readLine();
        System.out.println("NAME: " + name);
    }

    private static void parsingExample() {
        System.out.print("Enter ids separated by commas: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("LINE: " + line);
        String[] tokens = line.split(",");
        for (String token : tokens) {
            System.out.println("Integer: " + Integer.valueOf(token));
        }
    }
}