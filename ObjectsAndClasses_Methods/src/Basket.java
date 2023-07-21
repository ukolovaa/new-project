public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private static int totalPriceBaskets = 0;
    private static int totalCount = 0;
    private static double averageСost = 0;
    private static double averageСostProduct = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }
    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }
    public static void increaseTotalPriceBaskets(int totalPriceBaskets) {
        Basket.totalPriceBaskets = Basket.totalPriceBaskets + totalPriceBaskets;
    }
    public static void setTotalCount(int totalCount) {
        Basket.totalCount = Basket.totalCount + totalCount;
    }
    public static void increaseAverageСost(double averageСost) {
        Basket.averageСost = Basket.averageСost + averageСost;
    }
    public static void setAverageСostProduct(double averageСostProduct) {
        Basket.averageСostProduct = Basket.averageСostProduct + averageСostProduct;
    }

    public void add(String name, int price, int count) {
        add(name, price);
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count, int weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб. - " + weight + " г.";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        totalPriceBaskets = totalPriceBaskets + count * price;
        totalCount = totalCount + 1;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public static int getTotalPriceBaskets() {
        return totalPriceBaskets ;
    }
    public static int getTotalCount() {
        return totalCount;
    }
    public static double getAverageСost() {
        return totalPriceBaskets/count;
    }
    public static double getAverageСostProduct() {
        return totalPriceBaskets/totalCount;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
