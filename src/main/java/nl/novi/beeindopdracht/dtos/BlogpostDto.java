package nl.novi.beeindopdracht.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import nl.novi.beeindopdracht.entities.User;

public class BlogpostDto {
    private Long id;
    private String title;
    private String content;
    private String previewText;
    private User user;

    public BlogpostDto() {
    }

    public BlogpostDto(Long id, String title, String content, String previewText, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.previewText = previewText;
        this.user = user;
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

    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
