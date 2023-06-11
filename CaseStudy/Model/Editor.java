package CaseStudy.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Editor {
    private long id;
    private String category;
    private String title;
    private String author;
    private String content;
    private Date createAt;
    private long view;

    public Editor() {
    }

    public Editor(long id, String category, String title, String author, String content, Date createAt, long view) {
        this.id = id;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public void setView(long view) {
        this.view = view;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s;%s;%s;%s;%s;%s;%s\n", this.id, this.category, this.title, this.author, this.content, simpleDateFormat.format(this.createAt), this.getView());
    }
}
