package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository applicationRepository;
    private final JobRepository jobRepository;

    public JobApplicationService(
            JobApplicationRepository applicationRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
    }

    public List<JobApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    public JobApplication getApplicationById(int id) {

        return applicationRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Application not found"));
    }

    public JobApplication addApplication(JobApplication application) {

        if (!jobRepository.existsById(application.getJobId())) {
            throw new IllegalArgumentException("Job not found");
        }

        return applicationRepository.save(application);
    }

    public JobApplication updateApplication(
            int id,
            JobApplication application) {

        JobApplication existingApplication =
                applicationRepository.findById(id)
                        .orElse(null);

        if (existingApplication == null) {
            throw new IllegalArgumentException("Application not found");
        }

        if (!jobRepository.existsById(application.getJobId())) {
            throw new IllegalArgumentException("Job not found");
        }

        existingApplication.setJobId(application.getJobId());
        existingApplication.setApplicantName(
                application.getApplicantName());
        existingApplication.setApplicantEmail(
                application.getApplicantEmail());
        existingApplication.setStatus(
                application.getStatus());

        return applicationRepository.save(existingApplication);
    }

    public boolean deleteApplication(int id) {

        if (!applicationRepository.existsById(id)) {
            return false;
        }

        applicationRepository.deleteById(id);
        return true;
    }

    public List<JobApplication> getApplicationsByJobId(int jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    public List<JobApplication> getApplicationsByEmail(String email) {
        return applicationRepository.findByApplicantEmail(email);
    }
}