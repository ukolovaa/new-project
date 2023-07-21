public class MainTwo {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(6,4,5);
        Info info = new Info(dimensions,
                45,
                "Moscow Lenina street 54",
                true,
                "46477-h-V",
                false);
        Dimensions copy = new Dimensions(6,6,6);
        System.out.println(info);
    }
}