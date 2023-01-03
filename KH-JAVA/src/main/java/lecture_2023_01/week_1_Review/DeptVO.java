package lecture_2023_01.week_1_Review;

public class DeptVO {
    private int    deptno;
    private String dname;
    private String loc;
    
    public DeptVO() {}
    
    public DeptVO( int deptno, String dname, String loc ) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    
    public int getDeptno() { return this.deptno; }
    
    public void setDeptno( int deptno ) { this.deptno = deptno; }
    
    public String getDname() { return this.dname; }
    
    public void setDname( String dname ) { this.dname = dname; }
    
    public String getLoc() { return this.loc; }
    
    public void setLoc( String loc ) { this.loc = loc; }
}
