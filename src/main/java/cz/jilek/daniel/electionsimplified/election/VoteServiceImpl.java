package cz.jilek.daniel.electionsimplified.election;

import cz.jilek.daniel.electionsimplified.election.dao.CandidateDao;
import cz.jilek.daniel.electionsimplified.p2p.sender.VoteSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private final CandidateDao candidateDao;
    private final VoteSender voteSender;

    @Autowired
    public VoteServiceImpl(CandidateDao candidateDao, VoteSender voteSender) {
        this.candidateDao = candidateDao;
        this.voteSender = voteSender;
    }

    @Override
    public void addVote(String candidateUuid) {
        try {
            voteSender.sendVoteToAllNodes(candidateUuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
