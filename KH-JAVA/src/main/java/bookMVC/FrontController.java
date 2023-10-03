package bookMVC;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FrontController {
    
    public static Object getController( String gubun ) {
        
        Object object = null;
        
        if ( "bookMgr".equals( gubun ) ) {
            object = new BookController();
            log.info("new BookController Objcet 생성");
        }
        else if ( "boardMgr".equals( gubun ) ) {
            object = new BoardController();
            log.info("new BoardController Objcet 생성");
        }
        
        return object;
    }
}
