package organisation;
import java.util.Date;

//Класс Employee сделайте абстрактным. Добавьте следующие элементы:
//Поле: дата приема на работу (экземпляр класса Date).
 
public abstract class Employee {
    private JobTitles jobTitle; // приватное поле, содержащее должность сотрудника, должно быть экземпляром перечисления JobTitles
    private Integer salary;
    private String firstName;
    private String lastName;
    private Date hiredDate; // дата приема на работу (экземпляр класса Date)
  

//    // Конструкторы
//    
// конструктор может принимать имя, фамилию, должность, жалование, дату приема
// измените конструкторы и методы, работающие с названием должности, в соответствии с тем, что поле теперь имеет тип перечисления.
      public Employee(String firstName, String lastName, JobTitles jobTitle, Integer salary, Date hiredDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.hiredDate = hiredDate;
      }
      
      //  конструктор может принимать имя и фамилию (должность – инженер, жалование – 30к руб.);
      // измените конструкторы и методы, работающие с названием должности, в соответствии с тем, что поле теперь имеет тип перечисления.
      Employee() {
          setJobTitle(JobTitles.ENGINEER);
          setSalary(300000);
      }

//     Методы
      // создайте метод получения должности;
      // измените конструкторы и методы, работающие с названием должности, в соответствии с тем, что поле теперь имеет тип перечисления.
      public JobTitles getJobTitle() {
        return jobTitle;
      }
      
      // создайте метод изменения должности;
      // измените конструкторы и методы, работающие с названием должности, в соответствии с тем, что поле теперь имеет тип перечисления.
      public void setJobTitle(JobTitles jobTitle) {
        this.jobTitle = jobTitle;
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

    // геттер и сеттер даты приема
    // геттер даты приема
	public Date getHiredDate() {
		return hiredDate;
	}

	// сеттер даты приема
	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	// абстрактный public метод, возвращающий ежемесячную премию
	abstract public float monthlyBonus();
}    


