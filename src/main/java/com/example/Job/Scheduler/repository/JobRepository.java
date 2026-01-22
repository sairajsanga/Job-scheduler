package com.example.Job.Scheduler.repository;


import com.example.Job.Scheduler.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Long> {

}
