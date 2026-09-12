package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Positive(message = "Job ID must be greater than 0")
    private int jobId;
    @NotBlank(message = "Applicant name is required")
    private String applicantName;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Applicant email is required")
    private String applicantEmail;
    @NotBlank(message = "Status is required")
    @Pattern(
    regexp = "APPLIED|SHORTLISTED|REJECTED|SELECTED",
    message = "Status must be APPLIED, SHORTLISTED, REJECTED or SELECTED")
    private String status;

    public JobApplication() {
    }

    public JobApplication(int jobId, String applicantName,
                          String applicantEmail, String status) {
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getJobId() {
        return jobId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}