import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Category electronics = new Category("전자제품");
        electronics.addProduct(new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 25));
        electronics.addProduct(new Product("iPhone 15", 1350000, "Apple의 최신 스마트폰", 30));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 15));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));

        Category fashion = new Category("의류/패션");
        fashion.addProduct(new Product("오버핏 멜란지 후드티", 69000, "데일리로 입기 좋은 멜란지 그레이 후드", 40));
        fashion.addProduct(new Product("레귤러 와이드 생지 데님", 59000, "깔끔한 실루엣의 생지 데님 팬츠", 35));
        fashion.addProduct(new Product("미니멀 싱글 롱 코트", 189000, "클래식하고 모던한 블랙 울 코트", 20));
        fashion.addProduct(new Product("실버 메탈 워치", 145000, "미니멀한 디자인의 미드나잇 실버 시계", 15));

        // 3. 도서 및 스터디 카테고리
        Category books = new Category("도서/자기계발");
        books.addProduct(new Product("자바의 정석 3판", 30000, "자바 언어의 기초부터 심화까지", 100));
        books.addProduct(new Product("스프링 부트 핵심 원리", 38000, "실무에 바로 쓰는 Spring Boot 가이드", 80));
        books.addProduct(new Product("정보처리기사 실기 완성", 33000, "한 권으로 끝내는 정처기 실기 합격서", 60));

        // 4. 식품 카테고리
        Category food = new Category("식품/음료");
        food.addProduct(new Product("콜드브루 원두 원액 500ml", 18000, "진하고 부드러운 다크 로스팅 스페셜티", 45));
        food.addProduct(new Product("단백질 쉐이크 초코맛 1kg", 32000, "운동 후 빠른 영양 보충을 위한 쉐이크", 50));

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(electronics);
        categoryList.add(fashion);
        categoryList.add(books);
        categoryList.add(food);

        Customer customer = new Customer("김명현", "myeong@naver.com", "SILVER");

        CommerceSystem commerceSystem = new CommerceSystem(categoryList, customer);

        commerceSystem.start();
    }
}
