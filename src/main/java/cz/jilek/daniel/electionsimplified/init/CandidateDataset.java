package cz.jilek.daniel.electionsimplified.init;

import cz.jilek.daniel.electionsimplified.election.dao.CandidateDao;
import cz.jilek.daniel.electionsimplified.election.dao.PartyDao;
import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import cz.jilek.daniel.electionsimplified.election.entity.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Order(2)
public class CandidateDataset implements Dataset {

    private final CandidateDao candidateDao;
    private final PartyDao partyDao;
    private final Random random;

    @Autowired
    public CandidateDataset(CandidateDao candidateDao, PartyDao partyDao) {
        this.candidateDao = candidateDao;
        this.partyDao = partyDao;
        this.random = new Random();
    }

    @Override
    public void load() {
        createCandidate("kandidat 1", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 2", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 3", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 4", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 5", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 6", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 7", partyDao.findByPartyName("Strana 1"));
        createCandidate("kandidat 8", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 9", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 10", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 11", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 12", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 13", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 14", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 15", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 16", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 17", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 18", partyDao.findByPartyName("Strana 2"));
        createCandidate("kandidat 19", partyDao.findByPartyName("Strana 3"));
        createCandidate("kandidat 20", partyDao.findByPartyName("Strana 3"));
        createCandidate("kandidat 21", partyDao.findByPartyName("Strana 4"));
        createCandidate("kandidat 22", partyDao.findByPartyName("Strana 4"));
        createCandidate("kandidat 23", partyDao.findByPartyName("Strana 4"));
        createCandidate("kandidat 24", partyDao.findByPartyName("Strana 4"));
        createCandidate("kandidat 25", partyDao.findByPartyName("Strana 4"));
        createCandidate("kandidat 26", partyDao.findByPartyName("Strana 5"));
        createCandidate("kandidat 27", partyDao.findByPartyName("Strana 5"));
        createCandidate("kandidat 28", partyDao.findByPartyName("Strana 5"));
        createCandidate("kandidat 29", partyDao.findByPartyName("Strana 6"));
        createCandidate("kandidat 30", partyDao.findByPartyName("Strana 6"));
        createCandidate("kandidat 31", partyDao.findByPartyName("Strana 6"));
        createCandidate("kandidat 32", partyDao.findByPartyName("Strana 6"));
        createCandidate("kandidat 33", partyDao.findByPartyName("Strana 6"));
        createCandidate("kandidat 34", partyDao.findByPartyName("Strana 6"));
        createCandidate("kandidat 35", partyDao.findByPartyName("Strana 7"));
        createCandidate("kandidat 36", partyDao.findByPartyName("Strana 8"));
        createCandidate("kandidat 37", partyDao.findByPartyName("Strana 8"));
        createCandidate("kandidat 38", partyDao.findByPartyName("Strana 8"));
        createCandidate("kandidat 39", partyDao.findByPartyName("Strana 8"));
        createCandidate("kandidat 40", partyDao.findByPartyName("Strana 9"));
        createCandidate("kandidat 41", partyDao.findByPartyName("Strana 9"));
        createCandidate("kandidat 42", partyDao.findByPartyName("Strana 10"));
        createCandidate("kandidat 43", partyDao.findByPartyName("Strana 10"));
        createCandidate("kandidat 44", partyDao.findByPartyName("Strana 11"));
        createCandidate("kandidat 45", partyDao.findByPartyName("Strana 11"));
        createCandidate("kandidat 46", partyDao.findByPartyName("Strana 11"));

    }

    private void createCandidate(String name, Party party){
        Candidate candidate = new Candidate();
        candidate.setName(name);
        candidate.setParty(party);
        candidate.setHexColor(String.format("#%06x", random.nextInt(0xffffff + 1)));
        candidateDao.save(candidate);
    }
}
