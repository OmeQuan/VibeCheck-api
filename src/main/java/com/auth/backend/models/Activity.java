package com.auth.backend.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private int duration_time;

    private String remark;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    public Activity() {
    }

    public Activity(Type type, int duration_time, String remark, Day day) {
        this.type = type;
        this.duration_time = duration_time;
        this.remark = remark;
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getDuration_time() {
        return duration_time;
    }

    public void setDuration_time(int duration_time) {
        this.duration_time = duration_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
