class TicketBookingSystem {
    private int availableSeats;
    private final Object lock = new Object();

    TicketBookingSystem(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void bookSeat(int seats, String name) {
        synchronized (lock) {
            if (availableSeats >= seats) {
                System.out.println(seats + " seat(s) booked by " + name);
                availableSeats -= seats;
            } else {
                System.out.println("No seats available for " + name);
            }
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private int seats;
    private String name;

    BookingThread(TicketBookingSystem bookingSystem, int seats, String name) {
        this.bookingSystem = bookingSystem;
        this.seats = seats;
        this.name = name;
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(seats, name);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10);

        BookingThread vip1 = new BookingThread(bookingSystem, 2, "VIP1");
        BookingThread vip2 = new BookingThread(bookingSystem, 3, "VIP2");
        BookingThread regular1 = new BookingThread(bookingSystem, 2, "Regular1");
        BookingThread regular2 = new BookingThread(bookingSystem, 4, "Regular2");

        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY);
        regular2.setPriority(Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
