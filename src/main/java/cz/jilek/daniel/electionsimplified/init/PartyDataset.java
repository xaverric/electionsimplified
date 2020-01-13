package cz.jilek.daniel.electionsimplified.init;

import cz.jilek.daniel.electionsimplified.election.dao.PartyDao;
import cz.jilek.daniel.electionsimplified.election.entity.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PartyDataset implements Dataset {

    private final PartyDao partyDao;

    @Autowired
    public PartyDataset(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    @Override
    public void load() {
        createParty("Strana 1");
        createParty("Strana 2");
        createParty("Strana 3");
        createParty("Strana 4");
        createParty("Strana 5");
        createParty("Strana 6");
        createParty("Strana 7");
        createParty("Strana 8");
        createParty("Strana 9");
        createParty("Strana 10");
        createParty("Strana 11");
    }

    private void createParty(String name){
        Party party = new Party();
        party.setPartyName(name);
        partyDao.save(party);
    }
}
