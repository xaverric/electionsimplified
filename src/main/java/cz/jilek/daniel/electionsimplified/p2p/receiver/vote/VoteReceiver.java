package cz.jilek.daniel.electionsimplified.p2p.receiver.vote;

import cz.jilek.daniel.electionsimplified.blockchain.BlockChainService;
import cz.jilek.daniel.electionsimplified.blockchain.block.factory.BlockFactory;
import cz.jilek.daniel.electionsimplified.election.Vote;
import cz.jilek.daniel.electionsimplified.election.dao.CandidateDao;
import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import org.jgroups.Message;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class VoteReceiver implements Receiver {

    private final BlockChainService blockChainService;
    private final BlockFactory blockFactory;
    private final CandidateDao candidateDao;

    public VoteReceiver(BlockChainService blockChainService, BlockFactory blockFactory, CandidateDao candidateDao) {
        this.blockChainService = blockChainService;
        this.blockFactory = blockFactory;
        this.candidateDao = candidateDao;
    }

    @Override
    public void receiveMessage(Message message) {
        String candidateUuid = message.getObject();
        Vote vote = createVote(candidateUuid);
        startMining(vote);
    }

    private Vote createVote(String candidateUuid){
        Vote vote = new Vote();
        vote.setCandidate(fetchCandidate(candidateUuid));
        return vote;
    }

    private Candidate fetchCandidate(String candidateUuid) {
        return candidateDao.findById(candidateUuid).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    private void startMining(Vote vote) {
        blockChainService.addBlock(blockFactory.getBlock(vote));
    }
}
