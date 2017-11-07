package task5.Payment;

public class CreditCardPaymentStrategy implements IPayment {
    @Override
    public void pay(double price) {
        System.out.println("Paying by a credit card, total price is: " + price);
    }
}
