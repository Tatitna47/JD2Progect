package ru.mail.kovgantatyana.repository.model;

import org.hibernate.annotations.GenericGenerator;
import ru.mail.kovgantatyana.repository.model.News;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class FileEntity implements Serializable {

    private static final long serialVersionUID = -3336063086925435411L;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "user")})
    @Column
    private int id;
    @Column
    private String fileName;
    @Column
    private String location;
    @OneToOne
    @PrimaryKeyJoinColumn
    private News news;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
