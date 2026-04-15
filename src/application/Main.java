import model.entities.Reservation;

void main() throws ParseException {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Room number: ");
    int number = sc.nextInt();

    System.out.print("Check-in Date (dd/MM/yyyy): ");
    Date checkIn = sdf.parse(sc.next());

    System.out.print("Check-out Date (dd/MM/yyyy): ");
    Date checkOut = sdf.parse(sc.next());

    if(!checkOut.after(checkIn)) {
        System.out.println("Error in reservation: Check-out date must be after check-in date");
    }
    else {
        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        System.out.println();

        System.out.println("Enter data to update the reservation: ");

        System.out.print("Check-in Date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());

        System.out.print("Check-out Date (dd/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());

        String error = reservation.updateDate(checkIn, checkOut);
        if(error != null) {
            System.out.println(error);
        }
        else {
            System.out.println(reservation);
        }
    }

    sc.close();
}
