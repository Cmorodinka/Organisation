package organisation;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

// Создайте класс BusinessTravel – командировки
public class BusinessTravel {
	
	private Date dateOfLeave; // дата отбытия с предприятия в командировку
	private Date dateOfReturn; // дата прибытия
	private float travelExpenses; // стоимость трансфера до места и назад
	private float dailyExpenses; // суточные

	// конструктор по умолчанию, не инициирующий поля (пустой конструктор);
	public BusinessTravel() {
	}
	
	// конструктор с параметрами: дата отбытия с предприятия в командировку, дата прибытия, стоимость трансфера до места и назад, суточные. 
	public BusinessTravel(Date dateOfLeave, Date dateOfArrival, float travelExpenses, float dailyExpenses) {
		this.setDateOfLeave(dateOfLeave);
		this.setDateOfReturn(dateOfArrival);
		this.setTravelExpenses(travelExpenses);
		this.setDailyExpenses(dailyExpenses);
	}

	// гетеры и сеттеры полей
	public Date getDateOfLeave() {
		return dateOfLeave;
	}

	public void setDateOfLeave(Date dateOfLeave) {
		this.dateOfLeave = dateOfLeave;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public float getTravelExpenses() {
		return travelExpenses;
	}

	public void setTravelExpenses(float travelExpenses) {
		this.travelExpenses = travelExpenses;
	}

	public float getDailyExpenses() {
		return dailyExpenses;
	}

	public void setDailyExpenses(float dailyExpenses) {
		this.dailyExpenses = dailyExpenses;
	}
	
	// метод, возвращающий число полных дней между датами отбытия и прибытия;
	public long durationInDays() {
		LocalDateTime startDate = getDateOfLeave().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // дата отбытия
		LocalDateTime endDate = getDateOfReturn().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(); // дата прибытия
		return Duration.between(startDate, endDate).toDays();
	}
	
	// метод, возвращающий общую сумму затраченных на командировку денег (трансфер + суточные * кол-во дней).
	public float totalExpenses() {
		return getTravelExpenses() + getDailyExpenses() * durationInDays();
	}
}
