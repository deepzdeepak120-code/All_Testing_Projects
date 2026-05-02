package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {
	
	 public static List<String> readIdsFromTxt(String filePath) {
	        try {
	            String content = new String(Files.readAllBytes(Paths.get(filePath)));
	            return Arrays.stream(content.split(","))
	                         .map(String::trim)
	                         .filter(id -> !id.isEmpty())
	                         .collect(Collectors.toList());
	        } catch (IOException e) {
	            throw new RuntimeException("Error reading ID list from file: " + filePath, e);
	        }
	    }

}
