package Oasis_Infobyte;


//.....Indrajit Maiti.....

//.....OasisInfobyte.....


import java.util.Scanner;

public class Online_Reservation_System {
	// initialize an array to keep track of the seat reservation status
	private static boolean[] seatStatus = new boolean[100]; 
	
  
   /**
    * Displays the current seat status
    */
   private static void showSeatStatus() {
       System.out.println("\nAvailable Seats:");
       for (int i = 0; i < seatStatus.length; i++) {
           if (seatStatus[i]) {
               System.out.print("X "); // print an "X" if the seat is reserved
           } else {
               System.out.print((i + 1) + " "); // print the seat number if it's empty
           }
       }
       System.out.println();
   }

   /**
    * Reserves a seat
    *
    * scanner object to get user input
    */
   private static void reservingSeat(Scanner scanner) {
       System.out.print("\nEnter your seat number (1-100): ");
       int seatNumber = scanner.nextInt();
       if (seatNumber < 1 || seatNumber > 100) {
           System.out.println("Invalid seat number!");
       } else if (seatStatus[seatNumber - 1]) {
           System.out.println("Seat is already reserved!");
       } else {
           seatStatus[seatNumber - 1] = true; // reserve the seat
           System.out.println("Seat reserved!");
       }
   }

   
   /**
    * Cancels a reservation
    *
    * scanner object to get user input
    */
   private static void canceltheReservation(Scanner scanner) {
       System.out.print("\nEnter seat number (1-100): ");
       int seatNumber = scanner.nextInt();
       if (seatNumber < 1 || seatNumber > 100) {
           System.out.println("Invalid seat number!");
       } else if (!seatStatus[seatNumber - 1]) {
           System.out.println("Seat not reserved!");
       } else {
           seatStatus[seatNumber - 1] = false; // unreserve the seat
           System.out.println("Reservation canceled!");
       }
   }


   public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       while (true) {

           // display menu
           System.out.println("\nPlease select an option:");
           System.out.println("1. View Available Seats");
           System.out.println("2. Reserve Seat");
           System.out.println("3. Cancel Reservation");
           System.out.println("4. Exit");

           // get user input
           int option = scanner.nextInt();

           switch (option) {

               case 1:
                   showSeatStatus();
                   break;

               case 2:
                   reservingSeat(scanner);
                   break;

               case 3:
                   canceltheReservation(scanner);
                   break;

               case 4:
                   System.exit(0); // exit the program

               default:
                   System.out.println("Invalid option!");
           }
       }
   }

   
}