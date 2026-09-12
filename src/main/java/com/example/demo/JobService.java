package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> searchJobsByTitle(String title) {
        return jobRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Job> searchJobsByLocation(String location) {
        return jobRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Job> searchJobsByTitleAndLocation(
            String title, String location) {

        return jobRepository
                .findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(
                        title, location);
    }

    public Job getJobById(int id) {

        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Job not found"));
    }

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(int id, Job job) {

        Job existingJob = jobRepository.findById(id)
                .orElse(null);

        if (existingJob == null) {
            throw new IllegalArgumentException("Job not found");
        }

        existingJob.setTitle(job.getTitle());
        existingJob.setCompany(job.getCompany());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());

        return jobRepository.save(existingJob);
    }

    public boolean deleteJob(int id) {

        if (!jobRepository.existsById(id)) {
            return false;
        }

        jobRepository.deleteById(id);
        return true;
    }
}