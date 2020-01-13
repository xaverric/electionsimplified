package cz.jilek.daniel.electionsimplified.election.service;

import cz.jilek.daniel.electionsimplified.election.dao.CandidateDao;
import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateDao candidateDao;

    public CandidateService(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    public List<Candidate> getByParty(Long partyId) {
        return candidateDao.findByParty(partyId);
    }

    public List<Candidate> getAll() {
        return candidateDao.findAll();
    }

    public Candidate getById(String id) {
        return candidateDao.findById(id).get();
    }
}
