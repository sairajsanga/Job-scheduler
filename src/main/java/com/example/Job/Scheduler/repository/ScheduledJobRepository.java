package com.example.Job.Scheduler.repository;

import com.example.Job.Scheduler.entity.ScheduledJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledJobRepository extends JpaRepository<ScheduledJob, Long> {
}
