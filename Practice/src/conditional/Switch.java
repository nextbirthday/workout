package conditional;

import java.util.Scanner;

public class Switch {
    public void testSwitch() {
        // switch문
        // 정수, 문자, 문자열 가능
        Scanner sc = new Scanner( System.in );
        System.out.println( "fruit name:" );
        
        String fruit = sc.nextLine();
        
        int price = 0;
        
        switch ( fruit ) {
            case "귤":
                price = 500;
                break;
            case "사과":
                price = 1000;
                break;
            case "바나나":
                price = 2000;
                break;
            default:
                System.out.println( "해당하는 과일이 없습니다." );
                break;
        }
        System.out.println( fruit + "의 가격은"+ price + "원입니다.");
        
    }
}
