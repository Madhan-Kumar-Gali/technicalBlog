package technicalblog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SuppressWarnings("unused")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "date")
    private Date date;

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unused")
    public String getBody() {
        return body;
    }

    @SuppressWarnings("unused")
    public void setBody(String body) {
        this.body = body;
    }

    @SuppressWarnings("unused")
    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }
}
