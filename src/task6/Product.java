package task6;

public abstract class Product {
    private ProductType type;
    private String name;
    private ProductTerm term;
    private Double interestRate;

    public Product(ProductType type, String name, ProductTerm term, Double interestRate) {
        this.type = type;
        this.name = name;
        this.interestRate = interestRate;
        this.term = term;
    }

    public enum ProductTerm {
        MONTH, QUARTER, YEAR
    }

    public enum ProductType {
        CREDIT, DEPOSIT
    }

    public ProductType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ProductTerm getTerm() {
        return term;
    }

    public Double getInterestRate() {
        return interestRate;
    }
}
