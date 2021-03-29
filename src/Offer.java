import java.util.*;
import java.io.*;

public class Offer implements OfferInterface {
    private static String fileName = "products.txt";
    private Scanner userInputScanner = new Scanner(System.in);
    private String product;
    private int type;
    private int amount;

    public Offer() {
        this.product = "";
        this.type = 0;
        this.amount = 0;
        Offer offer = offerSpecs();
        addToList(offer);
    }

    private Offer(String product, int type, int amount) {
        this.product = product;
        this.type = type;
        this.amount = amount;
    }


    private String getProduct() {
        return product;
    }
    private int getType() {
        return type;
    }
    private int getAmount() {
        return amount;
    }

    private void setProduct(String product) {
        this.product = product;
    }
    private void setType(int type) {
        this.type = type;
    }
    private void setAmount (int amount) {
        this.amount = amount;
    }

    public Offer offerSpecs() {
        System.out.println("Please choose a product name");
        String name = userInputScanner.next();
        System.out.println("Please choose an offer type");
        System.out.println("1. Discount");
        System.out.println("2. Extra items for one item price");
        int type = userInputScanner.nextInt();
        System.out.println("Please choose an offer amount");
        int amount = userInputScanner.nextInt();
        Offer offer = new Offer(name, type, amount);
        return offer;
    }

    public void addToList(Offer offer) {
        try {
            Scanner productScanner = new Scanner(new File(fileName));
            while(productScanner.hasNextLine()) {
                String line = productScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                String name = lineScanner.next();
                if(name.contains(offer.getProduct()) )
                    editProduct(offer, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editProduct(Offer offer, String name) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            StringBuffer buffer = new StringBuffer();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine()+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            String newProduct = name + offer.getType() + "," + offer.getAmount();
            fileContents = fileContents.replace(name, newProduct);
            FileWriter writer = new FileWriter(fileName);
            writer.append(fileContents);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return  this.getProduct() + ", " +
                this.getType() + ", " +
                this.getAmount();
    }

}
