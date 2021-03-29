public interface ShoppingCartInterface {

    void addProduct(String product);
    void handleDiscount (long price, int amount);
    // long calculateTotalAmountInCents();
}
