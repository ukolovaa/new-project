import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(findPlanesLeavingInTheNextTwoHours(Airport.getInstance()));
    }
    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        long now = System.currentTimeMillis();
        long twoHourAfter = System.currentTimeMillis() + (2 * 3600000);
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Stream<Terminal> terminal = airport.getTerminals().stream();
        List<Flight> flight = terminal.map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate().getTime() < twoHourAfter && f.getDate().getTime() > now)
                .collect(Collectors.toList());

        return flight;
    }
}