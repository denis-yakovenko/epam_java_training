package task6;

public class Deposit extends Product {
    private PaymentOfInterest paymentOfInterest;

    public Deposit(String name, Double interestRate, ProductTerm termInMonths, PaymentOfInterest paymentOfInterest) {
        super(ProductType.DEPOSIT, name, termInMonths, interestRate);
        this.paymentOfInterest = paymentOfInterest;
    }

    public enum PaymentOfInterest {
        AT_THE_END, MONTHLY
    }

    public PaymentOfInterest getPaymentOfInterest() {
        return paymentOfInterest;
    }

}
