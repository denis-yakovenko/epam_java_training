package task6;

public class Credit extends Product {
    private Boolean earlyRepayment;
    private Boolean creditLineEnlargement;

    public Credit(String name, Double interestRate, ProductTerm termInMonths, Boolean earlyRepayment, Boolean creditLineEnlargement) {
        super(ProductType.CREDIT, name, termInMonths, interestRate);
        this.earlyRepayment = earlyRepayment;
        this.creditLineEnlargement = creditLineEnlargement;
    }

    public Boolean getEarlyRepayment() {
        return earlyRepayment;
    }

    public Boolean getCreditLineEnlargement() {
        return creditLineEnlargement;
    }
}
