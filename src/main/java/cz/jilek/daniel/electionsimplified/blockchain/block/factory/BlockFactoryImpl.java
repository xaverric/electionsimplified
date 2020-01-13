package cz.jilek.daniel.electionsimplified.blockchain.block.factory;

import cz.jilek.daniel.electionsimplified.blockchain.BlockChainInfo;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import cz.jilek.daniel.electionsimplified.blockchain.config.Configuration;
import cz.jilek.daniel.electionsimplified.election.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BlockFactoryImpl implements BlockFactory {

    private final BlockChainInfo blockChainInfo;

    @Autowired
    public BlockFactoryImpl(BlockChainInfo blockChainInfo) {
        this.blockChainInfo = blockChainInfo;
    }

    @Override
    public Block getGenesisBlock() {
        Block newBlock = new Block();
        newBlock.setTimestamp(LocalDateTime.now());
        newBlock.setData(Configuration.GENESIS_BLOCK);
        return newBlock;
    }

    @Override
    public Block getBlock(Vote data) {
        Block latestBlock = blockChainInfo.getLatestBlock();
        return getNewBlock(latestBlock, data);
    }

    private Block getNewBlock(Block latestBlock, Vote data) {
        Block newBlock = new Block();
        newBlock.setTimestamp(LocalDateTime.now());
        newBlock.setData(data.getCandidate().getUuid());
        newBlock.setPreviousHash(latestBlock.getHash());
        return newBlock;
    }
}
