package array;

public class StudentScore {
    private String studentName;
    private double javaScore;
    private double dbScore;
    private double linuxScore;
    
    public StudentScore() {}
    
    public StudentScore( String studentName, double javaScore, double dbScore, double linuxScore ) {
        this.studentName = studentName;
        this.javaScore = javaScore;
        this.dbScore = dbScore;
        this.linuxScore = linuxScore;
    }
    
    public String getStudentName() { return studentName; }
    
    public void setStudentName( String studentName ) { 
        this.studentName = studentName; }
    
    public double getJavaScore() { return javaScore; }
    
    public void setJavaScore( double javaScore ) { this.javaScore = javaScore; }
    
    public double getDbScore() { return dbScore; }
    
    public void setDbScore( double dbScore ) { this.dbScore = dbScore; }
    
    public double getLinuxScore() { return linuxScore; }
    
    public void setLinuxScore( double linuxScore ) { this.linuxScore = linuxScore; }
}
