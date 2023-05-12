package com.tsxjava.tsx.controller;


import com.tsxjava.tsx.model.Commit;
import com.tsxjava.tsx.service.CommitService;
import org.json.JSONObject;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.List;
@RestController
@RequestMapping("commits")
public class CommitController{
    private static final Logger logger =(Logger) LoggerFactory.getLogger(CommitController.class);

   private final CommitService commitService;

    @Autowired
    public CommitController(CommitService commitService) {
        this.commitService = commitService;
    }

    @GetMapping
    public ResponseEntity<List<JSONObject>> getCommits(Commit commit) {
        try {
            List<JSONObject> commits = commitService.listCommits(commit);
            logger.info("Retrieved {} commits", commits.size());

            for (JSONObject commitObject : commits) {
                logger.info("Commit: {}", commitObject.toString());
            }

            return ResponseEntity.ok(commits);
        } catch (IOException | InterruptedException e) {
            logger.error("Error retrieving commits: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}




