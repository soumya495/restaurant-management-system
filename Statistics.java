public class Statistics {
    static Customer[] listOfCustomers = new Customer[300];
    static int customers = 0;

    static void addCustomer(Customer c) {
        listOfCustomers[customers] = c;
        customers += 1;
    }

    static boolean isValidCustomer(int id) {
        for (int i = 0; i < customers; i++) {
            if (listOfCustomers[i].id == id)
                return true;
        }
        return false;
    }

    static Customer getCustomer(int id) {
        for (int i = 0; i < customers; i++) {
            if (listOfCustomers[i].id == id)
                return listOfCustomers[i];
        }
        return null;
    }

    static void checkForCustomers() {
        if (customers == 0) {
            System.out.println("No Customers Yet");
            return;
        }
    }

    static void listAllCustomers() {
        checkForCustomers();
        for (int i = 0; i < customers; i++) {
            System.out.println(i + 1 + ". " + listOfCustomers[i].id + " ----------- " + listOfCustomers[i].name
                    + " ----------- Rs." + listOfCustomers[i].order_amt);
        }
    }

    static Customer maxOrder() {
        if (customers == 0)
            return null;
        double max = 0.0;
        Customer c = null;
        for (int i = 0; i < customers; i++) {
            if (listOfCustomers[i].order_amt >= max) {
                max = listOfCustomers[i].order_amt;
                c = listOfCustomers[i];
            }
        }
        return c;
    }

    static double totalIncome() {
        if (customers == 0)
            return 0.0;
        double total = 0.0;
        for (int i = 0; i < customers; i++) {
            total += listOfCustomers[i].order_amt;
        }
        return total;
    }
}
