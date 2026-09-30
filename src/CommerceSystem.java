import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private Admin admin;
    private List<Category> categories;
    private Customer customer;
    private Cart cart;
    private AdminController adminController;
    private OrderController orderController;
    // 속성 : Category를 다루는 리스트

    public CommerceSystem(List<Category> categories, Customer customer) {
        this.categories = categories;
        this.customer = customer;
        this.cart = new Cart(customer);
        this.admin = new Admin("admin123");
        this.adminController = new AdminController(admin, categories, cart);
        this.orderController = new OrderController(cart, customer);
    }
    // 생성자 : Category 리스트를 받아와서 객체 생성

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 출력문 출력
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println(i + 1 + ". " + categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            if (!cart.isEmpty()) {
                System.out.println("\n[ 주문 관리 ]");
                System.out.println(categories.size() + 1 + ". 장바구니 확인   | 장바구니를 확인 후 주문합니다");
                System.out.println(categories.size() + 2 + ". 주문 취소    | 진행중인 주문을 취소합니다.");
                System.out.println(categories.size() + 3 + ". 주문 수정    | 장바구에서 특정 상품을 제합니다.");
            }//장바구니에 무언가 들어있을 때 출력

            System.out.println("99. 관리자 모드");
            System.out.print("번호를 선택하세요 : ");
            int userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
                // 0을 입력한 경우 종료
            }
            if (userChoice > 0 && userChoice <= categories.size()) {
                // 카테고리 선택
                orderController.showCategoryProducts(categories.get(userChoice - 1), sc);
            } else if (!cart.isEmpty() && userChoice == categories.size() + 1) {
                // 장바구니 모두 출력
                System.out.println("\n아래와 같이 주문하시겠습니까?");
                orderController.order(sc);

            } else if (!cart.isEmpty() && userChoice == categories.size() + 2) {
                // 주문 취소
                cart.clearCart();
                System.out.println("장바구니가 초기화 됩니다");
            } else if (userChoice == categories.size() + 3) {

            } else if (userChoice == 99) {
                adminController.startAdminMode(sc);
            } else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }

        }

    }

}
