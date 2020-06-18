package organisation;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	public static void main(String[] args) throws ParseException {

		// проверка Enum с помощью метода values(), позволяющего получить массив всех значений Enum
        JobTitles[] titles = JobTitles.values();
        for (JobTitles s : titles) { System.out.println(s); }

        // создание департамента  
        Department itDepartment = new Department("IT department");
    
        // создание сотрудника на полный день
        FullDayEmployee e = new FullDayEmployee("Sergey", "Ivanov", JobTitles.ENGINEER, 1000, dateFormat.parse("20.06.2017"));
        
        // создание сотрудника на неполный день
        HalfDayEmployee eHalfDay = new HalfDayEmployee("Vasiliy", "Petrov", JobTitles.TESTER, 500, dateFormat.parse("23.08.2018"));
        
        // проверка абстрактного public метода, возвращающего ежемесячную премию    
        System.out.printf("%s %s monthly bonus: %s%n", e.getFirstName(), e.getLastName(), e.monthlyBonus());
        
        // создание двух коммандировок одного сотрудника для проверки нескольких методов
        BusinessTravel bt = new BusinessTravel(dateFormat.parse("10.03.2019"), dateFormat.parse("20.04.2019"), 1000, 10);
        BusinessTravel bt2 = new BusinessTravel(dateFormat.parse("01.05.2020"), dateFormat.parse("21.06.2020"), 1000, 10);
        
        // проверка метода durationInDays - длительность коммандировки и метода totalExpenses - общая стоимость коммандировки        
        System.out.printf("Business travel [%s...%s] duration: %s, total expenses: %s%n", 
        		dateFormat.format(bt.getDateOfLeave()), 
        		dateFormat.format(bt.getDateOfReturn()), 
        		bt.durationInDays(),
        		bt.totalExpenses()
        );
        e.addBusinessTravel(bt);
        e.addBusinessTravel(bt2);
        
        // наймем двух сотрудников - на полный день и на неполный       
        itDepartment.hireNewEmployee(e);
        itDepartment.hireNewEmployee(eHalfDay);
        
    	// проверка метода, возвращающего (ссылку на) экземпляр класса BusinessTravel по дате 
    	// (если введенная дата попадает в интервал между началом и концом командировки); 
        BusinessTravel foundBt = e.findBusinessTravelByDate(dateFormat.parse("12.03.2020"));
        System.out.println(foundBt);
        BusinessTravel notFoundBt = e.findBusinessTravelByDate(dateFormat.parse("09.03.2020"));
        System.out.println(notFoundBt);
        
        // проверка метода, возвращающего среднюю продолжительность командировок работника 
        System.out.printf("%s %s average travel duration: %s%n", e.getFirstName(), e.getLastName(), e.avgTravelDuration());
        
        // проверка метода, возвращающего средний интервал между командировками в днях 
        System.out.printf("%s %s average duration between travels: %s%n", e.getFirstName(), e.getLastName(), e.avgDurationBetweenTravels());
        e.removeBusinessTravel(dateFormat.parse("10.03.2020"));
        
        // проверка метод, возвращающего список (ArrayList<FullDayEmployee>) штатных сотрудников
        System.out.println(itDepartment.getFullDayEmployees()); 
        
        // проверка метода, возвращающего список (ArrayList<HalfDayEmployee>) внешних совместителей
        System.out.println(itDepartment.getHalfDayEmployees()); 
        
        // проверка метода, возвращающего список (ArrayList<BusinessTraveller>) сотрудников, находящихся в командировке в данное время
        System.out.println(itDepartment.getCurrentBusinessTravelers());
        
    	// проверка метода, возвращающего список (ArrayList<BusinessTraveller>) сотрудников, 
    	// находящихся в командировке указанного числа (принимается в качестве параметра метода).
        System.out.println(itDepartment.getBusinessTravelersAtDate(dateFormat.parse("09.03.2020"))); 
        System.out.println(itDepartment.getBusinessTravelersAtDate(dateFormat.parse("09.03.2010"))); 
	}
}
