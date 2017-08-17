public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        char c = 'c';
        test1.method(c);
        long l = 123L;
        test1.method((int) l);
        short s = 123;
        test1.method(s);

        int i = 1;
        float j = 1;
        i = (int) j;
        j = i;

        long ii = 123L;
        double jj = 123;
        ii = (long) jj;
        jj = ii;
/*
byte (1 byte)
short (2 bytes)
int (4 bytes)
long (8 bytes)
float (4 bytes)
double (8 bytes)
char (2 bytes)
*/

        long iii = 123L; // 8 bytes
        float jjj = 123; // 4 bytes
        iii = (long) jjj;
        jjj = iii;


    }

    public void method(int i) {
        System.out.println("int " + i);
    }

    void method() {
        System.out.println("without parameters");
    }

    void method(short j) {
        System.out.println("short " + j);
    }

    double method(double p1, int p2, short p3) {
        return p1 + p2 + p3;
    }

    double method(byte p1, int p2, short p3) {
        return p1 + p2 + p3;
    }

    short method(byte p1, short p2, long p3) {
        return (short) (p1 + p2 + p3);
    }

    float method(long p1, int p2, short p3) {
        return p1 + p2 + p3;
    }

}

