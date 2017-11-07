package Task7;

public enum Payment {
    CASH("CASH"), CREDIT_CARD("CREDIT_CARD");

    private String text;

    Payment(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Payment fromString(String text) {
        for (Payment payment : Payment.values()) {
            if (payment.text.equalsIgnoreCase(text)) {
                return payment;
            }
        }
        return null;
    }
}
