public class Product {

    String productName; // 상품명
    int price; // 가격
    String description; // 설명
    int productLeft; // 재고

    public Product(String productName, int price, String description, int productLeft){
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.productLeft = productLeft;
    }

}
