import java.io.Serializable;

public class Employee implements Serializable{
    /*
     * Serializable is a marker interface which means it doesn't have any data members or methods.
     * Hence it is used to just mark the java classes so that objects of these classes may get certain capabilities.
     * Examples of other marker classes are - Cloneable and Remote
     */
    String name;
    int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
