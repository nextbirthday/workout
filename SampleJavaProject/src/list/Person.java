package list;

public class Person {
    private String name;
    private int    age;
    private int    sex;
    private double height;
    private double weight;
    
    public String getName() { return name; }
    
    public void setName( String name ) { this.name = name; }
    
    public int getAge() { return age; }
    
    public void setAge( int age ) { this.age = age; }
    
    public int getSex() { return sex; }
    
    public void setSex( int sex ) { this.sex = sex; }
    
    public double getHeight() { return height; }
    
    public void setHeight( double height ) { this.height = height; }
    
    public double getWeight() { return weight; }
    
    public void setWeight( double weight ) { this.weight = weight; }
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", height=" + height + ", weight=" + weight + "]";
    }
}
