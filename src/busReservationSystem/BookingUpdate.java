package busReservationSystem;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingUpdate {
    private String updateName;
    private int updateBusNo;
    private Date updateBusDate;

    public BookingUpdate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name To Update");
        updateName = sc.next();
        System.out.println("Enter Bus No To Update");
        updateBusNo = sc.nextInt();
        System.out.println("Enter Bus Date (dd-MM-yyyy)");
        String updateBusDateInput = sc.next();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            updateBusDate = dateFormat.parse(updateBusDateInput);
        } catch (Exception e) {
            // Handle exception (you may want to print an error message)
            e.printStackTrace();
        }
    }

    public boolean update(ArrayList<Booking> bookings) {
        for (Booking b : bookings) {
            if (b.getBusNo() == updateBusNo && b.getPassengerName().equals(updateName) && b.getDate().equals(updateBusDate)) {
                // Prompt the user for the new information
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter New Bus No:");
                int newBusNo = sc.nextInt();
                System.out.println("Enter New Passenger Name:");
                String newPassengerName = sc.next();

                // Update the booking information
                b.setBusNo(newBusNo);
                b.setPassengerName(newPassengerName);

     
                return true;
            }
        }
        System.out.println("No matching booking found for update.");
        return false;
    }
}
