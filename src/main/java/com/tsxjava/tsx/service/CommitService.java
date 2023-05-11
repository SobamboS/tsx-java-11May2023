package com.tsxjava.tsx.service;


import com.tsxjava.tsx.model.Commit;
import org.json.JSONObject;
import java.io.IOException;
import java.util.List;


public interface CommitService{
    List<JSONObject> listCommits(Commit commit) throws IOException, InterruptedException;



}

