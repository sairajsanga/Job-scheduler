package com.example.Job.Scheduler.service;


import com.example.Job.Scheduler.entity.Job;
import com.example.Job.Scheduler.entity.ScheduledJob;
import com.example.Job.Scheduler.repository.JobRepository;
import com.example.Job.Scheduler.repository.ScheduledJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ScheduledJobRepository scheduledJobRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Map<String, Object> scheduleJobs() {

        List<Job> jobs = jobRepository.findAll();

        jobs.sort((a, b) -> b.getProfit() - a.getProfit());

        int maxDeadline = jobs.stream()
                .mapToInt(Job::getDeadline)
                .max().orElse(0);

        boolean[] slots = new boolean[maxDeadline + 1];

        List<ScheduledJob> result = new ArrayList<>();
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = job.getDeadline(); j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result.add(new ScheduledJob(null, job.getJobName(), j, job.getProfit()));
                    totalProfit += job.getProfit();
                    break;
                }
            }
        }

        scheduledJobRepository.deleteAll();
        scheduledJobRepository.saveAll(result);

        Map<String, Object> response = new HashMap<>();
        response.put("scheduledJobs", result);
        response.put("totalProfit", totalProfit);

        return response;
    }
}
