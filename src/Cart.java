import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Customer customer;
    private List<CartItem> cartItemList;

    public Cart(Customer customer){
        this.customer = customer;
        this.cartItemList = new ArrayList<>();
    }
    public void printCartTotal(){//장바구니 출력 및 금액 계산
        int total = 0;

        System.out.println("[ 장바구니 내역 ]");
        for(int i=0; i<cartItemList.size(); i++){
            Product product = cartItemList.get(i).getProduct();
            System.out.println(product.getProductName()+" | "+product.getPrice()+"원 | "+product.getDescription()+" | 수량 : "+cartItemList.get(i).getQuantity()+"개");
            total += product.getPrice();
        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.println(total+"원");
    }

    public void addProduct(Product product){//장바구니 담기
        for(CartItem cartItem : cartItemList){
            if (cartItem.getProduct().getProductName().equals(product.getProductName())) {
                //cartItemList에 들어있는 아이템을 순회하면서 앞서 존재 했으면 추가
                cartItem.addQuantity(1); // 기존 아이템 수량 +1
                return;
            }
        }
        CartItem newItem = new CartItem(product,1);
        cartItemList.add(newItem);//리스트에 존재하지 않는 경우 객체를 생성하고 수량 1로 수정
    }
    public List<CartItem> getProducts(){
        return cartItemList;
    }
    public boolean isEmpty(){
        if(cartItemList.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
