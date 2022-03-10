package interfaces.shared.methods;

public class Program {
    public static void main(String[] args) {
        Shop s1 = new ShopAlpha();
        Shop s2 = new ShopBeta();

        demoShop(s1);
        demoShop(s2);
    }

    private static void demoShop(Shop shop) {
        System.out.println("This shop offers discount on:");
        Shop.daysOfferingDiscount(shop).forEach(System.out::println);
    }
}
