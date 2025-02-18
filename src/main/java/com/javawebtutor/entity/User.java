package com.javawebtutor.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Example")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    public User() {}

    public User( String uName, String cBy, Date cDate ) {
        this.username = uName;
        this.createdBy = cBy;
        this.createdDate = cDate;
    }

    public int getUserId() { return id; }
    public void setUserId(int userId) {
        this.id = userId;
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
        return "User [id=" + this.id + ", username=" + this.username + ", created by=" + this.createdBy + ", created date=" + this.createdDate + "]";
    }
}