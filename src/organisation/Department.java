package organisation;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.*; 

public class Department {
	private String title;
	private Employee[] employees; // ����� ������ ����� ������� ������ ����� ����������.
//	final String ORIGINAL_DEPARTMENT_NAME = "Roga i kopita";
	
	//	������������
	// ����������� ����� ��������� ��� ������������� (� ���� ������ ���������� ���������� = 0);
    public Department(String departmentTitle) {
    	title = departmentTitle;
    	employees = new Employee[0];
    }
    
    // ����������� ����� ��������� ������ ����������
    public Department(Employee[] employees) {
    	this.employees = employees;
    }
    

    
    // ������
	// �������� ����� ��������� ����� �������������
	public String getTitle() {
		return title;
	}
	
	// �������� ����� ��������� ����� �������������
	public void setTitle(String title) {
		this.title = title;
	}
	
	// �������� �����, ������������ ����� ����� ���������� �������������
	public Integer getEmployeeCount() {
		return employees.length;
	}

	// �������� �����, ������������ ��������� �������� ���� ����������, ����������� � ������� �������������
	public Integer getTotalSalary() {
		Integer totalSalary = 0;
		for (int i = 0; i < employees.length; ++i)
			totalSalary += employees[i].getSalary();
		return totalSalary;
	}
	
	
	// �������� �����, ������������ ������ �� ��������� �� ������� � �����
	// ���������� null, ���� �������� � ����� ������ � �������� �� ������
	// ���������� ������ �� ������� ���������� ��������� � ��������� ������ � ��������
	public Employee findEmployee(String firstName, String lastName) {
		for (int i = 0; i < employees.length; ++i) {
			if ( employees[i].getFirstName().equals(firstName) && employees[i].getLastName().equals(lastName) ) {
				return employees[i];
			}
		}
		return null;
	}
	
	// �������� ����� ���������� ��������� (��������� � �������� ������� ���������� �������, ���, ��������� ���������, 
	// �������� ����� �������, ������� ��������������� ���� ������ ������� �� ������� ����������);
	// ���������� true, ���� �������� ������ � ������� ������, false ���� �� ������
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
	
    // �������� ��������� ����� ��� ���������� ������� �����������
    private void setEmployees(Employee[] employees) {
    	this.employees = employees;
    }

    // �������� �����, ������������ ������ ���������� ������; 
    public Employee[] getEmployees() {
    	return employees;
    }
    
	/* �������� ����� ������ ��������� �� ������ (��������� � �������� ������� ���������� 
	 * ������ �� ��������� ������ Employee, ��������� ������ ���������� ����� ���������� ������ �������� � ����� �������);
	 */
	public void hireNewEmployee(Employee employee) {
		// �������� ����� ������, ������� ����� ����� ����� �� 1 ������� ������, ��� ��������
		// ����� ��������� � ���� �������� ������, � ����� � ������� ��������� ������� ������� ������ ����������...
		Employee[] updatedEmployees = new Employee[employees.length + 1];
		System.arraycopy(employees, 0, updatedEmployees, 0, employees.length);
		updatedEmployees[employees.length] = employee;
		setEmployees(updatedEmployees);
	}
	
	// �������� ����� ��������� SortByLastNameFirstName, ����������� ��������� Comparator ��� ���������� ����������� ������ Emoloyee
	class SortByLastNameFirstName implements Comparator<Employee> 
	{ 
	    // ���������� compare-������� ��� ����������� �� ����������� �� ���������� �������+���
		// ��������� ��� ����� ��� ����������� ������� ����������� � ������ �����, �� �� ������� ���������� �� ������ �� �������,
		// � �� ������ �������.concat(���)
	    public int compare(Employee e1, Employee e2) 
	    { 
            final String field1 = e1.getLastName().concat(e1.getFirstName());
            final String field2 = e2.getLastName().concat(e2.getFirstName());
            return field1.compareTo(field2);
	    } 
	} 
	
	/*�������� �����, ������������ ������ ���������� ������, ��������������� �� �������� 
	 * (� ���� ���������� ������� � �� �� ������)..
	 */
	public Employee[] getEmployeesSortedByLastName() {
		Employee [] sortedEmployees = new Employee[employees.length];
		System.arraycopy(employees, 0, sortedEmployees, 0, employees.length);
		Arrays.sort(sortedEmployees, new SortByLastNameFirstName());
			
		return sortedEmployees;
	}
}
