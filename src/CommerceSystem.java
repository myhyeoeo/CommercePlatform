import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories;
    private Customer customer;
    // 속성 : Category를 다루는 리스트

    public CommerceSystem(List<Category> categories,Customer customer){
        this.categories = categories;
        this.customer = customer;
    }
    // 생성자 : Category 리스트를 받아와서 객체 생성

    public void start(){
        Scanner sc = new Scanner(System.in);
        while (true){
            // 출력문 출력
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
                // 0을 입력한 경우 종료
            }
            showCategoryProducts(categories.get(userChoice-1),sc);
            // 선택된 카테고리의 물품을 출력
        }

    }
    public void showCategoryProducts(Category category, Scanner sc){
        // 카테고리와 스캐너를 받아온다. 스캐너를 받음으로써 객체를 더 생성하지 않고 자원 낭비 X

        while(true){
            System.out.println("[ "+category.getCategoryName()+" 카테고리 ]");
            for(int i=0; i<category.getProducts().size(); i++){
                Product product = category.getProducts().get(i);
                System.out.println(i+1+". "+product.getProductName()+" | "+product.getPrice()+"원 | "+product.getDescription());
            }
            System.out.println("0. 뒤로가기");
            // 선택한 카테고리의 물품 출력
            System.out.print("번호를 선택하세요 : ");
            int userChoice = sc.nextInt();
            if (userChoice == 0){
                System.out.println("플랫폼 메인으로 돌아갑니다");
                break;
            }
            else{
                Product product = category.getProducts().get(userChoice-1);
                System.out.println("선택한 상품 : "+product.getProductName()+" | "+product.getPrice()+"원 | "+product.getDescription()+" | 재고 : "+product.getProductLeft()+"개");
            }
        }
        // 입력받은 번호에 해당하는 물품의 상세정보를 출

    }
}
