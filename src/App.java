import java.util.List;
// import java.net.URI;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse.BodyHandlers;
// import java.net.http.HttpClient; // Import the HttpClient class
// import java.net.http.HttpResponse; // Import the HttpResponse class

public class App {
    public static void main(String[] args) throws Exception {
        // String dlgURI =
        // "https://dlg.usg.edu/records.json?f%5Bcounties_facet%5D%5B%5D=Houston&page=2&per_page=100&sort=yyyy_mm_dd_sort+asc%2C+title_sort+asc";
        // HttpRequest getRequest = HttpRequest.newBuilder()
        // .uri(new URI(dlgURI))
        // .GET()
        // .build();
        // HttpClient httpClient = HttpClient.newHttpClient();

        // HttpResponse<String> getResponse = httpClient.send(getRequest,
        // BodyHandlers.ofString());
        // System.out.println(getResponse.body());

        DlgDocumentService dlgDocumentService = new DlgDocumentService();
        List<dlgDocument> documents = dlgDocumentService.fetchDocuments("Houston", 2,
                "yyyy_mm_dd_sort+asc%2C+title_sort+asc");
        // System.out.println(documents.size());
        for (dlgDocument document : documents) {
            // System.out.println("is this before the blank");
            // System.out.println(document.getDcterms_title());
        }
    }
}
