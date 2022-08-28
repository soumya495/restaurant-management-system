/*
ID,  Name,    Phone,   OrderDetails
Date(dd/mm/yyyy),  Order amount, Table number(1/2/3…/7)
Time slot(11:00-12:00)
*/

import java.util.Scanner;

public class Customer {
    static int idCt = 100;
    int id, table_no;
    double order_amt;
    String name, date, time_slot;
    long phone;
    int items;
    Menu[] orders = new Menu[300];

    void newCustomer() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        this.name = s.nextLine();
        System.out.print("Enter Your Phone Number: ");
        this.phone = s.nextLong();
        idCt += 1;
        id = idCt;
        items = 0;
        this.date = "30/08/22";

        Statistics.addCustomer(this);
    }

    void updateOrderDetails(int option) {
        String foodItem = Menu.items[option - 1];
        double foodPrice = Menu.prices[option - 1];
        Menu m = new Menu(foodItem, foodPrice);
        orders[items] = m;
        order_amt += foodPrice;
        items += 1;
    }

    void displayOrderDetails() {
        if (items < 0) {
            System.out.println("No Orders Yet!: ");
            return;
        }
        System.out.println("All Orders: ");
        for (int i = 0; i < items; i++) {
            System.out.println(i + 1 + ". " + orders[i].foodItem + " --------------------- Rs." + orders[i].price);
        }
    }

    void displayCustomerDetails() {
        System.out.println("********************CUSTOMER DETAILS********************\n");
        System.out.println("Customer ID:" + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Date: " + date);
        System.out.println("Table No: " + table_no);
        System.out.println("Time: " + time_slot);
        System.out.println("Total Amount: " + order_amt);
        this.displayOrderDetails();
        System.out.println("\n********************************************************");
    }
}
