package bookMVC;

public class FrontController {
    
    public static Object getController( String gubun ) {
        
        Object object = null;
        
        if ( "bookMgr".equals( gubun ) ) {
            object = new BookController();
        }
        else if ( "boardMgr".equals( gubun ) ) {
            object = new BoardController();
        }
        
        return object;
    }
}
