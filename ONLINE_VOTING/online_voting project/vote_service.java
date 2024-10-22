package com.example.voting.service;

import com.example.voting.model.Vote;
import com.example.voting.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote castVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesByUserId(Long userId) {
        return voteRepository.findByUserId(userId);
    }
}
