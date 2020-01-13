package cz.jilek.daniel.electionsimplified.blockchain;

import cz.jilek.daniel.electionsimplified.blockchain.block.dao.BlockDao;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import cz.jilek.daniel.electionsimplified.blockchain.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockChainInfoImpl implements BlockChainInfo {

    private BlockDao blockDao;

    @Autowired
    public BlockChainInfoImpl(BlockDao blockDao) {
        this.blockDao = blockDao;
    }

    @Override
    public List<Block> getBlockChain() {
        return blockDao.findAll();
    }

    @Override
    public boolean isHashMinedByAnotherNode(Block block) {
        return !isGenesisBlock(block) && !block.getPreviousHash().equals(getLatestBlock().getHash());
    }

    @Override
    public Block getLatestBlock() {
        return blockDao.findLatestBlock();
    }

    @Override
    public boolean isGenesisBlock(Block block) {
        return block.getData().equals(Configuration.GENESIS_BLOCK);
    }


}
