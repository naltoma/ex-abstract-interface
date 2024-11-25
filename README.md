# abstract, interfaceを用いた例

## ECサイトを例に（シナリオ）
1.	ECサイトでは、異なる商品タイプ（例：本、電子製品、衣服）を扱います。
2.	各商品タイプには共通のプロパティ（名前、価格、購入機能）がありますが、送料や割引のルールが異なります。
3.	支払い方法（例：クレジットカード、PayPal）は複数種類あり、それぞれ異なる処理を持ちます。

## クラス図
- Product クラスは共通の属性とメソッドを持つ抽象クラス。
- Book と Electronics は Product を継承し、それぞれ固有の価格計算ロジックを実装。
- PaymentMethod はインターフェースで、CreditCardPayment と PayPalPayment が実装。

```mermaid
classDiagram
    class Product {
        - String name
        - double price
        + Product(String name, double price)
        + String getName()
        + double getPrice()
        + void addToCart() // カートに入れた金額を出力
        + abstract double calculateTotalPrice()
    }

    class Book {
        - double shippingFee // 本は郵送料を設定
        + Book(String name, double price, double shippingFee)
        + double calculateTotalPrice() // price + shippingFee
    }

    class Electronics {
        - double discountRate // 電化製品は割引率を設定
        + Electronics(String name, double price, double discountRate)
        + double calculateTotalPrice() // price * (1-discountRate)
    }

    Product <|-- Book
    Product <|-- Electronics
```

```mermaid
classDiagram
    class PaymentMethod {
        <<interface>>
        + void pay(double amount) //支払い出力
    }

    class CreditCardPayment {
        - String cardNumber
        + CreditCardPayment(String cardNumber)
        + void pay(double amount) //cardNumberも出力
    }

    class PayPalPayment {
        - String email
        + PayPalPayment(String email)
        + void pay(double amount)//emailも出力
    }

    PaymentMethod <|.. CreditCardPayment
    PaymentMethod <|.. PayPalPayment
```
