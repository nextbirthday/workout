package b3_1205;

// 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고 a1에서 a10번 째 항까지 출력되도록 만들어보세요.
//앞의 두 수를 더하면 다음 항이 나오게된다.
// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
// save
public class FibonacciSequence {
    
    void fibonacciSequence() {
        int prevPrevNum = 1; // 전 전 항 (n-2)
        int prevNum     = 1; // 이전 항 (n-1)
        
        System.out.print( prevPrevNum + ","+prevNum +","  ); // 1
     
        
        for ( int i = 0; i < 8; i++ ) {
            int curNum = prevPrevNum + prevNum; // 현재 항 (n) 2 = 1+1 
            System.out.print( curNum + " " ); //2
            
            prevPrevNum = prevNum; //1 = 1
            prevNum = curNum; //2 = 2
        }              
    }    
    public static void main( String[] args ) {
        FibonacciSequence fs = new FibonacciSequence();
        fs.fibonacciSequence();
    }
}
