import model.entities.Reservation;
import model.exceptions.DomainException;

void main() {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("Check-in Date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Check-out Date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println("Reservation: " + reservation);

        System.out.println();

        System.out.println("Enter data to update the reservation: ");

        System.out.print("Check-in Date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());

        System.out.print("Check-out Date (dd/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());

        reservation.updateDate(checkIn, checkOut);

        System.out.println("Reservation: " + reservation);
    } catch (ParseException | DomainException | RuntimeException e) {
        System.out.println(e.getMessage());
    }

    sc.close();
}
