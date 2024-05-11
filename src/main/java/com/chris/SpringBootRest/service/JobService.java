package com.chris.SpringBootRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.chris.SpringBootRest.Model.JobPost;
import com.chris.SpringBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobService {
    @Autowired
    private JobRepo repo;


    public List<JobPost> getAllJobs() {
        return repo.findAll();


    }

    public void addJobPost(JobPost jobPost) {
        repo.save(jobPost);

    }


    public Optional<JobPost> getJob(int postId) {
        return repo.findById(postId);
    }

    public JobPost updateJob(JobPost jobPost) {

        return repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }


    public void load() {

        List<JobPost> jobs = new ArrayList<>();


        // Java Developer Job Post
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));


        jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis")));

        // Network Engineer Job Post
        jobs.add(new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5, List.of("Networking", "Cisco", "Routing", "Switching")));

        // Mobile App Developer Job Post
        jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App")));

        repo.saveAll(jobs);
    }



}
