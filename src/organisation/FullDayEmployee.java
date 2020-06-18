package organisation;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.*;

// Создайте класс FullDayEmployee штатного сотрудника, расширяющий (наследующий) класс Employee
public class FullDayEmployee extends Employee implements BusinessTraveller {
	
	// поле типа ArrayList< BusinessTravel> – этот список будет содержать всю информацию о командировках сотрудника
	private ArrayList<BusinessTravel> travels;

	// Добавьте такие же конструкторы, что и в классе Employee
	public FullDayEmployee(String firstName, String lastName, JobTitles jobTitle, Integer salary, Date hiredDate) {
		super(firstName, lastName, jobTitle, salary, hiredDate);
		travels = new ArrayList<BusinessTravel>(); // При создании экземпляра сотрудника, в конструкторах, это поле инициируется списком нулевой длины
	}
	// Добавьте такие же конструкторы, что и в классе Employee
    public FullDayEmployee() {
        setJobTitle(JobTitles.ENGINEER);
        setSalary(300000);
		travels = new ArrayList<BusinessTravel>(); // При создании экземпляра сотрудника, в конструкторах, это поле инициируется списком нулевой длины
    }

/* добавьте реализацию метода, возвращающего ежемесячную премию. 
 * Она вычисляется как число полных лет, которые проработал сотрудник в компании, деленное на 20. 
 * Кроме того, если зарплата начисляется в январе (то есть текущий месяц – январь), 
 * премия увеличивается на размер оклада (для определения текущей даты используется класс Calendar). 
 */
	public float monthlyBonus() {
		float bonus = 0;
		
		// для определения текущей даты используется класс Calendar
		Calendar calendar = Calendar.getInstance();
		int currentMonth = calendar.get(Calendar.MONTH);

		// расчет числа полных лет в компании
		LocalDate startDate = getHiredDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // дата найма сотрудника
		LocalDate endDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // текущая дата
		Period period = Period.between(startDate, endDate); // интервал между текущей датой и датой приема на работу
		float fullYearsInCompany = period.getYears(); // число полных лет, которые проработал сотрудник в компании
//		System.out.println(startDate);
//		System.out.println(endDate);
//		System.out.println(period.getYears());
		
		
		// бонус вычисляется как число полных лет, которые проработал сотрудник в компании, деленное на 20.
		bonus = fullYearsInCompany / 20;

		/* Кроме того, если зарплата начисляется в январе (то есть текущий месяц – январь),
		 * премия увеличивается на размер оклада
		 */
		if (currentMonth == Calendar.JANUARY)
			bonus += getSalary();
		
		return bonus;
	}
	
	@Override
	public void addBusinessTravel(Date dateOfLeave, Date dateOfArrival, float travelExpenses, float dailyExpenses) {
		BusinessTravel travel = new BusinessTravel(dateOfLeave, dateOfArrival, travelExpenses, dailyExpenses);
		travels.add(travel);
	}
	@Override
	public void addBusinessTravel(BusinessTravel travel) {
		travels.add(travel);
	}
	
	// метод удаления информации о командировке (принимает параметр дату отбытия); 
	@Override
	public void removeBusinessTravel(Date dateOfLeave) {
		for (int i = 0; i < travels.size(); i++) {
		    BusinessTravel travel = travels.get(i);
		    if (travel.getDateOfLeave() == dateOfLeave) {
		    	travels.remove(travel);
		    }
		}
	}
	// метод, возвращающий (ссылку на) экземпляр класса BusinessTravel по дате 
	// (если введенная дата попадает в интервал между началом и концом командировки); 
	@Override
	public BusinessTravel findBusinessTravelByDate(Date date) {
		for (int i = 0; i < travels.size(); i++) {
		    BusinessTravel travel = travels.get(i);
			if (date.after(travel.getDateOfLeave()) && date.before(travel.getDateOfReturn())) {
				return travel;
			}
		}
		return null; // return null если ничего не найдено
	}
	
	// метод, возвращающий среднюю продолжительность командировок работника; 
	@Override
	public float avgTravelDuration() {
		int totalTravels = travels.size(); // общее количество командировок
		int totalTravelDays = 0; // общее количество дней всех командировок работника
		
		for (int i = 0; i < travels.size(); i++) {
		    BusinessTravel travel = travels.get(i);
		    totalTravelDays += travel.durationInDays();
		}
		if (totalTravels > 0) {
			return totalTravelDays / totalTravels;
		} else {
			return 0;
		}
	}
	
	// метод, возвращающий средний интервал между командировками в днях. 
	@Override
	public float avgDurationBetweenTravels() {
		if (travels.size() < 2) { // если меньше двух командировок, сразу возвращаем 0
			return 0; 
		}
		int totalDaysBetweenTravels = 0;
		for (int i = 0; i < (travels.size()-1); i++) {
		    BusinessTravel travel1 = travels.get(i);
		    BusinessTravel travel2 = travels.get(i+1);
		    
			LocalDateTime startDate = travel1.getDateOfReturn().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // дата возврата с прошлой командировки
			LocalDateTime endDate = travel2.getDateOfLeave().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // дата отправки в следующую командировку
			long days = Duration.between(startDate, endDate).toDays(); // интервал между датой отбытия и прибытия
			totalDaysBetweenTravels += days; // число полных дней между командировками
		}
		return totalDaysBetweenTravels/(travels.size()-1);
	}
	


}
