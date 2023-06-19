package CaseStudy.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Editor {
    private long id;
    private ECategory eCategory;
    private String title;
    private String author;
    private String content;
    private Date createAt;
    private long view;

    public Editor() {
    }

    public Editor(long id, ECategory eCategory, long view, String title, String author, String content, Date createAt) {
        this.id = id;
        this.eCategory = eCategory;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createAt = createAt;
        this.view = view;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ECategory geteCategory() {
        return eCategory;
    }

    public void seteCategory(ECategory eCategory) {
        this.eCategory = eCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public long getView() {
        return view;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s;%s;%s;%s;%s;%s;%s\n", this.id, this.eCategory.getName(), this.view, this.title, this.author, this.content, simpleDateFormat.format(this.createAt));
    }
}
