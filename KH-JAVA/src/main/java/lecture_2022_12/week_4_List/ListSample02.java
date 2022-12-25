package lecture_2022_12.week_4_List;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListSample02 {
    public static void main( String[] args ) {
        // 자료구조를 지원하는 클래스들은 오브젝트의 존재유무 체크
        // Contains 여부, empty여부를 확인할 수 있는 API를 제공하고있다.
        List<String> fruit = new Vector<>();
        fruit.add( "사과" );
        fruit.add( "토마토" );
        boolean isExist = fruit.contains( "바나나" );
        isExist = fruit.contains( "사과" );
        
        if ( isExist ) {
            System.out.println( "入" );
        }
        else {
            System.out.println( "들어있지 않습니다." );
        }
        System.out.println( fruit.isEmpty() );
        // Vector, ArrayList는 오브젝트 추가, 꺼내는 기능 제공
        
        // Iterator는 그 안에 오브젝트 존재유무
        Iterator<String> iter = fruit.iterator();
        
        while ( iter.hasNext() ) {
            String fName = iter.next();
            System.out.println( fName );
        }
        
        Iterator iter2 = fruit.iterator();
        
        // angle bracket에 type을 명시적으로 작성해야한다.
        while ( iter.hasNext() ) {
            String fName = ( String ) iter2.next(); // Generic type을 지정하지 않아서 error
            System.out.println( fName );
        }
        
        // Vector의 Generic type이 String
        // Iterator<Object> iter3 = fruit.iterator(); - error
        Iterator<String> iter4 = fruit.iterator();
    }
}
