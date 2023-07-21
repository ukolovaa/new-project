public class Line {
    private final String number;
    private final String name;

    public Line(String name, String number) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
