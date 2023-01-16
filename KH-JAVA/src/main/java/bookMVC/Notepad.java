package bookMVC;

public class Notepad {
    // JAVA -> JFrame -> 브라우저에서 동작안함 - native app
    // 웹 프로그래밍 (html, css, js - 정적페이지 처리)
    // 동적페이지 처리 - JAVA -> HTTP 프로토콜을 지원하는 API가 없다.
    // -> Server 돌아가는 JAVA가 필요하다. -> Applet
    // -> 서버에서 돌아가는 애플릿 -> Servlet 서블릿 (http 프로토콜, Restful API)
    // 단점 : out.print("<html><head><body></body></html>") -> JSP (Java Server Page): 서버에서 돌아가는 자바
    // Spring F/W, Struts 1,2 + 전자정부프레임워크
    // MVC 패턴 주입 받음 -> 순수한 자바로 이루어진 MVC 소개
    
    // 프레임워크를 왜 원하는가? 실력차이를 줄여야한다.
    // 와꾸가 정해진다. - 클래스 선언, 메서드 선언(단, 파라미터 타입과 개수는 내가 결정)
    // 개발자는 비즈니스 로직에만 집중
    // 개발 방법론에서 디자인 패턴 중 MVC 패턴을 알아보자
    
    // Model
    
    // View
    
    // Controller
    
    // Model 모델 계층 (XXXLogic.java + XXXXDAO.java + etc...) => 서비스 계층, 비즈니스로직(업무)계층
    // XXXDAO가 있고 없고는 MVC 패턴에 영향이 없다.
    // 다만 오라클 서버와 연계에 반복되는 코드를 줄여주고 오픈소스나 라이브러리(iBatis, MyBatis(반자동), Hibernate)를 조립하기 위한 요구사항으로 만들어 사용하는 클래스이다.
    // 클래스쪼개기(생성자) -> POJO(pure) -> Spring(Maven) -> Spring boot(Gradle)
    
    // Controller 컨트롤 계층
    
    // View 뷰 계층
    // BookManager.java에 main method가 있다. 
    // 조회, 수정, 삭제, 입력 -> BookController 
    // 버튼이 클릭되었을 때 BookController를 주입 받을건지 아니면 BoardController를 주입 받을지 결정
    // 사용자가 의사결정을 한다.
    // 사용자가 선택한 정보를 넘기는 방법은 뭐지? -파라미터
    // String gubum = "bookMgr" or "boardMgr"
}
