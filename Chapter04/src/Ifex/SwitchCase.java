package Ifex;

public class SwitchCase {
    
    public static void main( String[] args ) {
        int rank = 194;
        char medalcolour;
        
        switch(rank) {
            case 1: medalcolour = 'G';
                    break;
            case 2: medalcolour = 'S';       
                    break;     
            case 3: medalcolour = 'B';
                    break;
            default: medalcolour = 'A';
        }
           System.out.println( rank +"등 메달의 색깔은"+ medalcolour +"입니다." );    
    }
    
}
