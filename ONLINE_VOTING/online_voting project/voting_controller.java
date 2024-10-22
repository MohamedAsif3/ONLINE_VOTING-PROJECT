package com.example.voting.controller;

import com.example.voting.model.User;
import com.example.voting.model.Vote;
import com.example.voting.service.UserService;
import com.example.voting.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voting")
public class VotingController {

    @Autowired
    private UserService userService;

    @Autowired
    private VoteService voteService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/vote")
    public Vote castVote(@RequestBody Vote vote) {
        return voteService.castVote(vote);
    }

    @GetMapping("/votes/{userId}")
    public ResponseEntity<List<Vote>> getVotesByUser(@PathVariable Long userId) {
        List<Vote> votes = voteService.getVotesByUserId(userId);
        return ResponseEntity.ok(votes);
    }
}
