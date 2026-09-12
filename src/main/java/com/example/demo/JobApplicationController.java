package com.example.demo;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationService applicationService;

    public JobApplicationController(JobApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable int id) {
        return applicationService.getApplicationById(id);
    }

    @PostMapping
    public JobApplication addApplication(@Valid @RequestBody JobApplication application) {
        return applicationService.addApplication(application);
    }

    @PutMapping("/{id}")
    public JobApplication updateApplication(
        @PathVariable int id,
        @Valid @RequestBody JobApplication application)  {
            return applicationService.updateApplication(id, application);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteApplication(@PathVariable int id) {

    boolean deleted = applicationService.deleteApplication(id);

    if (deleted) {
        return ResponseEntity.ok("Application deleted successfully");
    }

    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Application not found");
    }

    @GetMapping("/job/{jobId}")
    public List<JobApplication> getApplicationsByJobId(@PathVariable int jobId) {
        return applicationService.getApplicationsByJobId(jobId);
    }

    @GetMapping("/applicant")
    public List<JobApplication> getApplicationsByEmail(@RequestParam String email) {
        return applicationService.getApplicationsByEmail(email);
    }
}