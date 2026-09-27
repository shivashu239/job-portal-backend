package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job-views")
public class JobViewController {

    private final JobViewService jobViewService;

    public JobViewController(JobViewService jobViewService) {
        this.jobViewService = jobViewService;
    }

    @GetMapping("/job/{jobId}")
    public List<JobView> getViewsByJobId(
            @PathVariable int jobId) {

        return jobViewService.getViewsByJobId(jobId);
    }
}