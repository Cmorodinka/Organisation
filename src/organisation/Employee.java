package organisation;

public class Employee {
    private String jobTitle;
    private Integer salary;
    private String firstName;
    private String lastName;
    
    // ������������
    
    // ����������� ����� ��������� ���, �������, ���������, ���������.
      public Employee(String firstName, String lastName, String job, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = job;
        this.salary = salary;
      }
           		
    //  ����������� ����� ��������� ��� � ������� (��������� � �������, ��������� � 30� ���.);
        Employee() {
            jobTitle = "�������";
            salary = 300000;
        } 
        
    // ������
      // �������� ����� ��������� ���������; .
      public String getJobTitle() {
        return jobTitle;
      }
      
      // �������� ����� ��������� ���������; 
      public void setJobTitle(String arg) {
        jobTitle = arg;
      }

      // �������� ����� ��������� ���������; 
      public Integer getSalary() {
        return salary;
      }
      
      // �������� ����� ��������� ���������;
      public void setSalary(Integer arg) {
        salary = arg;
      }
      
      // �������� ����� ��������� �����;
      public String getFirstName() {
        return firstName;
      }
      
      // �������� ����� ��������� �����; 
      public void setFirstName(String arg) {
        firstName = arg;
      }
      
      // �������� ����� ��������� �������;
      public String getLastName() {
        return lastName;
      }
      
      // �������� ����� ��������� �������;
      public void setLastName(String arg) {
        lastName = arg;
      }
     
}

