import java.util.List;

public class Document {
    private String id; // like dlg_vang_hou090-82
    private String title; // like [Photograph of Henry Tucker Gilbert, Houston County, Georgia]
    private List<String> description; // like Houston County. Henry Tucker Gilbert.
    private List<String> subject; // like Portraits--Georgia--Houston County
    private List<String> type; // like collection, dataset, image, interactive resource, moving image, sound,
                               // still image, text

    public Document(String id, String title, List<String> description, List<String> subject, List<String> type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.subject = subject;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
