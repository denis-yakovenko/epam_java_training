package task6;

import static task6.Product.ProductTerm;
import static task6.Product.ProductType;
import static task6.Deposit.PaymentOfInterest;

public class DepositFilterCriteria extends FilterCriteria {
    private PaymentOfInterest paymentOfInterest;

    public DepositFilterCriteria(String name,
                                 ProductTerm termInMonths,
                                 Double interestRate,
                                 PaymentOfInterest paymentOfInterest) {
        super(ProductType.DEPOSIT, name, termInMonths, interestRate);
        this.paymentOfInterest = paymentOfInterest;
    }

    @Override
    public Boolean meetCriteria(Product product) {
        if (!(product instanceof Deposit)) return false;
        Deposit deposit = (Deposit) product;
        if (!super.meetCriteria(product)) return false;
        if (paymentOfInterest != null && !paymentOfInterest.equals(deposit.getPaymentOfInterest())) return false;
        return true;
    }
}
