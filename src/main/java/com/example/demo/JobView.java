package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class JobView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int jobId;

    private String userEmail;

    private LocalDateTime viewedAt;

    public JobView() {
    }

    public JobView(int jobId, String userEmail, LocalDateTime viewedAt) {
        this.jobId = jobId;
        this.userEmail = userEmail;
        this.viewedAt = viewedAt;
    }

    public int getId() {
        return id;
    }

    public int getJobId() {
        return jobId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
    }
}