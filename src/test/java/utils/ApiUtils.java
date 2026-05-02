package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiUtils {

	
	/*public static List<String[]> getAllUserCredentials() throws Exception {
        URL url = new URL("https://yourapi.com/getCredentials");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONArray users = jsonResponse.getJSONArray("users");
}
        List<String[]> userList = new ArrayList<>();
   /*     for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            String username = user.getString("username");
            String password = user.getString("password");
            userList.add(new String[]{username, password});
        }
        return userList;
    } 
    else {
        throw new RuntimeException("Failed to fetch credentials: HTTP code " + responseCode);
    }
}*/
}
