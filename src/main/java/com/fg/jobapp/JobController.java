package com.fg.jobapp;


import com.fg.jobapp.model.JobPost;
import com.fg.jobapp.service.JobService;
import org.eclipse.tags.shaded.org.apache.bcel.generic.PUSH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//Controller talkin to service, service is talking to repo
@Controller
public class JobController {

    @Autowired
    private JobService service;


    @GetMapping({"/","/home"})
    public String home(){

        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){

        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "succes";
    }


    @GetMapping("viewAllJobs")
    public String viewJobs(Model model){

        List<JobPost> jobs = service.getAllJobs();
        model.addAttribute("jobPosts",jobs);
        return "viewAllJobs";
    }

}
