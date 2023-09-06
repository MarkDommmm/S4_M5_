package ra.model.dto;

import org.springframework.web.multipart.MultipartFile;
import ra.model.entity.Category;

import java.sql.Date;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private MultipartFile image;
    private Date creationDate;
    private Category category;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, MultipartFile image, Date creationDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.creationDate = new Date(System.currentTimeMillis());
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
