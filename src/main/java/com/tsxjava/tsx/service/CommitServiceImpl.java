package com.tsxjava.tsx.service;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import com.tsxjava.tsx.model.Commit;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
@Service
@Component
public  class CommitServiceImpl implements CommitService{
    private static final Logger logger =(Logger) LoggerFactory.getLogger(CommitServiceImpl.class);


   @Override
   public List<JSONObject> listCommits(Commit commit1) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/repos/" + commit1.getUsername() + "/dummy-github-events/commits"))
                .GET()
                .header("Accept", "application/vnd.github.v3+json")
                .header("Authorization", "token " + commit1.getToken())
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to retrieve commits from Github API: " + response.body());
        }

        JSONArray jsonArray = new JSONArray(response.body());  // converts response body to JSONArray
        List<JSONObject> commits = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            commits.add(jsonArray.getJSONObject(i));
        }
        logger.info("Retrieved {} commits", commits.size());
        commits.forEach(commit -> logger.info("Commit: {}", commit));

        return commits;
    }
}
