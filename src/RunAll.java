public class RunAll {
    /** General Interfaces and Collection notes

     The goal of these cheat sheets is to create "executable cheat sheets"

     Tutorial: http://docs.oracle.com/javase/tutorial/collections/interfaces/index.html

     Refer to an interface type rather than implementation type so that if you decide to change implementation, you
     only have to chnage it one place (at construction-time). For example:
     List<String> items = new ArrayList<String>();
     */
    public static void main(String[] args) throws Exception {
        ArrayCheatSheet.main(args);
        FileProcessingCheatSheet.main(args);
        ListCheatSheet.main(args);
        MapCheatSheet.main(args);
        SetCheatSheet.main(args);
        StreamsCheatSheet.main(args);
        OptionalCheatSheet.main(args);
        StringCheatSheet.main(args);
        InputCheatSheet.main(args);
        NestedClassCheatSheet.main(args);
        MethodReferenceCheatSheet.main(args);
    }
}
