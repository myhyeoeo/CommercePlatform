public class Product {

    private String productName; // 상품명
    private int price; // 가격
    private String description; // 설명
    private int productLeft; // 재고

    public Product(String productName, int price, String description, int productLeft){
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.productLeft = productLeft;
    }

    public int getPrice() {
        return price;
    }

    public int getProductLeft() {
        return productLeft;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    public void subProductLeft(int quantity){
        this.productLeft -= quantity;
    }
}
