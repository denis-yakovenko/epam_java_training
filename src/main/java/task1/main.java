package task1;
import java.math.BigInteger;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number of Fibonacci to get");
        while (true) {
            try {
                fibonacci.setMaxIterations(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("invalid number of maximum iterations. please input valid number");
            }
        }
        System.out.println("input an index of Fibonacci array you want to show");
        while (true) {
            try {
                fibonacci.setIndex2Show(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("invalid index of an array of Fibonacci list. please input valid number");
            }
        }
        fibonacci.calcFibonacci(0, BigInteger.ZERO, BigInteger.ZERO);
        System.out.println(String.format("evens: %d pieces, odds: %d pieces", fibonacci.getEvenCount(), fibonacci.getOddCount()));
        System.out.println(
                String.format(
                    "evens: %.2f%%, odds: %.2f%%",
                    (float) fibonacci.getEvenCount() / (fibonacci.getEvenCount() + fibonacci.getOddCount()) * 100,
                    (float) fibonacci.getOddCount() / (fibonacci.getOddCount() + fibonacci.getOddCount()) * 100
                )
        );
        System.out.println(String.format("number with index %d is %s", fibonacci.getIndex2Show(), fibonacci.getNumber2Show()));
    }
}
