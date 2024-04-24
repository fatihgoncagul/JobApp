package com.fg.jobapp.service;

import com.fg.jobapp.model.JobPost;
import com.fg.jobapp.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

   @Autowired
    JobRepo repo;

    public void addJob(JobPost jobPost){ //we want to add jobPost, we are accepting with parameter
        repo.addJob(jobPost);
    }
    //job controller needs to pass the jobPost to the service object in the handleForm method
    //from service it will go to repo and repo is acccepting it,
    //this kind of objects are called DTOs aka data transfer objects

    public List<JobPost> getAllJobs(){

        return repo.getAllJobs();
    }


}
