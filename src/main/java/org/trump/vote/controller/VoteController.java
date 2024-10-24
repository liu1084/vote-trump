package org.trump.vote.controller;

import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.trump.vote.entity.VoteRecord;

import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private OAuth10aService twitterService;


    @GetMapping("/index")
    public String index() {
        return "home";
    }

    @GetMapping(value = "/latestVoters")
    public List<VoteRecord> latestVoters() {
        return null;
    }

    @GetMapping(value = "/totalVoters")
    public long totalVoters() {
        return 0L;
    }

    @GetMapping(value = "/votesByMonth")
    public List<Long> votesByMonth() {
        return null;
    }

    @GetMapping(value = "/trending")
    public List<Long> trending() {
        return null;
    }
}
