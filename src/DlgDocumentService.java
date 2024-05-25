// This class is responsible for fetching documents from the Digital Library of Georgia API.
// The fetchDocuments method takes a county name, page number, and sort order as arguments and returns a list of dlgDocument objects.
// The fetchDocuments method constructs a URI for the Digital Library of Georgia API using the provided parameters.
// The fetchDocuments method sends an HTTP GET request to the Digital Library of Georgia API using the constructed URI.
// The fetchDocuments method parses the JSON response from the Digital Library of Georgia API and creates dlgDocument objects from the response.
// The fetchDocuments method returns a list of dlgDocument objects.
// The DlgDocumentService class uses the HttpClient class from the java.net.http package to send HTTP requests to the Digital Library of Georgia API.
// The DlgDocumentService class uses the JSONObject and JSONArray classes from the org.json package to parse JSON responses from the Digital Library of Georgia API.
// The DlgDocumentService class provides a fetchDocuments method that fetches documents from the Digital Library of Georgia API based on county name, page number, and sort order.
// The DlgDocumentService class provides a constructor that initializes an instance of the HttpClient class.
// The DlgDocumentService class provides a fetchDocuments method that sends an HTTP GET request to the Digital Library of Georgia API and returns a list of dlgDocument objects.
// The DlgDocumentService class constructs a URI for the Digital Library of Georgia API based on the provided county name, page number, and sort order.
// The DlgDocumentService class parses the JSON response from the Digital Library of Georgia API and creates dlgDocument objects from the response.
// The DlgDocumentService class uses the JSONObject and JSONArray classes to parse JSON responses from the Digital Library of Georgia API.

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DlgDocumentService {
    private HttpClient httpClient;

    public DlgDocumentService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public List<dlgDocument> fetchDocuments(String counties_facet, int page, String sort) throws Exception {
        String dlgURI = String.format(
                "https://dlg.usg.edu/records.json?f%%5Bcounties_facet%%5D%%5B%%5D=%s&page=%d&per_page=100&sort=%s",
                counties_facet, page, sort);
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(dlgURI))
                .GET()
                .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        String responseBody = getResponse.body().trim();
        JSONObject json = new JSONObject(responseBody);
        JSONArray records = json.getJSONObject("response").getJSONArray("docs");

        List<dlgDocument> documents = new ArrayList<>();
        // System.out.println(documents.size());
        for (int i = 0; i < records.length(); i++) {
            JSONObject record = records.getJSONObject(i);
            // System.out.println(record + "\n");
            // Assuming dlgDocument has a constructor that takes a JSONObject
            documents.add(new dlgDocument(record));
            // System.out.println("Record: " + record);
        }

        return documents;
    }
}