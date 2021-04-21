import java.io.Serializable;

public class Student implements Serializable
{
    public int id;
    public String name;
    public String course;
    public Student(int id,String name,String course)
     {
      this.id=id;
      this.name=name;
      this.course=course;
     }
    public void showDetails()
     {
      System.out.println("Id:"+id);
      System.out.println("Name:"+name);
      System.out.println("Course:"+course);
     }  
    
}