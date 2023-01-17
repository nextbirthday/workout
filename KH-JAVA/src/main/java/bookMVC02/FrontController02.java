package bookMVC02;

public class FrontController02 {
    
    public static Object getController( String gubun ) {
        
        Object object = null;
        
        if ( "bookMgr".equals( gubun ) ) {
            object = new BookController02();
        }
        else if ( "boardMgr".equals( gubun ) ) {
            object = new BoardController02();
        }
        
        return object;
    }
}
