package cz.jilek.daniel.electionsimplified.controller.party;

import cz.jilek.daniel.electionsimplified.election.entity.Party;
import cz.jilek.daniel.electionsimplified.election.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "party")
public class PartyController {

    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    public List<Party> getAllParties() {
        return partyService.getAll();
    }
}
