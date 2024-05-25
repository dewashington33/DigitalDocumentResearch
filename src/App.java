import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        DlgDocumentService dlgDocumentService = new DlgDocumentService();

        List<dlgDocument> documents = dlgDocumentService.fetchDocuments("Houston", 2,
                "yyyy_mm_dd_sort+asc%2C+title_sort+asc");
        // System.out.println(documents.size());
        for (dlgDocument document : documents) {
            // System.out.println("is this before the blank");
            // System.out.println("Title: " + document.getTitle());
            // System.out.println("Contributor: " + document.getDcterms_contributor());
            // System.out.println("Spatial: " + document.getDcterms_spatial());
            System.out.println(document.toString());
        }

    }

}
