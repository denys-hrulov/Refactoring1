package fowler;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("John");
        customer.addRental(new Rental(new Movie("Star Wars", Movie.NEW_RELEASE), 2));
        System.out.println(customer.statement());
    }
}
