package com.deepakameta.jobapp.controller;

import com.deepakameta.jobapp.Job;
import com.deepakameta.jobapp.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("jobs")
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<Job> getJobs() {
        return jobService.findAllJobs();
    }

    @PostMapping
    public String saveJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @PutMapping("/{jobId}")
    public String updateJobById(@PathVariable("jobId") Long jobId, @RequestBody Job job) {
        return jobService.updateJob(jobId, job);
    }

    @DeleteMapping("/{jobId}")
    public String deleteJobById(@PathVariable("jobId") Long jobId) {
        return jobService.deleteJobById(jobId);
    }
}
