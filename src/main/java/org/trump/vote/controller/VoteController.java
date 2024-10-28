package org.trump.vote.controller;

import com.cinaval.storage.model.BucketItem;
import com.cinaval.storage.service.IStorageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.entity.VoteCountsBy30Minutes;
import org.trump.vote.entity.VoteCountsByDays;
import org.trump.vote.entity.VoteRecord;
import org.trump.vote.service.IVoteService;

import java.util.List;
import java.util.Optional;

import static org.trump.vote.constant.ApiConstant.API_V1;

@RestController
@RequestMapping(API_V1 + "/vote")
public class VoteController {

    @Autowired
    private IVoteService voteService;

    @Autowired
    private IStorageService storageService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传多个文件", notes = "upload")
    public ResponseEntity<BucketItem> uploadVote(@ApiParam(value = "上传文件", required = true) @RequestParam("file") MultipartFile file) {
        Optional<BucketItem> result = storageService.upload(file);
        result.ifPresent(bucketItem -> {
            voteService.vote("", bucketItem.getUrl());
        });
        return ResponseEntity.of(result);
    }

    @PostMapping()
    @ApiOperation(value = "投票", notes = "投票")
    public void vote(@RequestParam("userId") String userId, @RequestParam(value = "file", required = false) MultipartFile file) {
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


    @GetMapping(value = "/latestVoters", produces = "application/json")
    @ApiOperation(value = "最新投票者", notes = "最新投票者")
    public ResponseEntity<List<VoteRecord>> latestVoters() {
        List<VoteRecord> latestRecord = voteService.getLatestRecord(10);
        return ResponseEntity.ok(latestRecord);
    }

    @GetMapping(value = "/totalVoters", produces = "application/json")
    @ApiOperation(value = "总投票人数", notes = "总投票人数")
    public ResponseEntity<Long> totalVoters() {
        Optional<Long> total = voteService.getTotalVotes();
        return ResponseEntity.of(total);
    }

    @GetMapping(value = "/voteCountsByMonth", produces = "application/json")
    @ApiOperation(value = "查询最近30天内每天的投票人数", notes = "投票人数")
    public List<VoteCountsByDays> getVoteCountsByMonth() {
        return voteService.getVoteCountsByMonth();
    }

    @GetMapping(value = "/trending", produces = "application/json")
    @ApiOperation(value = "查询最近7天，每30分钟的投票数。", notes = "投票趋势")
    public ResponseEntity<List<VoteCountsBy30Minutes>> trending() {
        List<VoteCountsBy30Minutes> trendingCount = voteService.trending();
        return ResponseEntity.ok(trendingCount);
    }
}
