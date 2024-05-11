package com.chris.SpringBootRest;

import com.chris.SpringBootRest.Model.JobPost;
import com.chris.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();


    }
    @GetMapping("/jobPost/{postId}")

    public Optional<JobPost> getJob(@PathVariable("postId") int postId){
      return service.getJob(postId);

    }
    @PostMapping("jobPost")
    public void addJobPost(@RequestBody JobPost jobPost){
        service.addJobPost(jobPost);
    }


    @PutMapping("jobPost")
    public Optional<JobPost> updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());

    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }
    @GetMapping("load")
    public String loadData(){
        service.load();

return "Sucessfully Completed";
    }


    }


