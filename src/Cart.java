import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Customer customer;
    private List<Product> productList;

    public Cart(Customer customer){
        this.customer = customer;
        this.productList = new ArrayList<>();
    }
    public void printCartTotal(){//장바구니 출력 및 금액 계산
        int total = 0;
        int count = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();

        System.out.println("[ 장바구니 내역 ]");
        for(int i=0; i<productList.size(); i++){
            Product product = productList.get(i);
            System.out.println(product.getProductName()+" | "+product.getPrice()+"원 | "+product.getDescription()+" | 수량 : "+product.getProductLeft()+"개");
            total += product.getPrice();
            hashMap.computeIfPresent(product.getProductName(),count);

        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.println(total+"원");
    }

    public void addProduct(Product product){//장바구니 담기
        productList.add(product);
        cartItem
    }
    public List<Product> getProducts(){
        return productList;
    }
    public boolean isEmpty(){
        if(productList.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
