
public class Test {
    public static void main(String[] args) {
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
        i.a=i.a+1;
    }

    private static class A {
        Integer a;

        public A(Integer a) {
            this.a = a;
        }
    }
}

