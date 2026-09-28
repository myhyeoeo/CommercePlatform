import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Category electronics = new Category("전자제품");
        electronics.addProduct(new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 25));
        electronics.addProduct(new Product("iPhone 15", 1350000, "Apple의 최신 스마트폰", 30));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 15));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(electronics);

        CommerceSystem commerceSystem = new CommerceSystem(categoryList);

        commerceSystem.start();
    }
}
