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

    public dlgDocument(JSONObject record) {
        super(
                record.getString("id"),
                record.getString("title"),
                record.has("description") ? record.getJSONArray("description").toList().stream().map(Object::toString)
                        .collect(Collectors.toList()) : null,
                record.has("subject")
                        ? record.getJSONArray("subject").toList().stream().map(Object::toString)
                                .collect(Collectors.toList())
                        : null,
                record.has("type")
                        ? record.getJSONArray("type").toList().stream().map(Object::toString)
                                .collect(Collectors.toList())
                        : null);
        // ...
        this.collection_id = record.has("collection_id") ? record.getString("collection_id") : null;
        this.collection_title = record.has("collection_title") ? record.getString("collection_title") : null;
        this.dcterms_contributor = record.has("dcterms_contributor") ? record.getJSONArray("dcterms_contributor")
                .toList().stream().map(Object::toString).collect(Collectors.toList()) : null;
        this.dcterms_spatial = record.has("dcterms_spatial")
                ? record.getJSONArray("dcterms_spatial").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_creator = record.has("dcterms_creator")
                ? record.getJSONArray("dcterms_creator").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dc_date = record.has("dc_date")
                ? record.getJSONArray("dc_date").toList().stream().map(Object::toString).collect(Collectors.toList())
                : null;
        this.dc_format = record.has("dc_format")
                ? record.getJSONArray("dc_format").toList().stream().map(Object::toString).collect(Collectors.toList())
                : null;
        this.dcterms_identifier = record.has("dcterms_identifier")
                ? record.getJSONArray("dcterms_identifier").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_language = record.has("dcterms_language")
                ? record.getJSONArray("dcterms_language").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_publisher = record.has("dcterms_publisher")
                ? record.getJSONArray("dcterms_publisher").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dc_relation = record.has("dc_relation")
                ? record.getJSONArray("dc_relation").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dc_right = record.has("dc_right")
                ? record.getJSONArray("dc_right").toList().stream().map(Object::toString).collect(Collectors.toList())
                : null;
        this.dcterms_is_part_of = record.has("dcterms_is_part_of")
                ? record.getJSONArray("dcterms_is_part_of").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_title = record.has("dcterms_title")
                ? record.getJSONArray("dcterms_title").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_provenance = record.has("dcterms_provenance")
                ? record.getJSONArray("dcterms_provenance").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.edm_is_shown_by = record.has("edm_is_shown_by")
                ? record.getJSONArray("edm_is_shown_by").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.edm_is_shown_at = record.has("edm_is_shown_at")
                ? record.getJSONArray("edm_is_shown_at").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_temporal = record.has("dcterms_temporal")
                ? record.getJSONArray("dcterms_temporal").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_rights_holder = record.has("dcterms_rights_holder") ? record.getJSONArray("dcterms_rights_holder")
                .toList().stream().map(Object::toString).collect(Collectors.toList()) : null;
        this.dcterms_bibliographic_citation = record.has("dcterms_bibliographic_citation")
                ? record.getJSONArray("dcterms_bibliographic_citation").toList().stream().map(Object::toString).collect(
                        Collectors.toList())
                : null;
        this.dlg_local_right = record.has("dlg_local_right")
                ? record.getJSONArray("dlg_local_right").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_medium = record.has("dcterms_medium")
                ? record.getJSONArray("dcterms_medium").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dcterms_extent = record.has("dcterms_extent")
                ? record.getJSONArray("dcterms_extent").toList().stream().map(Object::toString)
                        .collect(Collectors.toList())
                : null;
        this.dlg_subject_personal = record.has("dlg_subject_personal") ? record.getJSONArray("dlg_subject_personal")
                .toList().stream().map(Object::toString).collect(Collectors.toList()) : null;
        this.iiif_manifest_url_ss = record.has("iiif_manifest_url_ss") ? record.getJSONArray("iiif_manifest_url_ss")
                .toList().stream().map(Object::toString).collect(Collectors.toList()) : null;
        this.fulltext = record.has("fulltext")
                ? record.getJSONArray("fulltext").toList().stream().map(Object::toString).collect(Collectors.toList())
                : null;
    }

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

    // toString method
    @Override
    public String toString() {
        return "dlgDocument{" +
                "collection_id='" + collection_id + '\'' +
                ", collection_title='" + collection_title + '\'' +
                ", dcterms_contributor=" + dcterms_contributor +
                ", dcterms_spatial=" + dcterms_spatial +
                ", dcterms_creator=" + dcterms_creator +
                ", dc_date=" + dc_date +
                ", dc_format=" + dc_format +
                ", dcterms_identifier=" + dcterms_identifier +
                ", dcterms_language=" + dcterms_language +
                ", dcterms_publisher=" + dcterms_publisher +
                ", dc_relation=" + dc_relation +
                ", dc_right=" + dc_right +
                ", dcterms_is_part_of=" + dcterms_is_part_of +
                ", dcterms_title=" + dcterms_title +
                ", dcterms_provenance=" + dcterms_provenance +
                ", edm_is_shown_by=" + edm_is_shown_by +
                ", edm_is_shown_at=" + edm_is_shown_at +
                ", dcterms_temporal=" + dcterms_temporal +
                ", dcterms_rights_holder=" + dcterms_rights_holder +
                ", dcterms_bibliographic_citation=" + dcterms_bibliographic_citation +
                ", dlg_local_right=" + dlg_local_right +
                ", dcterms_medium=" + dcterms_medium +
                ", dcterms_extent=" + dcterms_extent +
                ", dlg_subject_personal=" + dlg_subject_personal +
                ", iiif_manifest_url_ss=" + iiif_manifest_url_ss +
                ", fulltext=" + fulltext +
                '}';
    }
}
