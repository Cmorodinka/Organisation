package organisation;
import java.util.Date;

// Создайте класс HalfDayEmployee – внешнего совместителя, расширяющий (наследующий) класс Employee
public class HalfDayEmployee extends Employee {

	// Добавьте такие же конструкторы, что и в классе Employee
	public HalfDayEmployee(String firstName, String lastName, JobTitles jobTitle, Integer salary, Date hiredDate) {
		super(firstName, lastName, jobTitle, salary, hiredDate);
	}

	// Добавьте такие же конструкторы, что и в классе Employee
    public HalfDayEmployee() {
        setJobTitle(JobTitles.СLERK);
        setSalary(5000);
    }
    
	// добавьте реализацию метода, возвращающего ежемесячную премию. Этот метод возвращает 0
	public float monthlyBonus() {
		return 0;
	}

}
