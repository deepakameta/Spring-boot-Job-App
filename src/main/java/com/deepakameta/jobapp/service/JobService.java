package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.Job;
import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    String createJob(Job job);

    String updateJob(Long jobId, Job job);

    String deleteJobById(Long jobId);
}
