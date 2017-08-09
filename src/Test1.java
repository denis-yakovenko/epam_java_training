/**
 * Created by admin on 08.08.2017.
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        char c = 'c';
        test1.method(c);
        long l = 123L;
        test1.method((int)l);
        short s = 123;
        test1.method(s);

    }

    public void method(int i) {
        System.out.println("int "+i);
    }
    void method() {
        System.out.println("without parameters");
    }
    void method(short j) {
        System.out.println("short "+j);
    }

    double method(double p1, int p2, short p3){
        return p1+p2+p3;
    }

    double method(byte p1, int p2, short p3){
        return p1+p2+p3;
    }

    short method(byte p1, short p2, long p3){
        return (short) (p1+p2+p3);
    }


}

