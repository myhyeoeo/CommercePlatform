import java.util.*;

public class Cart {
    private Customer customer;
    private List<CartItem> cartItemList;

    public Cart(Customer customer) {
        this.customer = customer;
        this.cartItemList = new ArrayList<>();
    }

    public void printCartTotal() {//장바구니 출력 및 금액 계산
        int total = 0;

        System.out.println("[ 장바구니 내역 ]");
        for (int i = 0; i < cartItemList.size(); i++) {
            Product product = cartItemList.get(i).getProduct();
            System.out.println(product.getProductName() + " | " + product.getPrice() + "원 | " + product.getDescription() + " | 수량 : " + cartItemList.get(i).getQuantity() + "개");
            total += product.getPrice() * cartItemList.get(i).getQuantity();
        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.println(total + "원");
    }

    public void clearCart() {
        cartItemList.clear();
    }

    public void addProduct(Product product) {//장바구니 담기
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().getProductName().equals(product.getProductName())) {
                //cartItemList에 들어있는 아이템을 순회하면서 앞서 존재 했으면 추가
                cartItem.addQuantity(1); // 기존 아이템 수량 +1
                return;
            }
        }
        CartItem newItem = new CartItem(product, 1);
        cartItemList.add(newItem);//리스트에 존재하지 않는 경우 객체를 생성하고 수량 1로 수정
    }

    public List<CartItem> getProducts() {
        return cartItemList;
    }

    public boolean isEmpty() {
        if (cartItemList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void removeProductInCart(Scanner sc) {
        if(cartItemList.isEmpty()){
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        System.out.print("제거할 상품을 입력하세요 : ");
        String productName = sc.nextLine();
        removeProduct(productName);
    }

    public void removeProduct(String product) {
        if (cartItemList.isEmpty()) {
            return;
        }
        this.cartItemList.removeIf(cartItem -> cartItem.getProduct().getProductName().equals(product));
    }
}
