package fowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
            // add bonus for a two day new release rental
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }
        // add footer lines
        result += "Amount owned is " + getTotalCharge() + "\n";

        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
