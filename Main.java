import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x, y;
        System.out.println("Welcome To Our Restaurant");
        try (Scanner s = new Scanner(System.in)) {
            do {
                System.out.println("\n\n********************OPTIONS********************");
                System.out.println("1. Food Menu");
                System.out.println("2. Time Slots");
                System.out.println("3. Check Table Availability");
                System.out.println("4. Book a Table");
                System.out.println("5. Order Food");
                System.out.println("6. Get Bill");
                System.out.println("7. Get Table View");
                System.out.println("8. List all customers");
                System.out.println("9. List Customer with maximum order");
                System.out.println("10. Get Total Income");
                System.out.println("0. Exit");

                System.out.print("Your Choice: ");

                x = s.nextInt();

                System.out.println("***********************************************\n\n");

                if (x == 0)
                    break;

                switch (x) {
                    case 1:
                        Menu.displayMenu();
                        break;
                    case 2:
                        TableBooking.displayTimeSlots();
                        break;
                    case 3:
                        TableBooking.displayTimeSlots();
                        System.out.println("Choose Time Slot(1 - 12): ");
                        y = s.nextInt();
                        if (TableBooking.isAvailable(y)) {
                            System.out.println("Table Available between " + TableBooking.timeSlots[y - 1]);
                        } else {
                            System.out.println("Table Not Available between " + TableBooking.timeSlots[y - 1]);
                        }
                        break;
                    case 4:
                        TableBooking.displayTimeSlots();
                        System.out.println("Choose Time Slot(1 - 12): ");
                        y = s.nextInt();
                        if (TableBooking.isAvailable(y)) {
                            Customer c = new Customer();
                            c.newCustomer();
                            TableBooking t = new TableBooking();
                            t.bookTable(y, c);
                            System.out.println("Table Booked between " + TableBooking.timeSlots[y - 1]);
                            System.out.println("Your Customer ID(Use the ID for ordering food): " + c.id);
                            System.out.println("Table No: " + c.table_no);
                        } else {
                            System.out.println("Table Not Available between " + TableBooking.timeSlots[y - 1]);
                        }
                        break;
                    case 5:
                        int id;
                        System.out.print("Enter Customer ID: ");
                        id = s.nextInt();
                        if (Statistics.isValidCustomer(id)) {
                            Customer c = Statistics.getCustomer(id);
                            int food, choose;
                            Menu.displayMenu();
                            System.out.print("Enter your Choice(1-18): ");
                            food = s.nextInt();
                            c.updateOrderDetails(food);
                            do {
                                System.out.print("Do You Want To Order More(0/1): ");
                                choose = s.nextInt();
                                if (choose == 0)
                                    break;
                                System.out.print("Enter your Choice(1-18): ");
                                food = s.nextInt();
                                c.updateOrderDetails(food);
                            } while (choose != 0);
                        } else {
                            System.out.println("Invalid Customer ID");
                        }
                        break;
                    case 6:
                        System.out.print("Enter Customer ID: ");
                        id = s.nextInt();
                        if (Statistics.isValidCustomer(id)) {
                            Customer c = Statistics.getCustomer(id);
                            c.displayCustomerDetails();
                        } else {
                            System.out.println("Invalid Customer ID");
                        }
                        break;
                    case 7:
                        TableBooking.displayTableView();
                        break;
                    case 8:
                        Statistics.listAllCustomers();
                        break;
                    case 9:
                        Customer c1 = Statistics.maxOrder();
                        if (c1 == null)
                            System.out.println("No Customers Yet");
                        else
                            c1.displayCustomerDetails();
                        break;
                    case 10:
                        System.out.println("Total Income: " + Statistics.totalIncome());
                        break;
                    default:
                        System.out.println("Please Enter Valid Option");
                }

            } while (x != 0);

            System.out.println("Thank you for Visiting Us!");
        }
    }
}