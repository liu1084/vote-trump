package org.trump.vote.controller;

import com.cinaval.storage.model.BucketItem;
import com.cinaval.storage.service.IStorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.entity.VoteRecord;
import org.trump.vote.service.IVoteService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.trump.vote.constant.ApiConstant.API_V1;

@Controller
@RequestMapping(API_V1 + "/vote")
public class VoteController {

    @Autowired
    private IVoteService voteService;

    @Autowired
    private IStorageService storageService;

    @PostMapping()
    @ApiOperation(value = "投票", notes = "投票")
    public void vote(@RequestParam("userId") String userId,
                     @RequestParam(value = "file", required = false) MultipartFile file) {
        TwitterUser user = voteService.getCachedTwitterUser(userId);
        // 检查用户是否已经投票等操作
        boolean isVoted = voteService.isVoted(user.getUserId());

        if (!isVoted) {
            voteService.vote(user.getUserId(), user.getProfileImageUrl());
        }

        if (file == null) {
            voteService.vote(user.getUserId(), "");
            return;
        }

        String filename = file.getOriginalFilename();
        if (filename != null) {
            Optional<BucketItem> item = storageService.upload(file);

            item.ifPresent(bucketItem -> voteService.vote(user.getUserId(), bucketItem.getUrl()));
        }
    }


    @GetMapping("/home")
    @ApiOperation(value = "主页", notes = "主页")
    public String index() {
        return "home";
    }

    @GetMapping(value = "/latestVoters")
    @ApiOperation(value = "最新投票者", notes = "最新投票者")
    public List<VoteRecord> latestVoters() {
        return voteService.getLatestRecord(10);
    }

    @GetMapping(value = "/totalVoters")
    @ApiOperation(value = "总投票人数", notes = "总投票人数")
    public long totalVoters() {
        return voteService.getTotalVotes();
    }

    @GetMapping(value = "/voteCountsByDays")
    @ApiOperation(value = "每天的投票人数", notes = "投票人数")
    public List<Long> voteCountsBetweenDays(@RequestParam("start") Date start,
                                            @RequestParam("end") Date end) {
        return voteService.getVoteCountsByDays(start, end);
    }

    @GetMapping(value = "/trending")
    @ApiOperation(value = "投票趋势", notes = "投票趋势")
    public List<Long> trending(@RequestParam("start") Date start,
                               @RequestParam("end") Date end) {
        return voteService.getVoteCountsBetweenDays(start, end);
    }
}
