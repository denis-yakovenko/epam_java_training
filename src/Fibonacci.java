import java.math.BigInteger;

public class Fibonacci {
    private Integer maxIterations;
    private Integer index2Show;
    private BigInteger number2Show;
    private Integer evenCount = 0;
    private Integer oddCount = 0;

    public void setMaxIterations(Integer maxIterations) {
        this.maxIterations = maxIterations;
    }

    public Integer getIndex2Show() {
        return index2Show;
    }

    public void setIndex2Show(Integer index2Show) {
        this.index2Show = index2Show;
    }

    public BigInteger getNumber2Show() {
        return number2Show;
    }

    public Integer getEvenCount() {
        return evenCount;
    }

    public Integer getOddCount() {
        return oddCount;
    }

    public void calcFibonacci(int iteration, BigInteger currentSum, BigInteger previousSum) {
        BigInteger newCurrentSum;
        System.out.println(String.format("iteration: %d value: %s", iteration, currentSum));
        if (iteration == index2Show)
            number2Show = currentSum;
        if (currentSum.remainder(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            evenCount++;
        else oddCount++;
        iteration++;
        if (iteration < 2) {
            newCurrentSum = BigInteger.valueOf(iteration);
        } else {
            newCurrentSum = currentSum.add(previousSum);
        }
        previousSum = currentSum;
        if (iteration < maxIterations)
            try {
                calcFibonacci(iteration, newCurrentSum, previousSum);
            } catch (StackOverflowError e) {
                System.out.println("unable to calculate more numbers");
            }
    }
}
