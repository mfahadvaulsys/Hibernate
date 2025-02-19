package com.javawebtutor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "joining_date")
    private Date joiningDate;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor() {}

    public Instructor(String firstName, String lastName, String email, Date joiningDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.joiningDate = joiningDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    @Override
    public String toString() {
        return "Instructor [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + ", email=" + email + ", joining_date=" + joiningDate + "]";
    }
}