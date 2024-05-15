package com.chris.SpringBootRest.repo;

import com.chris.SpringBootRest.Model.JobPost;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {













}