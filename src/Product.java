public enum Product {
    SPRINKLES(135),
    COOKIES(150),
    PEANUT_BUTTER(80),
    MEAT(120),
    BANANA(20);
    private final long amountInCents;
    Product(long amountInCents) {
    this.amountInCents = amountInCents;
    }
    public double amountInCents() { return amountInCents; }
}
