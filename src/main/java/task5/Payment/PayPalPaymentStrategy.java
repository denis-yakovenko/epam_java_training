package task5.Payment;

public class PayPalPaymentStrategy implements IPayment {
    @Override
    public void pay(double price) {
        System.out.println("Paying by PayPal, total price is: " + price);
    }
}
