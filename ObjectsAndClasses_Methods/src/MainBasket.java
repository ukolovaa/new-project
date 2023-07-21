public class MainBasket {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 4, 100);
        basket.add("Bread", 32, 6, 50);
        basket.add("Butter", 56, 20, 48);
        basket.add("Fish", 238, 12, 33);
        basket.print("");
        System.out.println("Общая масса всех товаров: " + basket.getTotalWeight() + " г.");
        System.out.println("Общая стоимость всех товаров: " + basket.getTotalPrice() + " руб." + "\n");

        Basket basket1 = new Basket();
        basket1.add("Milk", 40,2,100);
        basket1.add("Meat", 800, 4, 900);
        basket1.print("");
        System.out.println("Общая масса всех товаров: " + basket1.getTotalWeight() + " г.");
        System.out.println("Общая стоимость всех товаров: " + basket1.getTotalPrice() + " руб." + "\n");


        Basket basket2 = new Basket();
        basket2.add("Milk", 40,30,100);
        basket2.print("");
        System.out.println("Общая масса всех товаров: " + basket2.getTotalWeight() + " г.");
        System.out.println("Общая стоимость всех товаров: " + basket2.getTotalPrice() + " руб." + "\n");

        System.out.println("Общее количество товаров во всех корзинах: " + Basket.getTotalCount() + " шт.");
        System.out.println("Средняя стоимость товаров во всех корзинах: " + Basket.getAverageСostProduct() + " руб.");
        System.out.println("Общая стоимость товаров во всех корзинах: " + Basket.getTotalPriceBaskets() + " руб." + "\n");
        System.out.println("Общее количество всех корзин: " + Basket.getCount() + " шт.");
        System.out.println("Средняя стоимость всех корзин: " + Basket.getAverageСost() + " руб.");
    }
}
