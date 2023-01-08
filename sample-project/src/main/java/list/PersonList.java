package list;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    
    public static void main( String[] args ) {
        // 데이터셋을 다룰 때 List<객체> 형태의 구조를 아주 많이 사용한다.
        // List는 엑셀에서 열이라고 보면 되고, <> 안에 들어가는 객체는 행이라고 보면 된다.
        // 값을 담는 객체라서 보통 VO(Value Object)라고 부름
        // key : value 쌍으로 이루어진 Map이 들어가기도 한다. List<Map<String, String>> 이런 식으로
        List<Person> personList = new ArrayList<Person>();
        
        // kim 이라는 사람의 정보를 담을 수 있는 클래스 Person을 새로 만들고, 신상정보 입력
        Person kim = new Person();
        kim.setName( "KIM" );
        kim.setAge( 23 );
        kim.setSex( 0 );
        kim.setHeight( 180 );
        kim.setWeight( 70 );
        
        // park 이라는 사람의 정보를 담을 수 있는 클래스 Person을 새로 만들고, 신상정보 입력
        Person park = new Person();
        park.setName( "PARK" );
        park.setAge( 25 );
        park.setSex( 1 );
        park.setHeight( 165 );
        park.setWeight( 54 );
        
        // 리스트에 객체를 추가한다.
        personList.add( kim );
        personList.add( park );
        
        // for 루프로 출력해본다.
        for ( int i = 0; i < personList.size(); i++ ) {
            System.out.println( personList.get( i ).toString() );
        }
        
        // for-each문 (향상된 for문이라고도 함)
        for ( Person person : personList ) {
            System.out.println( person.toString() );
        }
        
        // 이터러블 클래스에서 제공하는 람다식 형태의 for문
        personList.forEach( p -> System.out.println( p.toString() ) );
    }
}
