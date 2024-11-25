// 支払いインターフェース
interface PaymentMethod {
    void pay(double amount);
}

// クレジットカード支払い
class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + "円。Credit Card: " + cardNumber);
    }
}

// PayPal支払い
class PayPalPayment implements PaymentMethod {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + "円。PayPal account: " + email);
    }
}