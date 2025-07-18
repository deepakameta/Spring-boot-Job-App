package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.Job;
import com.deepakameta.jobapp.repository.JobRepository;
import com.deepakameta.jobapp.utils.JobException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String updateJob(Long jobId, Job job) throws JobException {
        boolean doesJobExist = jobRepository.existsById(jobId);
        if (doesJobExist) {
            job.setJobId(jobId);
            Job updatedJob = jobRepository.save(job);
            return updatedJob.toString();
        } else {
            throw new JobException("Job with id: " + jobId + " does not exist");
        }
    }

    @Override
    public String deleteJobById(Long jobId) throws JobException {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
            return "Job deleted successfully";
        } else {
            throw new JobException("Job with id: " + jobId + " does not exist");
        }
    }
}
