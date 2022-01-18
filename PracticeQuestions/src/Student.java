/*Create an object called Student.
Student has Name, Age, ID
Create a student object with the name "Raju" who is 19 years old and has a student ID of 43123.
Call the object, it should list all the information of the Student.
*/

/**
 *
 * @author User
 */
public class Student {
    private String name;
    private int age;
    private int id;
    
    public Student(String name, int age, int id ){
        this.name=name;
        this.age=age;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString(){
    return "name: " + name + "\nage: " + age + "\nid: " + id;
    
}
    
}
