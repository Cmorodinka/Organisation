package organisation;

public class Employee {
    private String jobTitle;
    private Integer salary;
    private String firstName;
    private String lastName;
    
    // Конструкторы
    
    // конструктор может принимать имя, фамилию, должность, жалование.
      public Employee(String firstName, String lastName, String job, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = job;
        this.salary = salary;
      }
           		
    //  конструктор может принимать имя и фамилию (должность – инженер, жалование – 30к руб.);
        Employee() {
            jobTitle = "инженер";
            salary = 300000;
        } 
        
    // Методы
      // создайте метод получения должности; .
      public String getJobTitle() {
        return jobTitle;
      }
      
      // создайте метод изменения должности; 
      public void setJobTitle(String arg) {
        jobTitle = arg;
      }

      // создайте метод получения жалования; 
      public Integer getSalary() {
        return salary;
      }
      
      // создайте метод изменения жалования;
      public void setSalary(Integer arg) {
        salary = arg;
      }
      
      // создайте метод получения имени;
      public String getFirstName() {
        return firstName;
      }
      
      // создайте метод изменения имени; 
      public void setFirstName(String arg) {
        firstName = arg;
      }
      
      // создайте метод получения фамилии;
      public String getLastName() {
        return lastName;
      }
      
      // создайте метод изменения фамилии;
      public void setLastName(String arg) {
        lastName = arg;
      }
     
}

