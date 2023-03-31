import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerailzationAndDeseralization {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee();
        emp.setName("John");
        emp.setAge(30);


        /* 
        * Below is simple example showing a new Object is a shallow copy of an existing object, which means only one object 
        * in heap memory and two references are created in the stack memory i.e. Changing one object will affects the other.
        * 
        * Employee newEmployee = emp; // Shallow copying of an object
        * System.out.println("Old Employee Age : "+ emp.getAge());
        * System.out.println("New Employee Age : "+ newEmployee.getAge());
        *
        * emp.setAge(35);
        * System.out.println("Old Employee Age : "+ emp.getAge());
        * System.out.println("New Employee Age : "+ newEmployee.getAge());
        */

        /*
         * Seralization is the process of converting the state of an object into a byte stream.
         * Deseralization is the reverse process of seralization where byte stream is used to recreate the actual 
         * java object in memory.
         * 
         * Byte stream is platform independent. Hence an object seralized on one platform can be desearlized in another.
         */
        File file = new File("seralize.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // seralizing an object
            oos.writeObject(emp);

            oos.close();
            fos.close();
        } catch(IOException e) {
            System.out.println("IOException is caught");
        }

        Employee newEmployee = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // deseralizing an object
            newEmployee = (Employee) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Name : "+newEmployee.getName() + " and Age : " + newEmployee.getAge());

            emp.setAge(40);
            System.out.println("Old Employee Age : "+ emp.getAge());
            System.out.println("New Employee Age : "+ newEmployee.getAge());

            newEmployee.setAge(25);
            System.out.println("Old Employee Age : "+ emp.getAge());
            System.out.println("New Employee Age : "+ newEmployee.getAge());
        } catch(IOException e) {
            System.out.println("IOException is caught");
        }

        /*
         * Advantages of Seralization are 
         * 1. To save/persist the state of an object
         * 2. To travel an object across network
         */

         /*
          * Points to remeber
          1. If a parent class has implemented seralizable interface then child class doesn't need to implement it but 
          vice-versa is not true.
          2. Only non-static data members can be seralized. So if you don't want to save the value of some members, make them
          static or transient.
          3. Constructor of object is never called when an object id deseralized.
          4. Assocaited objects must implement seralizable interface.

          */
    }
}
