import com.google.common.collect.ForwardingMap;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.*;




public class CustomerStorage {
    private final Map<String, Customer> storage;
    public CustomerStorage() {
        storage = new HashMap<>();
    }
    private static final Logger logger = LogManager.getLogger(CustomerStorage.class);

    public void addCustomer(String data) {

        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String phoneRegex = "[+][0-9]{11}";
        String emailRegex = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
        String[] components = data.split("\\s+");

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            if (components.length != 4){
                logger.log(Level.ERROR,"Неверный формат. Для примера воспользуйтесь командой help:");
                throw new RuntimeException("Неверный формат. Для примера воспользуйтесь командой help:");
            } else if (!components[INDEX_EMAIL].matches(emailRegex)){
                logger.log(Level.ERROR, "неверный формат email");
                throw new RuntimeException("неверный формат email");
            } else if (!components[INDEX_PHONE].matches(phoneRegex)){
                logger.log(Level.ERROR,"неверный формат номера телефона");
                throw new RuntimeException("неверный формат номера телефона");
            } else {
                logger.log(Level.INFO, "Операция");
            }
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}