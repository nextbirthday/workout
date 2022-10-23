package gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import record.Person;

/**
 * 구글에서 제공하는 json 파싱 라이브러리 <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.9">Gson</a>을 이용하여
 * <p>
 * Person 객체에 들어있는 필드를 <a href="https://www.json.org/json-ko.html">JSON</a>으로 변환, 다시 객체로 변환해본다.
 * <p>
 * (Gson 다운로드 및 JSON에 대한 자세한 설명은 위 링크 참조)
 * 
 * @author geundu
 *
 */
public class JsonParsing {
    
    public static void main( String[] args ) {
        
        // 구글에서 제공하는 JSON 파싱 라이브러리
        Gson gson = new Gson();
        
        // Person 객체에 들어있는 필드들을 JSON으로 변환해본다.
        Person kim = new Person();
        kim.setName( "KIM" );
        kim.setAge( 23 );
        kim.setSex( 0 );
        kim.setHeight( 180 );
        kim.setWeight( 70 );
        
        Person park = new Person();
        park.setName( "PARK" );
        park.setAge( 25 );
        park.setSex( 1 );
        park.setHeight( 165 );
        park.setWeight( 54 );
        
        // JSON으로 변환된 String을 담을 List
        List<String> jsonList = new ArrayList<>();
        jsonList.add( gson.toJson( kim ) );
        jsonList.add( gson.toJson( park ) );
        
        // JSON 형태의 String에서 변환된 Person 객체를 담을 List
        List<Person> objectList = new ArrayList<>();
        
        for ( String person : jsonList ) {
            // JSON 형태로 변환된 String 출력
            System.out.println( person );
            // JSON String을 Person 타입 객체로 변환하여 objectList에 저장
            objectList.add( gson.fromJson( person, Person.class ) );
        }
        
        // 다시 변환된 객체를 toString()으로 출력해본다
        objectList.forEach( p -> System.out.println( p.toString() ) );
    }
}
