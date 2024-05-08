import java.util.List;
// import java.net.URI;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse.BodyHandlers;
// import java.net.http.HttpClient; // Import the HttpClient class
// import java.net.http.HttpResponse; // Import the HttpResponse class

public class App {
    public static void main(String[] args) throws Exception {

        DlgDocumentService dlgDocumentService = new DlgDocumentService();
        List<dlgDocument> documents = dlgDocumentService.fetchDocuments("Houston", 2,
                "yyyy_mm_dd_sort+asc%2C+title_sort+asc");
        // System.out.println(documents.size());
        for (dlgDocument document : documents) {
            // System.out.println("is this before the blank");
            // System.out.println(document.getDcterms_title());
        }

        // dlgDocument doc = new dlgDocument(
        // "dlg_sgan_hhj1873-0101",
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null,
        // null);
    }

}
