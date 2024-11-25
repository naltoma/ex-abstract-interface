// 抽象クラス: 商品
abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // 商品名を取得
    public String getName() {
        return name;
    }

    // 基本価格を取得
    public double getPrice() {
        return price;
    }

    // カートに入れる
    public void addToCart() {
        System.out.println(name + " has been added to your cart. Total price: " + calculateTotalPrice() + " yen.");
    }

    // 抽象メソッド: 総価格を計算（送料や割引を含む）
    public abstract double calculateTotalPrice();
}

// 本クラス
class Book extends Product {
    private double shippingFee;

    public Book(String name, double price, double shippingFee) {
        super(name, price);
        this.shippingFee = shippingFee;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() + shippingFee; // 送料を加算
    }
}

// 電子製品クラス
class Electronics extends Product {
    private double discountRate;

    public Electronics(String name, double price, double discountRate) {
        super(name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * (1 - discountRate); // 割引を適用
    }
}