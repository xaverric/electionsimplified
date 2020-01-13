package cz.jilek.daniel.electionsimplified.election.service;

import cz.jilek.daniel.electionsimplified.blockchain.BlockChainInfo;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import cz.jilek.daniel.electionsimplified.controller.result.ResultDto;
import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import cz.jilek.daniel.electionsimplified.election.entity.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    private final PartyService partyService;
    private final BlockChainInfo blockChainInfo;

    @Autowired
    public ResultService(PartyService partyService, BlockChainInfo blockChainInfo) {
        this.partyService = partyService;
        this.blockChainInfo = blockChainInfo;
    }

    public List<ResultDto> getResults() {
        List<ResultDto> resultsList = new ArrayList<>();
        List<Block> blockChain = blockChainInfo.getBlockChain();


        partyService.getAll().forEach(party -> party.getCandidates().forEach(candidate -> {
            Long votesCount = blockChain.stream().filter(block -> block.getData().equals(candidate.getUuid())).count();
            resultsList.add(createResultDto(party, candidate, votesCount));
        }));

        return resultsList;
    }

    private ResultDto createResultDto(Party party, Candidate candidate, Long votesCount) {
        ResultDto resultDto = new ResultDto();
        resultDto.setPartyName(party.getPartyName());
        resultDto.setCandidateColor(candidate.getHexColor());
        resultDto.setCandidateName(candidate.getName());
        resultDto.setVotes(votesCount);
        return resultDto;
    }

}
