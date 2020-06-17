package organisation;

// Создайте отдельный класс для тестирования конструкторов и вызовов методов, созданных в соответствии с вариантом классов..
public class Main {
    public static void main(String[] args) {

    	final Employee[] FINANCIAL_DEPARTMENT_EMPLOYEES = {
    		new Employee("Tatiana","Petrova","Junior Accountant", 300),
    		new Employee("Marfa","Vasilyeva","Chief Accountant", 3000),
    	};
    	
    	Employee valik = new Employee("Valentyn","Cherevatiy","Junior Front-End Developer", 1000);
    	
    	Employee kolya = new Employee("Nickolay", "Girits", "Senior Back-End Developer", 2000);
//    	System.out.println(valik.getfirstName());
//    	System.out.println(betterValik.getfirstName());
    	
    	Department dep = new Department("Lonely department without employees");
    	System.out.printf("Department: %s, Employees count: %s%n", dep.getTitle(), dep.getEmployeeCount());
//    	System.out.println(dep.getEmployeeCount());

    	Employee[] employees = {valik, kolya};
    	Department itDepartment = new Department(employees);
    	itDepartment.setTitle("IT Department");
    	
    	// используем константу FINANCIAL_DEPARTMENT_EMPLOYEES, содержащую массив сотрудников Employee
    	// для создания финансового департамента financialDepartment
    	Department financialDepartment = new Department(FINANCIAL_DEPARTMENT_EMPLOYEES);
    	financialDepartment.setTitle("Financial Department");
    	
//    	System.out.println(itDepartment.getEmployeeCount());
    	System.out.printf("Department: %s, Employees count: %s, Total Salary: %s%n", 
    			itDepartment.getTitle(), itDepartment.getEmployeeCount(), itDepartment.getTotalSalary());
    	

//    	Employee vasil = itDepartment.findEmployee("Vasiliy", "Ivanov");
    	
    	Employee nick = findEmployeeWithText(itDepartment, "Nickolay", "Girits");
    	System.out.printf("%s %s salary is %s%n", nick.getFirstName(), nick.getLastName(), nick.getSalary());

    	// notfound will be null since we don't have Sergey Ivanov in IT department
    	Employee notfound = findEmployeeWithText(itDepartment, "Sergey", "Ivanov");
    	itDepartment.fireEmployee("Nickolay", "Girits", "Senior Back-End Developer");
    	Employee nick2 = findEmployeeWithText(itDepartment, "Nickolay", "Girits");
    	itDepartment.hireNewEmployee(nick);
    	findEmployeeWithText(itDepartment, "Nickolay", "Girits");
    	
    	Employee andrey = new Employee("Andrey", "Girits", "Manual QA Engineer", 500);
    	itDepartment.hireNewEmployee(andrey);
    	
    	Employee ruslan = new Employee("Ruslan","Avakumov","Business Analyst", 1200);
    	itDepartment.hireNewEmployee(ruslan);
    	
    	System.out.println("---------------");
        
        printSortedEmployeesOfDepartment(itDepartment);
        printSortedEmployeesOfDepartment(financialDepartment);
    }
    
    // напишем вспомогательную функцию, которая будет искать сотрудника в департаменте по имени и фамилии
    // и выводить информацию о результатах поиска
    // в качестве аргументов она принимает департамент, в котором будем искать, и имя и фамилию сотрудника,
    // которого нужно найти/
    public static Employee findEmployeeWithText(Department department, String firstName, String lastName) {
    	System.out.printf("Searching for employee %s %s in department [%s]...%n", firstName, lastName, department.getTitle());
    	Employee e = department.findEmployee(firstName, lastName);
    	if (e != null) {
    		System.out.printf("Employee %s %s found: %s%n", firstName, lastName, e);
    	} else {
    		System.out.printf("Employee %s %s not found in department [%s]%n", firstName, lastName, department.getTitle());
    	}
  		return e;
    }
    
    // создадим метод для вывода сотрудников департамента в отсортированном по фамилии и имени виде
    public static void printSortedEmployeesOfDepartment(Department department) {
    	Employee[] sortedEmployees = department.getEmployeesSortedByLastName();
        for (Employee e: sortedEmployees) {
           System.out.printf("Department: %s, Last Name: %s, First Name: %s%n", 
        		   department.getTitle(), e.getLastName(), e.getFirstName());
        }
    }    
} 
