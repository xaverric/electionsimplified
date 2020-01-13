package cz.jilek.daniel.electionsimplified.election.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "party")
public class Party implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String partyName;

    @OneToMany(mappedBy = "party")
    private List<Candidate> candidates;
}
