package nl.novi.beeindopdracht.dtos;

import jakarta.validation.constraints.NotNull;
import nl.novi.beeindopdracht.entities.User;

public class BlogpostRequestDto {
    @NotNull(message = "The title of the blog is required")
    private String title;
    @NotNull(message = "The content of the blog is required")
    private String content;
    @NotNull(message = "The preview text of the blog is required")
    private String previewText;
    private User user;

    public BlogpostRequestDto() {
    }

    public BlogpostRequestDto(String title, String content, String previewText, User user) {
        this.title = title;
        this.content = content;
        this.previewText = previewText;
        this.user = user;
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
