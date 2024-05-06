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
        System.out.println(documents.size());
        for (int i = 0; i < records.length(); i++) {
            JSONObject record = records.getJSONObject(i);
            System.out.println(record + "\n");
            // Assuming dlgDocument has a constructor that takes a JSONObject
            // documents.add(new dlgDocument(record));
            // System.out.println("Record: " + record);
        }

        return documents;
    }
}