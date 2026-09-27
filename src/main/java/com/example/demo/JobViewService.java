package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobViewService {

    private final JobViewRepository jobViewRepository;

    public JobViewService(JobViewRepository jobViewRepository) {
        this.jobViewRepository = jobViewRepository;
    }

    public JobView recordView(int jobId, String userEmail) {

        JobView jobView = new JobView(
                jobId,
                userEmail,
                LocalDateTime.now()
        );

        return jobViewRepository.save(jobView);
    }

    public List<JobView> getViewsByJobId(int jobId) {
        return jobViewRepository.findByJobId(jobId);
    }

    public List<JobView> getViewsByUserEmail(String userEmail) {
        return jobViewRepository.findByUserEmail(userEmail);
    }
}