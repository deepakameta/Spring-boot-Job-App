package com.deepakameta.jobapp.service;

import com.deepakameta.jobapp.model.Job;
import com.deepakameta.jobapp.utils.JobException;

import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    String createJob(Job job);

    String updateJob(long jobId, Job job) throws JobException;

    String deleteJobById(long jobId)  throws JobException;
}
