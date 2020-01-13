package cz.jilek.daniel.electionsimplified.controller.candidate;

import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import cz.jilek.daniel.electionsimplified.election.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "candidate")
public class CandidateController {

    private final CandidateService candidateCrudService;

    public CandidateController(CandidateService candidateCrudService) {
        this.candidateCrudService = candidateCrudService;
    }

    @GetMapping
    public List<Candidate> getCandidatesByParty(@RequestParam Long partyId){
        return candidateCrudService.getByParty(partyId);
    }
}
