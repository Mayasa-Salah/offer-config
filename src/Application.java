import java.io.*;
import java.util.*;

public class Application {
    private static String fileName = "products.txt";
    private static Scanner userInputScanner = new Scanner(System.in);
    private static Offer productOffer;
    private static ShoppingCart shoppingCart;

    public static void main(String args[]) {
        writeToFile();
        printMainScreen();
    }

    private static void writeToFile() {
        try {
            FileWriter fw = new FileWriter(fileName);
            String productslist = productslist();
            fw.write(productslist);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMainScreen() {
        System.out.println("Please make your choice: ");
        System.out.println("1 - Add products to cart");
        System.out.println("2 - Configure an offer");
        int choise = userInputScanner.nextInt();
        inputDigitHandler(choise);
    }

    public static void inputDigitHandler(int userInputDigit) {
        System.out.printf(" %s ", userInputDigit);
        switch (userInputDigit) {
            case 1: showProducts();
                break;
            case 2: addNewOffer();
                break;
        }
    }

    public static void showProducts () {
        productslist();
        shoppingCart = new ShoppingCart();
    }

    public static void addNewOffer () {
        productOffer = new Offer();
        printMainScreen();
    }

    public static String productslist () {
        String productslist = "";
        for (Product p : Product.values()) {
            productslist+= p + "," + p.amountInCents()+ "," +  "\n";
            System.out.printf(" %s , %f%n", p, p.amountInCents());
        }
        return productslist;
    }
}
