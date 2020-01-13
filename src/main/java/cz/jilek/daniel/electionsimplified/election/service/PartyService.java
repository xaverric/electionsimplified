package cz.jilek.daniel.electionsimplified.election.service;

import cz.jilek.daniel.electionsimplified.election.dao.PartyDao;
import cz.jilek.daniel.electionsimplified.election.entity.Party;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    private final PartyDao partyDao;

    public PartyService(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    public Party getByPartyName(String partyName) {
        return partyDao.findByPartyName(partyName);
    }

    public List<Party> getAll() {
        return partyDao.findAll();
    }

    public Party getById(Long id) {
        return partyDao.findById(id).get();
    }

}
