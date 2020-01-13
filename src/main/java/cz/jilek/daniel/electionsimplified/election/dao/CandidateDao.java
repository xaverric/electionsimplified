package cz.jilek.daniel.electionsimplified.election.dao;

import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, String> {

    Candidate findByName(String name);

    @Query("select c from Candidate c where c.party.id = ?1")
    List<Candidate> findByParty(Long id);
}
