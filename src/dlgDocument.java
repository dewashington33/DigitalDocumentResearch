// This class extends the Document class and adds additional fields specific to the Digital Library of Georgia
// (DLG) data model.

// The constructor can take a JSONObject as an argument and extract the values for each field from the object.

// The class is used to represent individual documents retrieved from the DLG API.
// The fields in the class correspond to the fields in the JSON response from the DLG API.
// The class is used in the App class to display information about the documents retrieved from the DLG API.
// The DlgDocumentService class is used to fetch documents from the DLG API and convert them into instances of the dlgDocument class.
// The DlgDocumentService class uses the HttpClient class to make HTTP requests to the DLG API and retrieve JSON responses.
// The fetchDocuments method in the DlgDocumentService class constructs the URL for the API request, sends the request, and processes the response.
// The method then extracts the individual document records from the JSON response and creates instances of the dlgDocument class for each record.
// The method returns a list of dlgDocument instances that can be used to display information about the documents.
// The App class uses the DlgDocumentService class to fetch documents from the DLG API and display information about the documents.
// The App class creates an instance of the DlgDocumentService class and calls the fetchDocuments method to retrieve documents.
// The App class then iterates over the list of documents and prints out information about each document, such as the title, contributor, and spatial information.
// The App class demonstrates how to use the DlgDocumentService class to interact
// with the DLG API and retrieve information about documents from the Digital Library of Georgia.
// The App class can be run as a standalone Java application to fetch and display information about documents from the DLG API.
// The App class can be extended to include additional functionality for interacting with the DLG API and processing the document data.
// The DlgDocumentService class provides a convenient way to fetch documents from the DLG API and convert them into instances of the dlgDocument class.
// The dlgDocument class encapsulates the data model for individual documents from the DLG API and provides methods for accessing and displaying the document information.
// The dlgDocument class can be extended to include additional fields and methods for working with the document data from the DLG API.
// The DlgDocumentService class can be extended to include additional methods for fetching and processing documents from the DLG API.
// The App class provides an example of how to use the DlgDocumentService class to fetch and display information about documents from the DLG API.
// The App class can be modified and extended to include additional functionality for working with the DLG API and processing the document data.

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.util.stream.Collectors;

public class dlgDocument extends Document {

    private String collection_id;
    private String collection_title;
    private List<String> dcterms_contributor;
    private List<String> dcterms_spatial;
    private List<String> dcterms_creator;
    private List<String> dc_date;
    private List<String> dc_format;
    private List<String> dcterms_identifier;
    private List<String> dcterms_language;
    private List<String> dcterms_publisher;
    private List<String> dc_relation;
    private List<String> dc_right;
    private List<String> dcterms_is_part_of;
    private List<String> dcterms_title;
    private List<String> dcterms_provenance;
    private List<String> edm_is_shown_by;
    private List<String> edm_is_shown_at;
    private List<String> dcterms_temporal;
    private List<String> dcterms_rights_holder;
    private List<String> dcterms_bibliographic_citation;
    private List<String> dlg_local_right;
    private List<String> dcterms_medium;
    private List<String> dcterms_extent;
    private List<String> dlg_subject_personal;
    private List<String> iiif_manifest_url_ss;
    private List<String> fulltext;

    public dlgDocument(
            String id,
            String title,
            List<String> description,
            List<String> subject,
            List<String> type,
            String collection_id,
            String collection_title,
            List<String> dcterms_contributor,
            List<String> dcterms_spatial,
            List<String> dcterms_creator,
            List<String> dc_date,
            List<String> dc_format,
            List<String> dcterms_identifier,
            List<String> dcterms_language,
            List<String> dcterms_publisher,
            List<String> dc_relation,
            List<String> dc_right,
            List<String> dcterms_is_part_of,
            List<String> dcterms_title,
            List<String> dcterms_provenance,
            List<String> edm_is_shown_by,
            List<String> edm_is_shown_at,
            List<String> dcterms_temporal,
            List<String> dcterms_rights_holder,
            List<String> dcterms_bibliographic_citation,
            List<String> dlg_local_right,
            List<String> dcterms_medium,
            List<String> dcterms_extent,
            List<String> dlg_subject_personal,
            List<String> iiif_manifest_url_ss,
            List<String> fulltext) {
        super(id, title, description, subject, type);
        this.collection_id = collection_id;
        this.collection_title = collection_title;
        this.dcterms_contributor = dcterms_contributor;
        this.dcterms_spatial = dcterms_spatial;
        this.dcterms_creator = dcterms_creator;
        this.dc_date = dc_date;
        this.dc_format = dc_format;
        this.dcterms_identifier = dcterms_identifier;
        this.dcterms_language = dcterms_language;
        this.dcterms_publisher = dcterms_publisher;
        this.dc_relation = dc_relation;
        this.dc_right = dc_right;
        this.dcterms_is_part_of = dcterms_is_part_of;
        this.dcterms_title = dcterms_title;
        this.dcterms_provenance = dcterms_provenance;
        this.edm_is_shown_by = edm_is_shown_by;
        this.edm_is_shown_at = edm_is_shown_at;
        this.dcterms_temporal = dcterms_temporal;
        this.dcterms_rights_holder = dcterms_rights_holder;
        this.dcterms_bibliographic_citation = dcterms_bibliographic_citation;
        this.dlg_local_right = dlg_local_right;
        this.dcterms_medium = dcterms_medium;
        this.dcterms_extent = dcterms_extent;
        this.dlg_subject_personal = dlg_subject_personal;
        this.iiif_manifest_url_ss = iiif_manifest_url_ss;
        this.fulltext = fulltext;

    }

    private static List<String> getJsonArrayAsList(JSONObject record, String key) {
        if (record.optJSONArray(key) != null) {
            return record.getJSONArray(key).toList().stream().map(Object::toString).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    // Overloaded Constructor that takes a JSONObject as an argument and extracts
    // the values for each field from the object.

    public dlgDocument(JSONObject record) {
        super(
                record.getString("id"),
                record.getString("title"),
                getJsonArrayAsList(record, "description"),
                getJsonArrayAsList(record, "subject"),
                getJsonArrayAsList(record, "type"));
        this.collection_id = record.has("collection_id") ? record.getString("collection_id") : null;
        this.collection_title = record.has("collection_title") ? record.getString("collection_title") : null;
        this.dcterms_contributor = getJsonArrayAsList(record, "dcterms_contributor");
        this.dcterms_spatial = getJsonArrayAsList(record, "dcterms_spatial");
        this.dcterms_creator = getJsonArrayAsList(record, "dcterms_creator");
        this.dc_date = getJsonArrayAsList(record, "dc_date");
        this.dc_format = getJsonArrayAsList(record, "dc_format");
        this.dcterms_identifier = getJsonArrayAsList(record, "dcterms_identifier");
        this.dcterms_language = getJsonArrayAsList(record, "dcterms_language");
        this.dcterms_publisher = getJsonArrayAsList(record, "dcterms_publisher");
        this.dc_relation = getJsonArrayAsList(record, "dc_relation");
        this.dc_right = getJsonArrayAsList(record, "dc_right");
        this.dcterms_is_part_of = getJsonArrayAsList(record, "dcterms_is_part_of");
        this.dcterms_title = getJsonArrayAsList(record, "dcterms_title");
        this.dcterms_provenance = getJsonArrayAsList(record, "dcterms_provenance");
        this.edm_is_shown_by = getJsonArrayAsList(record, "edm_is_shown_by");
        this.edm_is_shown_at = getJsonArrayAsList(record, "edm_is_shown_at");
        this.dcterms_temporal = getJsonArrayAsList(record, "dcterms_temporal");
        this.dcterms_rights_holder = getJsonArrayAsList(record, "dcterms_rights_holder");
        this.dcterms_bibliographic_citation = getJsonArrayAsList(record, "dcterms_bibliographic_citation");
        this.dlg_local_right = getJsonArrayAsList(record, "dlg_local_right");
        this.dcterms_medium = getJsonArrayAsList(record, "dcterms_medium");
        this.dcterms_extent = getJsonArrayAsList(record, "dcterms_extent");
        this.dlg_subject_personal = getJsonArrayAsList(record, "dlg_subject_personal");
        this.iiif_manifest_url_ss = getJsonArrayAsList(record, "iiif_manifest_url_ss");
        this.fulltext = getJsonArrayAsList(record, "fulltext");
    }

    // public dlgDocument(JSONObject record) {
    // super(
    // record.getString("id"),
    // record.getString("title"),
    // record.has("description") ?
    // record.getJSONArray("description").toList().stream().map(Object::toString)
    // .collect(Collectors.toList()) : null,
    // record.has("subject")
    // ? record.getJSONArray("subject").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : null,
    // record.has("type")
    // ? record.getJSONArray("type").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : null);
    // // ...
    // this.collection_id = record.has("collection_id") ?
    // record.getString("collection_id") : null;
    // this.collection_title = record.has("collection_title") ?
    // record.getString("collection_title") : null;
    // this.dcterms_contributor = record.optJSONArray("dcterms_contributor") != null
    // ?
    // record.getJSONArray("dcterms_contributor").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_spatial = record.optJSONArray("dcterms_spatial") != null
    // ?
    // record.getJSONArray("dcterms_spatial").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_creator = record.optJSONArray("dcterms_creator") != null
    // ?
    // record.getJSONArray("dcterms_creator").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dc_date = record.optJSONArray("dc_date") != null
    // ?
    // record.getJSONArray("dc_date").toList().stream().map(Object::toString).collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dc_format = record.optJSONArray("dc_format") != null
    // ?
    // record.getJSONArray("dc_format").toList().stream().map(Object::toString).collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_identifier = record.optJSONArray("dcterms_identifier") != null
    // ?
    // record.getJSONArray("dcterms_identifier").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_language = record.optJSONArray("dcterms_language") != null
    // ?
    // record.getJSONArray("dcterms_language").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_publisher = record.optJSONArray("dcterms_publisher") != null
    // ?
    // record.getJSONArray("dcterms_publisher").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dc_relation = record.optJSONArray("dc_relation") != null
    // ? record.getJSONArray("dc_relation").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dc_right = record.optJSONArray("dc_right") != null
    // ?
    // record.getJSONArray("dc_right").toList().stream().map(Object::toString).collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_is_part_of = record.optJSONArray("dcterms_is_part_of") != null
    // ?
    // record.getJSONArray("dcterms_is_part_of").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_title = record.optJSONArray("dcterms_title") != null
    // ?
    // record.getJSONArray("dcterms_title").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_provenance = record.optJSONArray("dcterms_provenance") != null
    // ?
    // record.getJSONArray("dcterms_provenance").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.edm_is_shown_by = record.optJSONArray("edm_is_shown_by") != null
    // ?
    // record.getJSONArray("edm_is_shown_by").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.edm_is_shown_at = record.optJSONArray("edm_is_shown_at") != null
    // ?
    // record.getJSONArray("edm_is_shown_at").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_temporal = record.optJSONArray("dcterms_temporal") != null
    // ?
    // record.getJSONArray("dcterms_temporal").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_rights_holder = record.optJSONArray("dcterms_rights_holder") !=
    // null
    // ?
    // record.getJSONArray("dcterms_rights_holder").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_bibliographic_citation =
    // record.optJSONArray("dcterms_bibliographic_citation") != null
    // ?
    // record.getJSONArray("dcterms_bibliographic_citation").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dlg_local_right = record.optJSONArray("dlg_local_right") != null
    // ?
    // record.getJSONArray("dlg_local_right").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_medium = record.optJSONArray("dcterms_medium") != null
    // ?
    // record.getJSONArray("dcterms_medium").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dcterms_extent = record.optJSONArray("dcterms_extent") != null
    // ?
    // record.getJSONArray("dcterms_extent").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.dlg_subject_personal = record.optJSONArray("dlg_subject_personal") !=
    // null
    // ?
    // record.getJSONArray("dlg_subject_personal").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.iiif_manifest_url_ss = record.optJSONArray("iiif_manifest_url_ss") !=
    // null
    // ?
    // record.getJSONArray("iiif_manifest_url_ss").toList().stream().map(Object::toString)
    // .collect(Collectors.toList())
    // : new ArrayList<>();
    // this.fulltext = record.optJSONArray("fulltext") != null
    // ?
    // record.getJSONArray("fulltext").toList().stream().map(Object::toString).collect(Collectors.toList())
    // : new ArrayList<>();
    // }

    // Generate getters and setters for each field

    public String getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(String collection_id) {
        this.collection_id = collection_id;
    }

    public String getCollection_title() {
        return collection_title;
    }

    public void setCollection_title(String collection_title) {
        this.collection_title = collection_title;
    }

    public List<String> getDcterms_contributor() {
        return dcterms_contributor;
    }

    public void setDcterms_contributor(List<String> dcterms_contributor) {
        this.dcterms_contributor = dcterms_contributor;
    }

    public List<String> getDcterms_spatial() {
        return dcterms_spatial;
    }

    public void setDcterms_spatial(List<String> dcterms_spatial) {
        this.dcterms_spatial = dcterms_spatial;
    }

    public List<String> getDcterms_creator() {
        return dcterms_creator;
    }

    public void setDcterms_creator(List<String> dcterms_creator) {
        this.dcterms_creator = dcterms_creator;
    }

    public List<String> getDc_date() {
        return dc_date;
    }

    public void setDc_date(List<String> dc_date) {
        this.dc_date = dc_date;
    }

    public List<String> getDc_format() {
        return dc_format;
    }

    public void setDc_format(List<String> dc_format) {
        this.dc_format = dc_format;
    }

    public List<String> getDcterms_identifier() {
        return dcterms_identifier;
    }

    public void setDcterms_identifier(List<String> dcterms_identifier) {
        this.dcterms_identifier = dcterms_identifier;
    }

    public List<String> getDcterms_language() {
        return dcterms_language;
    }

    public void setDcterms_language(List<String> dcterms_language) {
        this.dcterms_language = dcterms_language;
    }

    public List<String> getDcterms_publisher() {
        return dcterms_publisher;
    }

    public void setDcterms_publisher(List<String> dcterms_publisher) {
        this.dcterms_publisher = dcterms_publisher;
    }

    public List<String> getDc_relation() {
        return dc_relation;
    }

    public void setDc_relation(List<String> dc_relation) {
        this.dc_relation = dc_relation;
    }

    public List<String> getDc_right() {
        return dc_right;
    }

    public void setDc_right(List<String> dc_right) {
        this.dc_right = dc_right;
    }

    public List<String> getDcterms_is_part_of() {
        return dcterms_is_part_of;
    }

    public void setDcterms_is_part_of(List<String> dcterms_is_part_of) {
        this.dcterms_is_part_of = dcterms_is_part_of;
    }

    public List<String> getDcterms_title() {
        return dcterms_title;
    }

    public void setDcterms_title(List<String> dcterms_title) {
        this.dcterms_title = dcterms_title;
    }

    public List<String> getDcterms_provenance() {
        return dcterms_provenance;
    }

    public void setDcterms_provenance(List<String> dcterms_provenance) {
        this.dcterms_provenance = dcterms_provenance;
    }

    public List<String> getEdm_is_shown_by() {
        return edm_is_shown_by;
    }

    public void setEdm_is_shown_by(List<String> edm_is_shown_by) {
        this.edm_is_shown_by = edm_is_shown_by;
    }

    public List<String> getEdm_is_shown_at() {
        return edm_is_shown_at;
    }

    public void setEdm_is_shown_at(List<String> edm_is_shown_at) {
        this.edm_is_shown_at = edm_is_shown_at;
    }

    public List<String> getDcterms_temporal() {
        return dcterms_temporal;
    }

    public void setDcterms_temporal(List<String> dcterms_temporal) {
        this.dcterms_temporal = dcterms_temporal;
    }

    public List<String> getDcterms_rights_holder() {
        return dcterms_rights_holder;
    }

    public void setDcterms_rights_holder(List<String> dcterms_rights_holder) {
        this.dcterms_rights_holder = dcterms_rights_holder;
    }

    public List<String> getDcterms_bibliographic_citation() {
        return dcterms_bibliographic_citation;
    }

    public void setDcterms_bibliographic_citation(List<String> dcterms_bibliographic_citation) {
        this.dcterms_bibliographic_citation = dcterms_bibliographic_citation;
    }

    public List<String> getDlg_local_right() {
        return dlg_local_right;
    }

    public void setDlg_local_right(List<String> dlg_local_right) {
        this.dlg_local_right = dlg_local_right;
    }

    public List<String> getDcterms_medium() {
        return dcterms_medium;
    }

    public void setDcterms_medium(List<String> dcterms_medium) {
        this.dcterms_medium = dcterms_medium;
    }

    public List<String> getDcterms_extent() {
        return dcterms_extent;
    }

    public void setDcterms_extent(List<String> dcterms_extent) {
        this.dcterms_extent = dcterms_extent;
    }

    public List<String> getDlg_subject_personal() {
        return dlg_subject_personal;
    }

    public void setDlg_subject_personal(List<String> dlg_subject_personal) {
        this.dlg_subject_personal = dlg_subject_personal;
    }

    public List<String> getIiif_manifest_url_ss() {
        return iiif_manifest_url_ss;
    }

    public void setIiif_manifest_url_ss(List<String> iiif_manifest_url_ss) {
        this.iiif_manifest_url_ss = iiif_manifest_url_ss;
    }

    public List<String> getFulltext() {
        return fulltext;
    }

    public void setFulltext(List<String> fulltext) {
        this.fulltext = fulltext;
    }

    // // toString method
    // @Override
    // public String toString() {
    // return "dlgDocument{" +
    // "title='" + getTitle() + '\'' +
    // "collection_id='" + collection_id + '\'' +
    // ", collection_title='" + collection_title + '\'' +
    // ", dcterms_contributor=" + dcterms_contributor +
    // ", dcterms_spatial=" + dcterms_spatial +
    // ", dcterms_creator=" + dcterms_creator +
    // ", dc_date=" + dc_date +
    // ", dc_format=" + dc_format +
    // ", dcterms_identifier=" + dcterms_identifier +
    // ", dcterms_language=" + dcterms_language +
    // ", dcterms_publisher=" + dcterms_publisher +
    // ", dc_relation=" + dc_relation +
    // ", dc_right=" + dc_right +
    // ", dcterms_is_part_of=" + dcterms_is_part_of +
    // ", dcterms_title=" + dcterms_title +
    // ", dcterms_provenance=" + dcterms_provenance +
    // ", edm_is_shown_by=" + edm_is_shown_by +
    // ", edm_is_shown_at=" + edm_is_shown_at +
    // ", dcterms_temporal=" + dcterms_temporal +
    // ", dcterms_rights_holder=" + dcterms_rights_holder +
    // ", dcterms_bibliographic_citation=" + dcterms_bibliographic_citation +
    // ", dlg_local_right=" + dlg_local_right +
    // ", dcterms_medium=" + dcterms_medium +
    // ", dcterms_extent=" + dcterms_extent +
    // ", dlg_subject_personal=" + dlg_subject_personal +
    // ", iiif_manifest_url_ss=" + iiif_manifest_url_ss +
    // ", fulltext=" + fulltext +
    // '}';
    // }
    // toString method
    @Override
    public String toString() {
        return "id=" + getId() + "\n" +
                "title=" + getTitle() + "\n" +
                "description=" + getDescription() + "\n" +
                "subject=" + getSubject() + "\n" +
                "type=" + getType() + "\n" +
                "collection_id=" + collection_id + "\n" +
                "collection_title='" + collection_title + "\n" +
                "dcterms_contributor=" + dcterms_contributor + "\n" +
                "dcterms_spatial=" + dcterms_spatial + "\n" +
                "dcterms_creator=" + dcterms_creator + "\n" +
                "dc_date=" + dc_date + "\n" +
                "dc_format=" + dc_format + "\n" +
                "dcterms_identifier=" + dcterms_identifier + "\n" +
                "dcterms_language=" + dcterms_language + "\n" +
                "dcterms_publisher=" + dcterms_publisher + "\n" +
                "dc_relation=" + dc_relation + "\n" +
                "dc_right=" + dc_right + "\n" +
                "dcterms_is_part_of=" + dcterms_is_part_of + "\n" +
                "dcterms_title=" + dcterms_title + "\n" +
                "dcterms_provenance=" + dcterms_provenance + "\n" +
                "edm_is_shown_by=" + edm_is_shown_by + "\n" +
                "edm_is_shown_at=" + edm_is_shown_at + "\n" +
                "dcterms_temporal=" + dcterms_temporal + "\n" +
                "dcterms_rights_holder=" + dcterms_rights_holder + "\n" +
                "dcterms_bibliographic_citation=" + dcterms_bibliographic_citation + "\n" +
                "dlg_local_right=" + dlg_local_right + "\n" +
                "dcterms_medium=" + dcterms_medium + "\n" +
                "dcterms_extent=" + dcterms_extent + "\n" +
                "dlg_subject_personal=" + dlg_subject_personal + "\n" +
                "iiif_manifest_url_ss=" + iiif_manifest_url_ss + "\n" +
                "fulltext=" + fulltext + "\n";

    }
}
