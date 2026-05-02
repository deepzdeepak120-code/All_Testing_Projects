package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    public static List<String> getUrlsFromCSV(String filePath) {
        List<String> urlList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                urlList.add(line.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlList;
    }
}
