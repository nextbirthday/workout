package quiz.blank;

import java.util.Scanner;

public class BaseballGameLogic {
    // 배열의 최대크기로 사용할 상수(constant)
    private static final int MAX = 3;
    // 스트라이크 개수로 사용할 변수
    private int strikeCount = 0;
    // 볼 개수로 사용할 변수
    private int ballCount = 0;
    // 재시도 횟수로 사용할 변수
    private int tryCount = 0;
    // 사용자로부터 입력을 받을 스캐너
    // 정수 입력과, 재도전 여부를 받는다
    // 프로그램이 종료되기 전에 close 해줄 것
    Scanner scan = null;
    
    private int[] getRandomNumber() {
        /*
         * TODO 랜덤한 한 자리 양의 정수를 3번 반복 생성, 세 자리 수를 만든다.
         * 순서대로 정수형 배열에 넣어 리턴하는 메서드를 작성한다.
         * 백의 자리가 0이 되거나, 각 자릿수는 겹치는 숫자일 수 없다.
         */
        return null;
    }
    
    private int[] getUserNumber() {
        /*
         * TODO 사용자로부터 세 자리 양의 정수를 입력받아
         * 한자리씩 정수형 배열에 넣어 리턴하는 메서드를 작성한다.
         * 또한, 한 자리씩 세 번 입력 받는 것이 아니라
         * 세 자리 정수를 한 번 입력하면 나누어 저장하도록 한다.
         */
        return null;
    }
    
    private void compare( int[] randomNumber, int[] userNumber ) {
        /*
         * TODO 랜덤으로 생성한 배열, 사용자가 입력한 숫자를 담은 배열을
         * 파라미터(매개변수)로 받아 비교하여 카운트를 하는 메서드를 작성한다.
         * (Hint : 전역변수 Count 들 활용)
         * 별도로 내용을 출력해줄 필요는 없다.
         */
    }
    
    public void playGame() {
        /*
         * TODO 위에서 작성한 3개 메서드를 활용하여
         * 사용자가 종료하기 전까지 게임을 반복실행하는 메서드를 작성한다.
         * (단, 3 STRIKE 로 게임을 이겼을 때에만 종료 여부를 묻는다.)
         */
    }
}
