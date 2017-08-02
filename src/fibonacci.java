import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by admin on 02.08.2017.
 */
public class fibonacci {

    private static Integer maxIterations;
    private static Integer evenCount = 0;
    private static Integer oddCount = 0;
    private static ArrayList<BigDecimal> fibonacciList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        System.out.println("input number of fibonacci to get");
        while (true) {
            try {
                inputLine = scanner.nextLine();
                maxIterations = Integer.parseInt(inputLine);
                break;
            } catch (Exception e) {
                System.out.println("invalid number of maximum iterations. please input valid number");
            }
        }
        calcFibonacci(0, BigDecimal.ZERO, BigDecimal.ZERO);
        System.out.println(String.format("evens: %d pieces, odds: %d pieces", evenCount, oddCount));
        System.out.println(String.format(
                "evens: %.2f%%, odds: %.2f%%",
                (float) evenCount / maxIterations * 100,
                (float) oddCount / maxIterations * 100));
        System.out.println("input an index of fibonacci array you want to show");
        while (true) {
            try {
                System.out.println(
                        fibonacciList.get(Integer.parseInt(scanner.nextLine())
                        ));
                break;
            } catch (Exception e) {
                System.out.println("invalid index of an array of fibonacci list. please input valid number");
            }
        }
    }

    private static void calcFibonacci(int iteration, BigDecimal currentSum, BigDecimal previousSum) {
        BigDecimal newCurrentSum;
        System.out.println(String.format("iteration: %d value: %s", iteration, currentSum));
        fibonacciList.add(currentSum);
        if (currentSum.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.valueOf(0)))
            evenCount++;
        else oddCount++;
        iteration++;
        if (iteration < 2) {
            newCurrentSum = BigDecimal.valueOf(iteration);
        } else {
            newCurrentSum = currentSum.add(previousSum);
        }
        previousSum = currentSum;
        if (iteration < maxIterations)
            calcFibonacci(iteration, newCurrentSum, previousSum);
    }

}
