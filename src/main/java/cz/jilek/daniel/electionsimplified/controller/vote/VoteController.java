package cz.jilek.daniel.electionsimplified.controller.vote;

import cz.jilek.daniel.electionsimplified.election.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "vote")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public void addVote(@RequestBody VoteDto voteDto) {
        voteService.addVote(voteDto.getUuid());
    }
}
