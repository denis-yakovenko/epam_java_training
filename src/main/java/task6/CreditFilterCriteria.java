package task6;

import static task6.Product.ProductType;
import static task6.Product.ProductTerm;

public class CreditFilterCriteria extends FilterCriteria {
    private Boolean earlyRepayment;
    private Boolean creditLineEnlargement;

    public CreditFilterCriteria(String name,
                                ProductTerm termInMonths,
                                Double interestRate,
                                Boolean earlyRepayment,
                                Boolean creditLineEnlargement) {
        super(ProductType.CREDIT, name, termInMonths, interestRate);
        this.earlyRepayment = earlyRepayment;
        this.creditLineEnlargement = creditLineEnlargement;
    }

    @Override
    public Boolean meetCriteria(Product product) {
        if (!(product instanceof Credit)) return false;
        Credit credit = (Credit) product;
        if (!super.meetCriteria(product)) return false;
        if (earlyRepayment != null && !earlyRepayment.equals(credit.getEarlyRepayment())) return false;
        if (creditLineEnlargement != null && !creditLineEnlargement.equals(credit.getCreditLineEnlargement()))
            return false;
        return true;
    }
}
