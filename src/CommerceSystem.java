import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories;

    public CommerceSystem(List<Category> categories){
        this.categories = categories;
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for(int i=0; i<categories.size(); i++){
                System.out.println(i+1+". "+categories.get(i).getCategoryName());
            }
            System.out.println("0. 종료");
            System.out.print("번호를 선택하세요 : ");
            int userChoice = sc.nextInt();
            if(userChoice == 0){
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
            showCategoryProducts(categories.get(userChoice-1),sc);
        }

    }
    public void showCategoryProducts(Category category, Scanner sc){
        System.out.println("[ "+category.getCategoryName()+" 카테고리 ]");
        for(int i=0; i<category.getProducts().size(); i++){
            Product product = category.getProducts().get(i);
            System.out.println(i+1+". "+product.getProductName()+" | "+product.getPrice()+"원 | "+product.getDescription());
        }
        System.out.println("0. 뒤로가기");
        System.out.print("번호를 선택하세요 : ");
        int userChoice = sc.nextInt();
        if (userChoice == 0){
        }
        else{
            Product product = category.getProducts().get(userChoice);
            System.out.println("선택한 상품 : "+product.getProductName()+" | "+product.getProductName()+"원 | "+product.getDescription()+" | 재고 : "+product.getProductLeft()+"개");
        }

    }
}
