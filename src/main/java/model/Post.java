package model;

import java.time.LocalDateTime;

public class Post {
    private int id;
    private String title;
    private String shortContent;
    private String longContent;
    private LocalDateTime pulishDate;
    private String image;
    private Category category;
    private int views;

    public Post() {
    }

    public Post(int id,String title, String shortContent, String longContent, String image, Category category) {
        this.id=id;
        this.title = title;
        this.shortContent = shortContent;
        this.longContent = longContent;
        this.image = image;
        this.category = category;
    }

    public Post(String title, String shortContent, String longContent, String image, Category category) {
        this.title = title;
        this.shortContent = shortContent;
        this.longContent = longContent;
        this.image = image;
        this.category = category;
    }

    public Post(int id, String title, String shortContent, String longContent, LocalDateTime pushlishDate, String image, Category category, int views) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.longContent = longContent;
        this.pulishDate = pushlishDate;
        this.image = image;
        this.category = category;
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getLongContent() {
        return longContent;
    }

    public void setLongContent(String longContent) {
        this.longContent = longContent;
    }

    public LocalDateTime getPulishDate() {
        return pulishDate;
    }

    public void setPulishDate(LocalDateTime pulishDate) {
        this.pulishDate = pulishDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", longContent='" + longContent + '\'' +
                ", pulishDate=" + pulishDate +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", views=" + views +
                '}';
    }
}

