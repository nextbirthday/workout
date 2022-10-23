package grade;

public class Subject {
    
    Subject() {}
    
    Subject( String subjectName, int score ) {
        this.subjectName = subjectName;
        this.score = score;
    }
    
    private String subjectName;
    private int    score;
    
    public String getSubjectName() { return subjectName; }
    
    public void setSubjectName( String subjectName ) { this.subjectName = subjectName; }
    
    public int getScore() { return score; }
    
    public void setScore( int score ) { this.score = score; }
    
    @Override
    public String toString() {
        return "Subject [subjectName=" + subjectName + ", score=" + score + "]";
    }
}
