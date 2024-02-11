package busReservationSystem;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
	private String passengerName;
	private int busNo;
	private Date date;
	
	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public Date getDate() {
		return date;
	}
	 public String getFormattedDate() {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        return sdf.format(date);
	    }


	public void setDate(Date date) {
		this.date = date;
	}

	public Booking() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name:");
		passengerName=sc.next();
		System.out.println("Enter Bus No:");
		busNo=sc.nextInt();
		System.out.println("Please Enter Booking Date In The Format dd-mm-yyyy:");
		String dateInput=sc.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateInput);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> buses)
	{
		int capacity=0;
		for(Bus bus:buses)
		{
			if(bus.getBusNo()==busNo)
			{
				capacity=bus.getCapacity();
			}
		}
		int booked=0;
		for(Booking b:bookings)
		{
			if(b.busNo==busNo && b.date.equals(date))
			{
				booked++;
			}
		}
		return booked<capacity;
	}
	
}
