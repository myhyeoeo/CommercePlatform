import java.util.Scanner;

public class OrderController {
    private Cart cart;
    private Customer customer;

    public OrderController(Cart cart, Customer customer) {
        this.cart = cart;
        this.customer = customer;
    }

    public void showCategoryProducts(Category category, Scanner sc) {
        // 카테고리와 스캐너를 받아온다. 스캐너를 받음으로써 객체를 더 생성하지 않고 자원 낭비 X

        while (true) {
            System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");
            for (int i = 0; i < category.getProducts().size(); i++) {
                Product product = category.getProducts().get(i);
                System.out.println(i + 1 + ". " + product.getProductName() + " | " + product.getPrice() + "원 | " + product.getDescription() + " | 재고 : " + product.getProductLeft() + "개");
            }
            System.out.println("0. 뒤로가기");
            // 선택한 카테고리의 물품 출력
            System.out.print("번호를 선택하세요 : ");
            int userChoice = sc.nextInt();
            if (userChoice == 0) {
                System.out.println("플랫폼 메인으로 돌아갑니다");
                break;
            } else if (userChoice > 0 && userChoice <= category.getProducts().size()) {
                Product product = category.getProducts().get(userChoice - 1);
                System.out.println("선택한 상품 : " + product.getProductName() + " | " + product.getPrice() + "원 | " + product.getDescription() + " | 재고 : " + product.getProductLeft() + "개");
                System.out.println("\n위 상품을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                System.out.print("번호를 선택하세요 : ");
                int cartChoice = sc.nextInt();
                sc.nextLine();
                if (cartChoice == 1) {
                    cart.addProduct(product);
                    System.out.println(product.getProductName() + "가 장바구니에 추가되었습니다");
                } else if (cartChoice == 2) {
                    System.out.println("장바구니 추가를 취소했습니다");
                } else {
                    System.out.println("잘못된 번호입니다");
                }
            } else {
                System.out.println("잘못된 번호입니다");
            }
        }
        // 입력받은 번호에 해당하는 물품의 상세정보를 출력

    }

    public void order(Scanner sc) {
        cart.printCartTotal();
        System.out.println("\n1. 주문 확정    2. 메인으로 돌아가기");
        System.out.print("번호를 입력하세요 : ");
        int choice = sc.nextInt();
        sc.nextLine();
        int total = 0;
        if (choice == 1) {
            for (CartItem cartItem : cart.getProducts()) {
                Product product = cartItem.getProduct();
                int quantity = cartItem.getQuantity();
                product.subProductLeft(quantity);
            }
            System.out.println("주문이 완료되었습니다!");
            for (CartItem cartItem : cart.getProducts()) {
                total += cartItem.getProduct().getPrice();
            }
            System.out.println("총 결제 금액 : " + (total - total * customer.getGrade().getDiscountRate()));
            cart.clearCart();
            System.out.println("장바구니가 초기화되었습니다");
        } else if (choice == 2) {
            System.out.println("주문을 취소하고 메인으로 돌아갑니다");
        } else {
            System.out.println("잘못된 번호입니다");
        }
    }

}
