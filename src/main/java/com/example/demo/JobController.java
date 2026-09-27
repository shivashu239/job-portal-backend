package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;
    private final JobViewService jobViewService;

    public JobController(
            JobService jobService,
            JobViewService jobViewService) {

        this.jobService = jobService;
        this.jobViewService = jobViewService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(
            @PathVariable int id,
            Authentication authentication) {

        Job job = jobService.getJobById(id);

        jobViewService.recordView(
                id,
                authentication.getName()
        );

        return job;
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam String title) {
        return jobService.searchJobsByTitle(title);
    }

    @GetMapping("/search/location")
    public List<Job> searchJobsByLocation(
            @RequestParam String location) {

        return jobService.searchJobsByLocation(location);
    }

    @GetMapping("/search/advanced")
    public List<Job> searchJobsByTitleAndLocation(
            @RequestParam String title,
            @RequestParam String location) {

        return jobService.searchJobsByTitleAndLocation(
                title,
                location);
    }

    @PostMapping
    public Job addJob(
            @Valid @RequestBody Job job) {

        return jobService.addJob(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(
            @PathVariable int id,
            @Valid @RequestBody Job job) {

        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {

        boolean deleted = jobService.deleteJob(id);

        if (deleted) {
            return ResponseEntity.ok("Job deleted successfully");
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Job not found");
    }
}