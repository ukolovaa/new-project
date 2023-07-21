import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> stations;
    StationIndex stationIndex = new StationIndex();
    List<Station> connection = new ArrayList<>();
    List<Station> connectionTwo = new ArrayList<>();
    RouteCalculator routeCalculator;
    @Override
    protected void setUp() throws Exception {
        stations = new ArrayList<>();
        Line line1 = new Line(1, "Первая линия");
        Line line2 = new Line(2, "Вторая линия");
        Line line3 = new Line(3, "третья линия");

        Station station1_1 = new Station("A1", line1);
        Station station1_2 = new Station("A2", line1);
        Station station1_3 = new Station("A3", line1);
        Station station1_4 = new Station("A4", line1);

        Station station2_1 = new Station("B1", line2);
        Station station2_2 = new Station("B2", line2);
        Station station2_3 = new Station("B3", line2);
        Station station2_4 = new Station("B4", line2);

        Station station3_1 = new Station("C1", line3);
        Station station3_2 = new Station("C2", line3);
        Station station3_3 = new Station("C3", line3);
        Station station3_4 = new Station("C4", line3);

        stations.add(station1_1);
        stations.add(station1_2);
        stations.add(station1_3);
        stations.add(station1_4);
        stations.add(station2_1);
        stations.add(station2_2);
        stations.add(station2_3);
        stations.add(station2_4);
        stations.add(station3_1);
        stations.add(station3_2);
        stations.add(station3_3);
        stations.add(station3_4);

        line1.addStation(station1_1);
        line1.addStation(station1_2);
        line1.addStation(station1_3);
        line1.addStation(station1_4);

        line2.addStation(station2_1);
        line2.addStation(station2_2);
        line2.addStation(station2_3);
        line2.addStation(station2_4);

        line3.addStation(station3_1);
        line3.addStation(station3_2);
        line3.addStation(station3_3);
        line3.addStation(station3_4);

        connection.add(station1_3);
        connection.add(station3_2);
        connectionTwo.add(station3_3);
        connectionTwo.add(station2_2);


        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(station1_1);
        stationIndex.addStation(station1_2);
        stationIndex.addStation(station1_3);
        stationIndex.addStation(station1_4);
        stationIndex.addStation(station2_1);
        stationIndex.addStation(station2_2);
        stationIndex.addStation(station2_3);
        stationIndex.addStation(station2_4);
        stationIndex.addStation(station3_1);
        stationIndex.addStation(station3_2);
        stationIndex.addStation(station3_3);
        stationIndex.addStation(station3_4);

        stationIndex.addConnection(connection);
        stationIndex.addConnection(connectionTwo);

        routeCalculator = new RouteCalculator(stationIndex);

    }
    public void testCalculatorDuration() {
        double actual = RouteCalculator.calculateDuration(stations);
        double expected = 29.5;
        assertEquals(expected, actual);
    }
    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(2));
        List<Station> expected = List.of(stations.get(0), stations.get(1), stations.get(2));
        assertEquals(expected, actual);
    }
    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(11));
        List<Station> expected = List.of(stations.get(0),stations.get(1),stations.get(2),
                stations.get(9), stations.get(10), stations.get(11));
        assertEquals(expected, actual);
    }
    public void testIsConnected() {
        List<Station> actualNoTransfer = routeCalculator.getShortestRoute(stations.get(1), stations.get(2));
        List<Station> actualTwoTransfer = routeCalculator.getShortestRoute(stations.get(0), stations.get(11));
        List<Station> actualThreeTransfers = routeCalculator.getShortestRoute(stations.get(11), stations.get(6));

        List<Station> expectedNoTransfers = List.of(stations.get(1), stations.get(2));
        List<Station> expectedTwoTransfers = List.of(stations.get(0),stations.get(1),stations.get(2),
                stations.get(9), stations.get(10), stations.get(11));
        List<Station> expectedThreeTransfers = List.of(stations.get(11), stations.get(10),
                stations.get(5), stations.get(6));

        assertEquals(actualNoTransfer, expectedNoTransfers);
        assertEquals(actualTwoTransfer, expectedTwoTransfers);
        assertEquals(actualThreeTransfers, expectedThreeTransfers);
    }
    public void testGetRouteViaConnectedLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(2));
        List<Station> expected = List.of(stations.get(0), stations.get(1), stations.get(2));
        assertEquals(expected, actual);
    }
    public void testGetRouteWithTwoConnections(){
        List<Station> actual = routeCalculator.getShortestRoute(stations.get(11), stations.get(6));
        List<Station> expected = List.of(stations.get(11), stations.get(10),
                stations.get(5), stations.get(6));
        assertEquals(expected, actual);
    }
    public void testGetShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(stations.get(0), stations.get(2));
        List<Station> expected = List.of(stations.get(0), stations.get(1), stations.get(2));
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }

}
