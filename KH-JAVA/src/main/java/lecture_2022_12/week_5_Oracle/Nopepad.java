package lecture_2022_12.week_5_Oracle;

public class Nopepad {
    /*
     * JDBC API를 이용하여 DB연동하기
     * 1. 각 제조사가 제공하는 드라이버 클래스를 로딩한다.
     * 
     * Class.forName(Driver클래스적음 - fullName);
     * 
     * 2. 물리적으로 떨어져 있는 오라클 서버와 연결 통로를 확보한다.
     * Connection은 인터페이스이다. - 오른쪽에 구현체 클래스가 와야한다.
     * 
     * Connection con = DriverManager.getConnection(URL, user, pw);   ex) (url, "onion", "ring");
     * 
     * 3. DML(Data Manipulation Language)문을 자바에서 오라클 서버로 전달해 줄 인터페이스를 생성한다.
     * (Statement: 정적 쿼리문, PreparedStatement: 동적 쿼리문 지원)
     * 4.SELECT문의 경우 오라클 서버에서 제공하는 커서를 지원하는 ResultSest 인터페이스를 활용하여
     * 테이블에 제공되는 커서를 조작하여 해당 row에 데이터가 존재하면 Cursor...open...fetch 과정을 통해서
     * 오라클 서버로부터 데이터를 꺼내서 List<DeptVO>에 담을 수 있다.
     * Caution: INSERT, UPDATE, DELETE 에서는 커서가 필요없다. - commit, rollback
     * return값은 integer이다.
     * 이것들을 요청할 때는 executeUpdate(INSERT문 or UPDATE or DELETE문)
     * SELECT일 때는
     * ResultSet rs = executeQuery("SELECT*FROM dept");
     * 오라클에서 제공되는 커서를 조작하는 인터페이스를 리턴 타입으로 제공박아서
     * 조회 결과를 Collection에 담을 수 있다.
     * 
     * List<DeptVO> deptList = new ArrayList<>();
     * DeptVO dVO = null;
     * 
     * while(rs.next()){
     * dVO = new DeptVO();
     * 
     * deptList.add(dVO);
     * }
     * 
     * 사용한 자원을 반납할 때는 사용한 역순으로 닫아주면 된다.
     * 
     * SELECT의 경우
     * ResultSet먼저 닫고
     * Statement 혹은 PreparedStatement 두 번째로 닫고
     * Connection을 맨 나중에 닫아주면 된다.
     * 닫지 않으면 자동으로 언젠가 닫아주기는 하지만 명시적으로 닫아주면
     * 닫는 시간을 앞당길 수 있어 프로젝트에서는 명시적으로 닫는 코드 작성을 가이드로 정한다.
     * 
     * INSERT, UPDATE, DELETE는 두 번째와 세 번째만 닫으면 된다.
     * 왜냐하면 리턴타입 커서가 필요가 없다.
     */
}
