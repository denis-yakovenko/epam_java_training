package task6;

import static task6.Product.ProductType;
import static task6.Product.ProductTerm;

public abstract class FilterCriteria {
    private ProductType type;
    private String name;
    private ProductTerm termInMonths;
    private Double interestRate;

    public FilterCriteria(ProductType type,
                          String name,
                          ProductTerm termInMonths,
                          Double interestRate) {
        this.type = type;
        this.name = name;
        this.termInMonths = termInMonths;
        this.interestRate = interestRate;
    }

    public Boolean meetCriteria(Product product) {
        if (type != null && !type.equals(product.getType())) return false;
        if (name != null && !product.getName().toLowerCase().contains(name.toLowerCase())) return false;
        if (termInMonths != null && !termInMonths.equals(product.getTerm())) return false;
        if (interestRate != null && !interestRate.equals(product.getInterestRate())) return false;
        return true;
    }
}
