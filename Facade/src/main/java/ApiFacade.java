import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = getJsonFromApi(urlString);
        return extractValue(json, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        try (BufferedReader in =
                     new BufferedReader(new InputStreamReader(con.getInputStream()))) {

            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            return content.toString();

        } finally {
            con.disconnect();
        }
    }

    private String extractValue(String json, String attributeName) {

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            Object value = findAttribute(jsonObject, attributeName);

            if (value == null) {
                throw new IllegalArgumentException(
                        "Attribute not found: " + attributeName
                );
            }

            return value.toString();

        } catch (IllegalArgumentException e) {
            throw e;

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON");
        }
    }

    private Object findAttribute(JSONObject jsonObject, String attributeName) {

        if (jsonObject.containsKey(attributeName)) {
            return jsonObject.get(attributeName);
        }

        for (Object key : jsonObject.keySet()) {

            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {

                Object result =
                        findAttribute((JSONObject) value, attributeName);

                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }
}