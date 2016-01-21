package infinite.loop.psychnotes.common.model;


import com.andtinder.model.CardModel;

public class PsychNote extends CardModel {
    public Long id;
    public String title;
    public String category;
    public String image_url;
    public String brief;
    public String description;
    public String more;

    public PsychNote() {
        this.id = id;
    }

    public PsychNote(String brief) {
        super();
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "PsychNote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", image_url='" + image_url + '\'' +
                ", brief='" + brief + '\'' +
                ", description='" + description + '\'' +
                ", more='" + more + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }
}
