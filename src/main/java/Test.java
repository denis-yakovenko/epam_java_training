
public class Test {

    int x = 1;

    public class Inner{

        /*static*/ int x = 5;

        public void method(){
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        new Test().new Inner().method();
        testMethod(() -> System.out.println("do something"));
        testMethod((InterfaceNameWithParam) System.out::println);
        testMethod((s, s1) -> System.out.println(s+s1));
    }

    public static void testMethod(InterfaceName x) {
        x.performTask1();
        x.performTask2();
    }

    public static void testMethod(InterfaceNameWithParam x) {
        x.performTask1();
        x.performTask2();
    }

    public static void testMethod(InterfaceName2Param x) {
    }

    public static boolean test3() {
        outerLoop:
        while (true) {
            while (true) {
                if (true) {
                    break outerLoop;
                }
            }
        } // exits to here
        Runnable asteroid = () -> {
            System.out.println("Orbiting");
            //orbit();
        };
        Thread asteroidThread1 = new Thread(asteroid);
        Thread asteroidThread2 = new Thread(asteroid);
        asteroidThread1.run();
        asteroidThread2.run();
        return false;
    }

    public static boolean test2() {
        int intValue3 = 0X64; // 100 decimal from hex
        int intValue4 = 0144; // 100 decimal from octal
        char msgValue1 = 0b01001111; // O
        char msgValue2 = 0B01001011; // K
        char msgValue3 = 0B0010_0001; // !
        long longValue = 100L;
        float floatValue1 = 9.15f, floatValue2 = 1_168f;
        Float floatValue3 = new Float(20F);
        double doubleValue1 = 3.12;
        Double doubleValue2 = new Double(1e058);
        float expValue1 = 10.0e2f, expValue2 = 10.0E3f;
        String stringValue1 = new String("Valid literal.");
        String stringValue2 = "Valid.\nOn new line.";
        String stringValue3 = "Joins str" + "ings";
        String stringValue4 = "\"Escape Sequences\"\r";
        String stringValue7 = new String("thatString");
        String stringValue8 = stringValue7.intern();
        char[] cArray = {'\u004B', 'O', '\'', 0x0064, 041,
                (char) 131105, 0b00100001}; // KO'd!!!
        byte rounds = 12, fighters = (byte) 130 /* 130-256=-126 */, fighters1 = (byte) 300; /* 300-256=44 */
        int twoDimensionalArray[][] = new int[6][6];
        twoDimensionalArray[0][0] = 100;
        int threeDimensionalArray[][][] = new int[2][2][2];
        threeDimensionalArray[0][0][0] = 200;
        int varDimensionArray[][] = {{0, 0}, {1, 1, 1},
                {2, 2, 2, 2}};
        varDimensionArray[0][0] = 300;
        int[] luckyNumbers = new int[]{7, 13, 21};
        // Add string to pool
        String first = "chairs";
        // Use string from pool
        String second = "chairs";
        // Create a new string
        String third = new String("chairs");
        // Contrary to popular belief, this evaluates
        // to true. Try it!
        if (first == second) {
            System.out.println("first == second");
        }
        // This evaluates to true
        if (first.equals(second)) {
            System.out.println("first equals second");
        }
        // This evaluates to false
        if (first == third) {
            System.out.println("first == third");
        }
        // This evaluates to true
        if (first.equals(third)) {
            System.out.println("first equals third");
        }
        return true;
    }

    public static void test1() {
        A a = new A(1);
        System.out.println(a.a);
        change(a);
        System.out.println(a.a);
        Integer i = 1;
        System.out.println(i);
        change(i);
        System.out.println(i);
    }

    public static void change(Integer i) {
        i++;
        System.out.println(i);
    }

    public static void change(A i) {
        i.a = i.a + 1;
    }

    private static class A {
        Integer a;

        public A(Integer a) {
            this.a = a;
        }
    }
}

@FunctionalInterface
interface InterfaceName {
    void doAbstractTask();
    default void performTask1() {
        System.out.println("Msg from task 1.");
    }
    default void performTask2() {
        System.out.println("Msg from task 2.");
    }
}

@FunctionalInterface
interface InterfaceNameWithParam {
    void doAbstractTask(String s);
    default void performTask1() {
        System.out.println("Msg from task 1.");
    }
    default void performTask2() {
        System.out.println("Msg from task 2.");
    }
}

@FunctionalInterface
interface InterfaceName2Param {
    void doAbstractTask(String s, String s1);
}
