public class Menu {
    String foodItem;
    double price;

    Menu(String f, double p) {
        foodItem = f;
        price = p;
    }

    static String[] items = new String[] { "Chilli Chicken", "Mutton Biriyani", "Chicken Biriyani", "Kashmiri Polao",
            "Fried Rice", "Mixed Fried Rice", "Paneer Fried Rice", "Veg Noodles", "Chicken Noodles", "Chicken tikka",
            "Chicken lollipop(8pics)", "Afgani Chicken", "Golabari Mutton", "Paneer Chili", " Sahi Paneer",
            "Paneer Postho", "Dudh Paneer", "Alu Postho", };
    static double[] prices = new double[] { 210.0, 350.0, 250.89, 200, 180.69, 240.69, 190.69, 110.69, 150.69, 165.69,
            170.69, 280.69, 320.69, 100, 300.67, 200.69, 100.12, 230.56, 300 };

    static void displayMenu() {
        int len = items.length;
        System.out.println("********************MENU********************\n");
        for (int i = 0; i < len; i++) {
            System.out.println((i + 1) + ". " + items[i] + " --------------------- Rs." + prices[i]);
        }
        System.out.println("\n********************************************");
    }
}
