package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.Job;
import com.deepakameta.jobapp.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public String createJob(Job job) {
        return jobRepository.save(job).getName();
    }

    @Override
    public String updateJob(Long jobId, Job job) {
        boolean doesJobExist = jobRepository.existsById(jobId);
        if (doesJobExist) {
            job.setJobId(jobId);
            Job updatedJob = jobRepository.save(job);
            return updatedJob.toString();
        } else {
            return "Job Not Found";
        }
    }

    @Override
    public String deleteJobById(Long jobId) {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
            return "Job deleted successfully";
        } else {
            return "Job not found";
        }
    }
}
