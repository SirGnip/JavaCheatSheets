import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* a functional interface */
interface MyBlah {
    void blah();
}

class ConcreteBlah implements MyBlah {
    private int val = 99;
    ConcreteBlah(int v) {
        val = v;
    }
    public void blah() {
        blahImpl();
    }
    private void blahImpl() {
        System.out.println("ConcreteBlah.blah is " + val);
    }
}

public class NestedClassCheatSheet {
    public static class MyNested implements MyBlah {
        public void blah() {
            System.out.println("MyNested.blah");
        }
    }

    public static void main(String[] args) {
        // inner class
        doBlah(new MyNested());


        // anonymous class
        MyBlah b = new MyBlah() {
            @Override
            public void blah() {
                System.out.println("anon class blah");
            }
        };
        doBlah(b);


        // Concrete class with data members that implements a functional interface
        //
        // Often, lambdas are used to provide implementations of functional interfaces (one abstract method). But,
        // I wanted to see if a standard class (with constructor, data members, other methods)
        // that implemented the functional interface could be passed to something that takes a functional interface.
        // Answer: yes, it can.
        ConcreteBlah concreteBlah = new ConcreteBlah(42);
        doBlah(concreteBlah);


        // lamdba
        doBlah(() ->
            System.out.println("lambda blah")
        );


        // store a reference to an object created from a lambda
        MyBlah stuff = () -> System.out.println("ref to lambda");
        stuff.blah();


        // When you use a lambda, you are:
        // - declaring a class (anonymous) which implements the specified functional interface
        // - providing a definition for the one method (body of lambda) of the functional interface
        // - creating an instance of this new class


        // Store a reference to an object created via a method reference
        // (See MethodReferenceCheatSheet for more examples)
        MyBlah stuff2 = System.out::println;
        stuff2.blah();


        //////////
        // standard functional interfaces
        Predicate<Integer> f1 = x -> x % 2 == 0;
        System.out.println("Predicate: " + f1.test(99));

        Supplier<Integer> f2 = () -> 99;
        System.out.println("Supplier: " + f2.get());

        Consumer<Integer> f3 = x -> System.out.println("Consumer: " + x);
        f3.accept(42);

        Function<String, Integer> f4 = s -> s.length() * 2;
        System.out.println("Function: " + f4.apply("Hello"));

        Runnable f5 = () -> System.out.println("running");
        f5.run();
    }

    // Method that is passed something that implements a functional interface
    private static void doBlah(MyBlah b) {
        b.blah();
    }
}

