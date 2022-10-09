package com.uneducated;

/**
 * @author geundu
 * 
 *         main 메서드 파라미터로 들어오는 args도 스트링타입 어레이.
 *         프로그램이 실행될 때 받는 옵션, 인자라고 보면 된다
 *         
 *         Run configurations... 의 Arguments → Program arguments 에서 추가, 테스트 가능
 */
public class ArgsTest {
    
    public static void main( String[] args ) {
        
        if ( args != null && args.length > 0 ) {
            
            for ( int i = 0; i < args.length; i++ ) {
                System.out.println( args[i] );
            }
        }
        else
            System.out.println( "args is empty" );
    }
}
