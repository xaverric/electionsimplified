package cz.jilek.daniel.electionsimplified.blockchain.block.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="block")
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime timestamp;
    private String previousHash;

    private String data;

    private String hash;
    private Integer nonce = 0;

    public void increaseNonce(){
        this.nonce++;
    }

}
