package cz.jilek.daniel.electionsimplified.election;

import cz.jilek.daniel.electionsimplified.election.entity.Candidate;
import lombok.Data;

import java.io.Serializable;

@Data
public class Vote implements Serializable {

    private Candidate candidate;
}
