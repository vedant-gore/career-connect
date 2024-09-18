package com.vedant.JobApp_Rest.service;

import com.vedant.JobApp_Rest.model.JobPost;
import com.vedant.JobApp_Rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId){
        return repo.findById(postId).orElse(new JobPost());
    }

    public void  updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(1, "Java Developer", "Must have good experience in core Java", 1, List.of("Java", "SpringBoot")),
                new JobPost(2, "Python Developer", "Must have good experience in Python", 1, List.of("Python", "Django")),
                new JobPost(3, "React Developer", "Must have good experience in FrontEnd", 1, List.of("JavaScript", "React")),
                new JobPost(4, "Angular Developer", "Must have good experience in FrontEnd", 1, List.of("JavaScript", "Angular")),
                new JobPost(5, "Node Developer", "Must have good experience in NodeJS", 1, List.of("JavasScript", "NodeJS"))
        ));

        repo.saveAll(jobs);
    }


    public List<JobPost> search(String keyword, String keyword1) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}


