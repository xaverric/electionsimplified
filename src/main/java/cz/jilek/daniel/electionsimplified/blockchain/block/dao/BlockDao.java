package cz.jilek.daniel.electionsimplified.blockchain.block.dao;

import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockDao extends JpaRepository<Block, Long> {

    @Query(nativeQuery = true, value = "select * from Block b order by b.id desc limit 1")
    Block findLatestBlock();

}
