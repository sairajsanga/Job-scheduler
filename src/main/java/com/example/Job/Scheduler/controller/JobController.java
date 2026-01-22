package com.example.Job.Scheduler.controller;


import com.example.Job.Scheduler.entity.Job;
import com.example.Job.Scheduler.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @GetMapping
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/schedule")
    public Map<String, Object> schedule() {
        return jobService.scheduleJobs();
    }
}
