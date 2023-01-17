package bookMVC;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BookDAO {
    
    
    /**
     * 도서정보를 조회하는 메서드, 조인이 필수적인 경우에는 반드시 List<Map>형태가 유리하고,
     * 그렇지 않은 경우라면 List<xxxVO>형태와 큰 차이가 없다.
     * 단, 조회 결과로 얻은 정보를 JAVA에서 연산을 해야하는 경우라면 generic type으로 Map보다는 xxxVO가 유리하다.
     * Map이면 return 값이 무조건 Object이다. (Warning : ClassCastingException)
     * <p>
     * SELECT bk_no, bk_title FROM SCOTT.BOOK
     * WHERE bk_title = ?
     * WHERE bk_author = ?
     * WHERE bk_info = ?
     * 
     * @param cols    - COLUMN NAME bk_title or bk_author or bk_info
     * @param keyword - 사용자가 텍스트필드에 입력한 값
     *                <p>
     * @return 조회된 도서정보 record List<Map<String,Object>>
     * @author - HOJAE
     */
    public List<Map<String, Object>> getBookList( String cols, String keyword ) {
        System.out.println( "BookDAO getBookList call" );
        
        List<Map<String, Object>> bookList = null;
        Map<String, Object>       bookMap  = null;
        return bookList;
    }
    
    /**
     * 도서정보를 입력하는 메서드 - CREATE
     * <p>
     * lombok 어노테이션 @data를 사용했기 때문에 getter/setter 메서드는 없지만 사용가능하다.
     * 단 VO타입이므로 전역변수에 담긴 값을 출력하려면 getter 메서드를 호출한다.
     * 전역변수를 캡슐화하여 직접 접근이 불가능하고 위,변조를 방지하기 위해 접근제한자는 반드시 private로 선언한다.
     * 
     * @param bookVO - 도서정보 입력을 요청 받은 값
     *               <p>
     * @return 도서정보 입력에 성공했으면 1, 실패시 0
     *         <p>
     * @author - HOJAE
     */
    public int bookInsert( BookVO bookVO ) {
        int result = 0;
        System.out.println( "bookInsert call ===> " + bookVO );
        
        return result;
    }
    
    /**
     * 도서정보를 수정하는 메서드 - UPDATE
     * <p>
     * 
     * @param bk_no - 도서번호
     *              <p>
     * @return 도서정보 수정에 성공했으면 1, 실패시 0
     *         <p>
     * @author - HOJAE
     */
    public int bookUpdate( BookVO bookVO ) {
        int result = 0;
        
        System.out.println( "bookUpdate call ===> " + bookVO );
        return result;
    }
    
    /**
     * 도서정보를 삭제하는 메서드 - DELETE
     * <p>
     * 
     * @param bk_no - 도서번호
     *              <p>
     * @return 도서정보 삭제에 성공했으면 1, 실패시 0
     *         <p>
     * @author - HOJAE
     */
    public int bookDelete( int bk_no ) {
        int result = 0;
        System.out.println( "bookDelete call ===> " + bk_no );
        System.out.println( bk_no );
        return result;
    }
}
