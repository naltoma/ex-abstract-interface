public class Main {
    public static void main(String[] args) {
        // 商品の作成
        Product book = new Book("Java入門", 2970.0, 500.0); // 本: 2970円, 送料: 500円
        Product electronics = new Electronics("ノイズキャンセルイヤホン", 9800.0, 0.1); // 電子製品: 5000円, 割引率: 10%

        // 支払い方法の作成
        PaymentMethod creditCard = new CreditCardPayment("1234-5678-9876-5432");
        PaymentMethod paypal = new PayPalPayment("user@example.com");

        // 本を購入し、クレジットカードで支払い
        book.addToCart();
        creditCard.pay(book.calculateTotalPrice());

        // 電子製品を購入し、PayPalで支払い
        electronics.addToCart();
        paypal.pay(electronics.calculateTotalPrice());
    }
}