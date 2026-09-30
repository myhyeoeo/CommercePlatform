import java.util.List;
import java.util.Scanner;

public class AdminController {
    private Admin admin;
    private List<Category> categories;
    private Cart cart;

    public AdminController(Admin admin, List<Category> categories, Cart cart) {
        this.admin = admin;
        this.categories = categories;
        this.cart = cart;
    }

    public void startAdminMode(Scanner sc) {
        int count = 0;
        boolean authenticated = false;
        while (count < 3) {
            System.out.print("관리자 비밀번호를 입력해주세요 : ");
            String inputPassword = sc.nextLine();
            System.out.println();
            count++;
            if (admin.authenticate(inputPassword)) {
                authenticated = true;
                break;
            }
            System.out.println(count + "회 비밀번호 오입력");
        }
        if (!authenticated) {
            System.out.println("메인 화면으로 돌아갑니다");
            return;
        }
        adminMenu(sc);
    }

    public void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\n[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("4. 전체 상품 현황");
            System.out.println("0. 메인으로 돌아가기");
            System.out.print("번호를 입력하세요 : ");

            int userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 1) adminAdd(sc);
            else if (userChoice == 2) adminModify(sc);
            else if (userChoice == 3) adminRemove(sc);
            else if (userChoice == 4) adminReviewAll();
            else if (userChoice == 0) break;
            else System.out.println("잘못된 입력입니다");
        }
    }

    public void adminAdd(Scanner sc) {
        System.out.println("\n어느 카테고리에 상품을 추가하시겠습니까?");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.print("번호를 입력하세요 : ");
        int userChoice = sc.nextInt();
        sc.nextLine();

        if (userChoice > categories.size() || userChoice <= 0) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        adminAddProduct(categories.get(userChoice - 1), sc);
    }

    private void adminAddProduct(Category category, Scanner sc) {
        System.out.println("\n[ " + category.getCategoryName() + "에 상품 추가 ]");
        System.out.print("상품명을 입력해주세요 : ");
        String productName = sc.nextLine();
        System.out.print("가격을 입력해주세요 : ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("상품 설명을 입력해주세요 : ");
        String description = sc.nextLine();
        System.out.print("재고 수량을 입력해주세요 : ");
        int productLeft = sc.nextInt();
        sc.nextLine();

        System.out.println("\n" + productName + " | " + price + "원 | " + description + " | 재고 : " + productLeft + "개");
        System.out.println("위 정보로 상품을 추가하시겠습니까?");
        System.out.println("1. 확인    2. 취소");
        System.out.print("번호를 입력해주세요 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            for (Product product : category.getProducts()) {
                if (product.getProductName().equals(productName)) {
                    System.out.println("이미 등록된 상품이 존재합니다!");
                    return;
                }
            }
            category.addProduct(new Product(productName, price, description, productLeft));
            System.out.println("상품이 성공적으로 추가되었습니다!\n");
        } else if (choice == 2) {
            System.out.println("취소되었습니다.\n");
        } else {
            System.out.println("잘못된 번호입니다\n");
        }
    }

    public void adminModify(Scanner sc) {
        System.out.print("\n수정할 상품명을 입력하세요 : ");
        String inputProductName = sc.nextLine();
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.getProductName().equals(inputProductName)) {
                    System.out.println("현재 상품 정보 : " + product.getProductName() + " | " + product.getPrice() + "원 | " + product.getDescription() + " | 재고 : " + product.getProductLeft());
                    System.out.println("\n1. 가격");
                    System.out.println("2. 설명");
                    System.out.println("3. 재고 수량");
                    System.out.print("수정할 항목을 선택하세요 : ");
                    int userChoice = sc.nextInt();
                    sc.nextLine();

                    if (userChoice == 1) adminModifyPrice(product, sc);
                    else if (userChoice == 2) adminModifyDescription(product, sc);
                    else if (userChoice == 3) adminModifyQuantity(product, sc);
                    else System.out.println("잘못된 입력입니다");
                    return;
                }
            }
        }
        System.out.println("해당 상품을 찾을 수 없습니다.");
    }

    private void adminModifyPrice(Product product, Scanner sc) {
        int oldPrice = product.getPrice();
        System.out.println("현재 가격 : " + oldPrice);
        System.out.print("새로운 가격을 입력해주세요 : ");
        int newPrice = sc.nextInt();
        sc.nextLine();
        product.setPrice(newPrice);
        System.out.println("\n" + product.getProductName() + "의 가격이 " + oldPrice + "원 -> " + newPrice + "원으로 수정되었습니다.");
    }

    private void adminModifyDescription(Product product, Scanner sc) {
        String oldDescription = product.getDescription();
        System.out.println("현재 설명 : " + oldDescription);
        System.out.print("새로운 설명을 입력해주세요 : ");
        String newDescription = sc.nextLine();
        product.setDescription(newDescription);
        System.out.println("\n" + product.getProductName() + "의 설명이 변경되었습니다");
    }

    private void adminModifyQuantity(Product product, Scanner sc) {
        int oldQuantity = product.getProductLeft();
        System.out.println("현재 재고 : " + oldQuantity + "개");
        System.out.print("새로운 재고를 입력해주세요 : ");
        int newQuantity = sc.nextInt();
        sc.nextLine();
        product.setProductLeft(newQuantity);
        System.out.println("\n" + product.getProductName() + "의 재고가 " + oldQuantity + "개 -> " + newQuantity + "개로 변경되었습니다.");
    }

    public void adminRemove(Scanner sc) {
        System.out.print("\n삭제하고 싶은 상품명을 입력하세요 : ");
        String removeProductName = sc.nextLine();
        System.out.println("\n" + removeProductName + "을 삭제하시겠습니까?");
        System.out.println("1. 확인    2. 취소");
        System.out.print("번호를 입력하세요 : ");
        int userChoice = sc.nextInt();
        sc.nextLine();

        if (userChoice != 1) {
            System.out.println("삭제가 취소되었습니다.");
            return;
        }
        boolean removed = false;
        for (Category category : categories) {
            if (category.getProducts().removeIf(p -> p.getProductName().equals(removeProductName))) {
                removed = true;
            }
        }
        if (removed) {
            cart.removeProduct(removeProductName);
            System.out.println(removeProductName + "을 삭제했습니다");
        } else {
            System.out.println("해당 이름의 상품이 존재하지 않습니다.");
        }
    }

    public void adminReviewAll() {
        System.out.println("\n[ 전체 물품 조회 ]");
        for (Category category : categories) {
            System.out.println("\n========== " + category.getCategoryName() + " ==========");
            int count = 1;
            for (Product product : category.getProducts()) {
                System.out.println((count++) + ". " + product.getProductName() + " | " + product.getPrice() + "원 | " + product.getDescription() + " | 재고 : " + product.getProductLeft());
            }
        }
    }
}
