import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;


public class Main {
    private static final String URL_TO_HTML = "data/metro.html";
    public static void main(String[] args) throws IOException, ParseException {
        JSONCreator jsonCreator = new JSONCreator();
        jsonCreator.jsonParser(URL_TO_HTML);
        jsonCreator.printLines();
        jsonCreator.printStationsWithLines();

        FileSearcher fileSearch = new FileSearcher();
        String sourceFolderPath = "/Users/ukolovaaaaa/Downloads/java_basicsTTT/FilesAndNetwork/DataCollector/data-2/data";
        List<File> foundFiles = fileSearch.searchFiles(sourceFolderPath);
        String destinationFolderPath = "/Users/ukolovaaaaa/Downloads/java_basicsTTT/FilesAndNetwork/DataCollector/src/main/resources/data";
        fileSearch.copyFilesToFolder(foundFiles, destinationFolderPath);
        System.out.println("Файлы найдены и скопированы!");


        DataCollector collector = new DataCollector();
        collector.fileReader("/Users/ukolovaaaaa/Downloads/java_basicsTTT/FilesAndNetwork/DataCollector/data-2/data");
        Map<String, Station> listStations = collector.getListStations();
        JSONObject stationObject = new JSONObject();
        JSONArray stationsArray = new JSONArray();
        for (Map.Entry<String, Station> entry: listStations.entrySet()) {
            LinkedHashMap<String, Object> stationMap = new LinkedHashMap<>();
            if(entry.getValue().getName()!=null) {
                stationMap.put("name", entry.getValue().getName());
            }
            if (entry.getValue().getLineName()!=null) {
                stationMap.put("line", entry.getValue().getLineName());
            }
            if (entry.getValue().getDate()!=null) {
                stationMap.put("date", entry.getValue().getDate());
            }
            if (entry.getValue().getDepth()!=null) {
                stationMap.put("depth", entry.getValue().getDepth());
            }
            stationMap.put("hasConnection", entry.getValue().isHasConnection());
            JSONObject stationObj = new JSONObject(stationMap);
            stationsArray.add(stationObj);
        }
        stationObject.put("stations", stationsArray);
        String jsonString = stationObject.toJSONString();
        FileWriter fileWriter = new FileWriter("/Users/ukolovaaaaa/Downloads/java_basicsTTT/FilesAndNetwork/DataCollector/src/main/resources/files/stations.json");
        fileWriter.write(jsonString);
        fileWriter.flush();
        fileWriter.close();

    }
}