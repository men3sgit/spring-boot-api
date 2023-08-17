package com.menes.models;

import jakarta.persistence.*;

import java.nio.file.Path;
@Entity
@Table
public class PhotoDetails {
    @Id
    @SequenceGenerator(
            name = "photo_details_sequence",
            sequenceName = "photo_details_sequence",
            allocationSize = 2,
            initialValue = 5
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "photo_details_sequence"
    )
    private Long id;
    private String path;
    private String description;
    private String title;

    public PhotoDetails() {
    }

    public PhotoDetails(String path, String description, String title) {
        this.path = path;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PhotoDetails{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
