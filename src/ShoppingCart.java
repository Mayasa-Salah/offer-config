import java.util.*;
import java.io.*;

public class ShoppingCart implements ShoppingCartInt {
    private static String fileName = "products.txt";
    private Product product;

    public ShoppingCart () {
        this.product = product;
        Scanner userInputScanner = new Scanner(System.in);
        String choise = userInputScanner.next();
        getProduct(choise);
    }

    private void getProduct(String choise) {
        try {
            Scanner productScanner = new Scanner(new File(fileName));
            while(productScanner.hasNextLine()) {
                String line = productScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                String name = lineScanner.next();
                if(name.contains(choise) )
                   addProduct(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addProduct(String product) {
        Scanner lineScanner = new Scanner(product).useDelimiter(",");
        lineScanner.next();
        String price = lineScanner.next();
        String offer = "0";
        String amount = "0";
        if(lineScanner.hasNext()) {
            offer = lineScanner.next();
            amount = lineScanner.next();
        }
        handleProduct(price, offer, amount);
    }

    private void handleProduct(String price, String offer, String amount) {
        long p = (long)Double.parseDouble(price);
        int o = Integer.parseInt(offer);
        int a = Integer.parseInt(amount);
        switch (o) {
            case 1: handleDiscount(p, a);
                break;
            // case 2: handleFreeItems(p, amount);
            //     break;
            default:
                break;
        }
    }
    public void handleDiscount (long price, int amount) {
        long discount = price * amount / 100;
        price = price - discount;
         System.out.printf(" %s ", price);
    }
}
