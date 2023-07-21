public final class Info {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean property;
    private final String registrationNumber;
    private final boolean fragileCargo;

    public Info(Dimensions dimensions,
                double weight,
                String deliveryAddress,
                boolean property,
                String registrationNumber,
                boolean fragileCargo) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.property = property;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
    }
    public Dimensions getDimensions() {
        return dimensions;
    }

    public Info setDimensions(Dimensions dimensions) {
        return new Info(dimensions, weight, deliveryAddress, property,
                registrationNumber, fragileCargo);
    }

    public double getWeight() {
        return weight;
    }

    public Info setWeight(double weight) {
        return new Info(dimensions, weight, deliveryAddress, property,
                registrationNumber, fragileCargo);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Info setDeliveryAddress(String deliveryAddress) {
        return new Info(dimensions, weight, deliveryAddress, property,
                registrationNumber, fragileCargo);
    }

    public boolean isProperty() {
        return property;
    }

    public Info setProperty(boolean property) {
        return new Info(dimensions, weight, deliveryAddress, property,
                registrationNumber, fragileCargo);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Info setRegistrationNumber(String registrationNumber) {
        return new Info(dimensions, weight, deliveryAddress, property,
                registrationNumber, fragileCargo);
    }

    public boolean isFragileCargo() {
        return fragileCargo;
    }

    public Info setFragileCargo(boolean fragileCargo) {
        return new Info(dimensions, weight, deliveryAddress, property,
                registrationNumber, fragileCargo);
    }
    public String toString() {
        return dimensions + "\n" +
                "Масса: " + weight + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Свойство - можно  ли переворачивать: " + property + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n" +
                "Является ли груз хрупким: " + fragileCargo + "\n";
    }
}
