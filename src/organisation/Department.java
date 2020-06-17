package organisation;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.*; 

public class Department {
	private String title;
	private Employee[] employees; // класс хранит явным образом массив своих работников.
//	final String ORIGINAL_DEPARTMENT_NAME = "Roga i kopita";
	
	//	Конструкторы
	// конструктор может принимать имя подразделения (в этом случае количество работников = 0);
    public Department(String departmentTitle) {
    	title = departmentTitle;
    	employees = new Employee[0];
    }
    
    // конструктор может принимать массив работников
    public Department(Employee[] employees) {
    	this.employees = employees;
    }
    

    
    // Методы
	// создайте метод получения имени подразделения
	public String getTitle() {
		return title;
	}
	
	// создайте метод изменения имени подразделения
	public void setTitle(String title) {
		this.title = title;
	}
	
	// создайте метод, возвращающий общее число работников подразделения
	public Integer getEmployeeCount() {
		return employees.length;
	}

	// создайте метод, возвращающий суммарную зарплату всех работников, относящихся к данному подразделению
	public Integer getTotalSalary() {
		Integer totalSalary = 0;
		for (int i = 0; i < employees.length; ++i)
			totalSalary += employees[i].getSalary();
		return totalSalary;
	}
	
	
	// создайте метод, возвращающий ссылку на работника по фамилии и имени
	// возвращает null, если работник с таким именем и фамилией не найден
	// возвращает ссылку на первого найденного работника с указанным именем и фамилией
	public Employee findEmployee(String firstName, String lastName) {
		for (int i = 0; i < employees.length; ++i) {
			if ( employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName) ) {
				return employees[i];
			}
		}
		return null;
	}
	
	// создайте метод увольнения работника (принимает в качестве входных параметров фамилию, имя, должность работника, 
	// которого нужно удалить, удаляет соответствующий этим данным элемент из массива работников);
	// возвращает true, если работник найден и успешно удален, false если не найден
	public Boolean fireEmployee(String firstName, String lastName, String jobTitle) {
		Employee[] updatedEmployees = new Employee[employees.length - 1];
		for (int i = 0; i < employees.length; ++i) {
			if ( employees[i].getFirstName().equals(firstName) &&
				 employees[i].getLastName().equals(lastName) && 
				 employees[i].getJobTitle().equals(jobTitle) ) {
	                System.arraycopy(employees, 0, updatedEmployees, 0, i);
	                System.arraycopy(employees, i + 1, updatedEmployees, i, (employees.length - (i+1)));
					employees = updatedEmployees;
					return true;
			}
		}
		return false;
	}
	
    // создадим приватный метод для обновления массива сотрудников
    private void setEmployees(Employee[] employees) {
    	this.employees = employees;
    }

    // создайте метод, возвращающий массив работников отдела; 
    public Employee[] getEmployees() {
    	return employees;
    }
    
	/* создайте метод приема работника на работу (принимает в качестве входных параметров 
	 * ссылку на экземпляр класса Employee, расширяет массив работников путем добавления нового элемента в конец массива);
	 */
	public void hireNewEmployee(Employee employee) {
		// создадим новый массив, который будет иметь длину на 1 элемент больше, чем исходный
		// затем скопируем в него исходный массив, а затем в крайнюю последнюю позицию запишем нового сотрудника...
		Employee[] updatedEmployees = new Employee[employees.length + 1];
		System.arraycopy(employees, 0, updatedEmployees, 0, employees.length);
		updatedEmployees[employees.length] = employee;
		setEmployees(updatedEmployees);
	}
	
	// создадим класс сравнения SortByLastNameFirstName, реализующий интерфейс Comparator для сортировки экземпляров класса Emoloyee
	class SortByLastNameFirstName implements Comparator<Employee> 
	{ 
	    // реализация compare-функции для сортитровки по возрастанию по комбинации Фамилия+Имя
		// поскольку нам нужно для совпадающих фамилий сортировать с учетом имени, то мы сделаем сортировку не просто по фамилии,
		// а по строке Фамилия.concat(Имя)
	    public int compare(Employee e1, Employee e2) 
	    { 
            final String field1 = e1.getLastName().concat(e1.getFirstName());
            final String field2 = e2.getLastName().concat(e2.getFirstName());
            return field1.compareTo(field2);
	    } 
	} 
	
	/*создайте метод, возвращающий массив работников отдела, отсортированный по фамилиям 
	 * (и если одинаковые фамилии – то по именам)..
	 */
	public Employee[] getEmployeesSortedByLastName() {
		Employee [] sortedEmployees = new Employee[employees.length];
		System.arraycopy(employees, 0, sortedEmployees, 0, employees.length);
		Arrays.sort(sortedEmployees, new SortByLastNameFirstName());
			
		return sortedEmployees;
	}
}
