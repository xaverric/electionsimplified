package cz.jilek.daniel.electionsimplified.election.dao;

import cz.jilek.daniel.electionsimplified.election.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyDao extends JpaRepository<Party, Long> {

    Party findByPartyName(String name);
}
