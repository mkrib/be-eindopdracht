package nl.novi.beeindopdracht.dtos;

import jakarta.validation.constraints.NotNull;
import nl.novi.beeindopdracht.entities.User;

import java.util.Date;

public class ReviewRequestDto {
    @NotNull(message = "The name of the reviewer is required")
    private String fullName;
    @NotNull(message = "The text of the review is required")
    private String content;
    private Date issueDate;
    private User user;

    public ReviewRequestDto(String fullName, String content, Date issueDate, User user) {
        this.fullName = fullName;
        this.content = content;
        this.issueDate = issueDate;
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
