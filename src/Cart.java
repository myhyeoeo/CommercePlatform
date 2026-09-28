import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Customer customer;
    private List<Product> productList;

    public Cart(Customer customer){
        this.customer = customer;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
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
