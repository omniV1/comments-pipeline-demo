package edu.shadsluiter.comments.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppComment {
    private int id;
    private String author;
    private String content;
    private LocalDateTime createdAt;

    public AppComment(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFormattedDate() {
        return createdAt.format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a"));
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
