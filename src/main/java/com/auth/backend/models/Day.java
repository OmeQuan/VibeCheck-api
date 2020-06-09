package com.auth.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String wake_up_time;

    private String to_sleep_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "day")
    private List<Activity> activities;

    public Day() {
    }

    public Day(Date date, String wake_up_time, String to_sleep_time, User user){
        this.date = date;
        this.wake_up_time = wake_up_time;
        this.to_sleep_time =  to_sleep_time;
        this.user = user;
    }

    public Day(Date date){
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String checkDate() {return date.toString();}

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setDate(Date date) {
        this.date = date;
    }


    public String getWake_up_time(){
        return wake_up_time;
    }

    public void setWake_up_time(String wake_up_time){
        this.wake_up_time = wake_up_time;
    }

    public String getTo_sleep_time(){
        return to_sleep_time;
    }

    public void setTo_sleep_time(String to_sleep_time){
        this.to_sleep_time = to_sleep_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


