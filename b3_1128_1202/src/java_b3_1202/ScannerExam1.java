package java_b3_1202;

import java.util.Scanner; // java.lang패키지 外 클래스들은 모두 import문을 추가해야함 -하지 않으면 컴파일 에러 -class 생성안됨import jdk.nashorn.internal.runtime.UserAccessorProperty;

// 클래스의 구성요소 2가지
// field + method => 클래스 정의
// 클래스를 인스턴스화 하면 메모리에 로딩이 된다.
// 클래스를 인스턴스화 하는 이유는 변수와 메서드를 호출하기 위해서
// 인스턴스화.메서드명(); 인스턴스화.메서드명(int i, double d);
// 인스턴스화.전역변수(원시형+참조형 모두);
// 상속관계 상속받을 때 가장 가까운 것을 상속받는게 좋다.

public class ScannerExam1 {
    
    public static void main( String[] args ) {
        // 생성자이든 메서드이든 파라미터의 개수 혹은 타입은 반드시 지켜야 한다.
        Scanner scanner = new Scanner( System.in ); // 생성부의 파라미터 자리는 시스템의 입력장치정보
        System.out.println( "문자열을 입력해주세요." );
      
        String user = scanner.nextLine();
        /*System.out.println( "정수 입력 :" );
        int sub = scanner.nextInt();
        System.out.println( "입력하신 정수는 " + sub + "입니다." );*/
        
    }
    
}
