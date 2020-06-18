package organisation;
import java.util.Date;

// Создайте интерфейс BusinessTraveller – работника, направляемого в командировку.
public interface BusinessTraveller {
	public void addBusinessTravel(Date dateOfLeave, Date dateOfArrival, float travelExpenses, float dailyExpenses); // метод добавления информации о командировке;
	public void addBusinessTravel(BusinessTravel travel); // метод добавления информации о командировке - 2 вариант
	public void removeBusinessTravel(Date dateOfLeave); // метод удаления информации о командировке (принимает параметр дату отбытия); 
	// метод, возвращающий (ссылку на) экземпляр класса BusinessTravel по дате (если введенная дата попадает в интервал между началом и концом командировки); 
	public BusinessTravel findBusinessTravelByDate(Date date);
	public float avgTravelDuration(); // метод, возвращающий среднюю продолжительность командировок работника;
	public float avgDurationBetweenTravels(); // метод, возвращающий средний интервал между командировками в днях.
}
