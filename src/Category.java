import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<Product> products;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }
    //카테고리명을 받아서 객체를 생성하고 물품관리 리스트 생성

    public void addProduct(Product product) {
        this.products.add(product);
    }//물품 리스트에 상품 추가

    public List<Product> getProducts() {
        return products;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
