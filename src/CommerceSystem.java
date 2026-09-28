import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories;
    public void start(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for(int i=0; i<categories.size(); i++){
            System.out.println(i+1+". "+categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
        int userChoice = sc.nextInt();
        if(userChoice == 0){
            System.out.println("커머스 플랫폼을 종료합니다.");
        }

    }
}
