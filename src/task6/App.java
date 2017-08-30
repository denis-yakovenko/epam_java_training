package task6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static task6.Product.ProductTerm;
import static task6.Deposit.PaymentOfInterest;

public class App {
    private List<Bank> banks = new ArrayList<>();

    @Test
    public void Test() {
        App app = new App();

        Bank bank1 = new Bank("PrivateBank");
        bank1.addProduct(new Credit("Classic", 12.0, ProductTerm.MONTH, false, false));
        bank1.addProduct(new Credit("Mortgage", 12.2, ProductTerm.QUARTER, true, true));
        bank1.addProduct(new Credit("Pension", 7.1, ProductTerm.YEAR, false, false));
        bank1.addProduct(new Deposit("Profitable month", 7.1, ProductTerm.MONTH, PaymentOfInterest.AT_THE_END));
        bank1.addProduct(new Deposit("Profitable year", 10.6, ProductTerm.YEAR, PaymentOfInterest.MONTHLY));
        app.banks.add(bank1);

        Bank bank2 = new Bank("CityBank");
        bank2.addProduct(new Credit("Express", 12.0, ProductTerm.YEAR, false, false));
        bank2.addProduct(new Credit("Maximum", 12.2, ProductTerm.MONTH, true, true));
        bank2.addProduct(new Credit("FastCash", 12.2, ProductTerm.MONTH, true, false));
        app.banks.add(bank2);

        assertEquals(app.filterProducts(new CreditFilterCriteria("ss", null, null, null, null)).size(), 2);
        assertEquals(app.filterProducts(new CreditFilterCriteria(null, ProductTerm.MONTH, null, null, null)).size(), 3);
        assertEquals(app.filterProducts(new CreditFilterCriteria(null, ProductTerm.MONTH, 12.2, null, null)).size(), 2);
        assertEquals(app.filterProducts(new CreditFilterCriteria(null, ProductTerm.MONTH, 12.2, null, true)).size(), 1);
        assertEquals(app.filterProducts(new CreditFilterCriteria("i", null, null, null, null)).size(), 3);
        assertEquals(app.filterProducts(new DepositFilterCriteria(null, null, null, null)).size(), 2);
        assertEquals(app.filterProducts(new DepositFilterCriteria("Prof", null, null, null)).size(), 2);
        assertEquals(app.filterProducts(new DepositFilterCriteria(null, ProductTerm.QUARTER, null, null)).size(), 0);
        assertEquals(app.filterProducts(new DepositFilterCriteria(null, null, null, PaymentOfInterest.AT_THE_END)).size(), 1);
    }

    public List<Product> filterProducts(FilterCriteria filterCriteria) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Bank bank : banks
                ) {
            for (Product product : bank.getProducts()
                    ) {
                if (filterCriteria.meetCriteria(product)) filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
