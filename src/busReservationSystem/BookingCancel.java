package busReservationSystem;
import java.text.SimpleDateFormat;
import java.util.*;
public class BookingCancel {
	String cancelPassengerName;
	int cancelBusNo;
	Date cancelDate;
	
	BookingCancel()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name:");
		cancelPassengerName=sc.next();
		System.out.println("Enter The Bus No:");
		cancelBusNo=sc.nextInt();
		System.out.println("Enter The Booked Date In dd-mm-yyy Format");
		String cancelDateInput=sc.next();
		try {
			SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
			cancelDate=date.parse(cancelDateInput);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public boolean isBooked(ArrayList<Booking>bookings)
	{
		for(Booking booking:bookings)
		{
			if(booking.getPassengerName().equals(cancelPassengerName) && booking.getBusNo()==cancelBusNo && booking.getDate().equals(cancelDate))
			{
				bookings.remove(booking);
				return true;
			}
		
		}
		return false;
	
	}
}
