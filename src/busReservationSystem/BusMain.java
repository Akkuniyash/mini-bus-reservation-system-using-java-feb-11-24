package busReservationSystem;

import java.util.*;

public class BusMain {
	static
	{
		System.out.println("Mini Bus Reservation System By Using Java OOPS!!!\n");
		System.out.println("Welcome To RapidRoute Express!!!\n");
	}
	public static void main(String[] args) {
		ArrayList <Bus> buses=new ArrayList<>();
		ArrayList <Booking> bookings=new ArrayList<>();
		buses.add(new Bus(123,true,1));
		buses.add(new Bus(236,false,50));
		buses.add(new Bus(345,true,52));
		
		
		for(Bus b:buses)
		{
			b.displayBusInfo();
		}
		
		int userOption=1;
		Scanner sc=new Scanner(System.in);
		while(!(userOption==5))
		{
			System.out.println("Please Enter \n1 To Book \n2 To Cancel Ticket \n3 To See History \n4 To Update \n5 To Exit:");
			userOption=sc.nextInt();
			if(userOption==1)
			{
				Booking booking=new Booking();
				if(booking.isAvailable(bookings, buses))
				{
					bookings.add(booking);
					System.out.println("Successfully Booked Your Tickets");
				}
				else
				{
					System.out.println("Sorry Bus Is Fully Reserved Try Another One");
				}
			}
			else if(userOption==2)
			{
				BookingCancel bc=new BookingCancel();
				if(bc.isBooked(bookings))
				{
					System.out.println("Successfully cancelled");
				}
				else
				{
					System.out.println("Sorry The Information You Provided Is Not Valid");
				}
			}
			else if(userOption==3)
			{
				for(Booking b:bookings)
				{
					System.out.println("Passenger Name:"+b.getPassengerName()+"\nBus No:"+b.getBusNo()+"\nDate:"+b.getFormattedDate());
					System.out.println();
				}
			}
			else if(userOption==4)
			{
				BookingUpdate bu=new BookingUpdate();
				if(bu.update(bookings))
				{
					System.out.println("Successfully Updated");
				}
				else
				{
					System.out.println("Sorry The Information You Provided Is Not Valid");
				}
			}
			else
			{
				System.out.println("Thank You For Using RapidRoute Express!!");
				break;
			}
			
		}
		
	}
}
