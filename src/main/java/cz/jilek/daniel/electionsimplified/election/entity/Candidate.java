package cz.jilek.daniel.electionsimplified.election.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="candidate")
public class Candidate implements Serializable {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
    private String uuid;

    private String name;

    private String hexColor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;
}
