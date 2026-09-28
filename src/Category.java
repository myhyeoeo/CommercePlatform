import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<Product> products;

    public Category(String categoryName){
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    } //한 번에 어레이리스트를 초기화해주고 객체 생성하는건 안될까?

    public String getCategoryName() {
        return categoryName;
    }
}
