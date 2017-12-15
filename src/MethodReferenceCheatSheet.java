class Person {
    private String name;
    Person(String name) {
        this.name = name;
    }
    public Integer getAge(String s) {
        return this.name.length() + s.length();
    }
    public Integer getSpeed(String s) {
        return 10 + this.name.length() + s.length();
    }
}

// Functional interface
interface FunctInf {
    Integer getPersonsNum(Person p, String s);
}

// Functional interface
interface FunctInf2 {
    Integer getPersonsNum(String s);
}

public class MethodReferenceCheatSheet {
    // Tutorial: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

    public static Integer calcAgeFromPerson(Person p, String s) {
        return p.getAge(s);
    }
    public static void main(String[] args) {
        Integer r;
        Person john = new Person("John");

        // Method references do the exact same things as lambdas (see notes on lambdas in NestedClassCheatSheet),
        // but makes inferences/assumptions to reduce unnecessary code for the
        // common situation where a lambda would simply call another method with
        // a matching signature.  Provides a simple way to "re-route" calls.

        //////// static method
        FunctInf f1 = (person, str) -> MethodReferenceCheatSheet.calcAgeFromPerson(person, str);
        r = f1.getPersonsNum(john, "hello");
        FunctInf f2 = MethodReferenceCheatSheet::calcAgeFromPerson;
        r = f2.getPersonsNum(john, "hello");

        //////// particular object
        // object is external to functional interface signature
        FunctInf2 f3 = (str) -> john.getAge(str);
        r = f3.getPersonsNum("hello");
        FunctInf2 f4a = john::getAge;
        r = f4a.getPersonsNum("hello");
        FunctInf2 f4b = john::getSpeed;
        r = f4b.getPersonsNum("hello");

        //////// arbitrary object
        // object used by method reference is passed as first argument of functional interface signature
        FunctInf f5 = (person, str) -> person.getAge(str);
        r = f5.getPersonsNum(john, "hello");
        FunctInf f6a = Person::getAge;
        r = f6a.getPersonsNum(john, "hello");
        FunctInf f6b = Person::getSpeed;
        r = f6b.getPersonsNum(john, "hello");
    }
}
