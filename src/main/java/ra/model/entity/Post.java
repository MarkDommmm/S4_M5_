package ra.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "posts")
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String image;

    private Date creationDate ;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Post() {
    }


    public Post(Long id, String title, String content, String image, Date creationDate, Category category) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
