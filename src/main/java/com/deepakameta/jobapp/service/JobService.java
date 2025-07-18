package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.Job;
import com.deepakameta.jobapp.utils.JobException;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    String createJob(Job job);

    String updateJob(Long jobId, Job job) throws JobException;

    String deleteJobById(Long jobId)  throws JobException;
}
