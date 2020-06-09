package com.auth.backend.Payload.request;

import com.auth.backend.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalTime;

public class DayRequest {
    @NotBlank
    private Date date;

    private LocalTime wake_up_time;

    private LocalTime to_sleep_time;

    private User user;

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime")
    public LocalTime getWake_up_time() {return wake_up_time;}
    public void setWake_up_time(LocalTime wake_up_time) {this.wake_up_time = wake_up_time;}

    @Type(type="org.joda.time.contrib.hibernate.PersistentLocalTimeAsTime")
    public LocalTime getTo_sleep_time() {return to_sleep_time;}
    public void setTo_sleep_time(LocalTime to_sleep_time) {this.to_sleep_time = to_sleep_time;}

    public User getUser() {return user;}
    public void setUser(User user){ this.user = user;}
}
