package com.javawebtutor.entity;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Example")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    public User() {}

    public User( int id, String uName, String cBy, Date cDate) {
        this.userId = id;
        this.username = uName;
        this.createdBy = cBy;
        this.createdDate = cDate;
        System.out.println("Date: " + this.createdDate);
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User [id=" + userId + ", username=" + username + ", created by=" + createdBy + ", created date=" + createdDate + "]";
    }
}