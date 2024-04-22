package nl.novi.beeindopdracht.dtos;

import nl.novi.beeindopdracht.entities.User;

import java.util.Date;

public class ReviewDto {
    private Long id;
    private String fullName;
    private String content;
    private Date issueDate;
    private User user;

    public ReviewDto() {
    }

    public ReviewDto(Long id, String fullName, String content, Date issueDate, User user) {
        this.id = id;
        this.fullName = fullName;
        this.content = content;
        this.issueDate = issueDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
