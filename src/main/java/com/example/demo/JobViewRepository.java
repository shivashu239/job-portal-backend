package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobViewRepository extends JpaRepository<JobView, Integer> {

    List<JobView> findByJobId(int jobId);

    List<JobView> findByUserEmail(String userEmail);
}