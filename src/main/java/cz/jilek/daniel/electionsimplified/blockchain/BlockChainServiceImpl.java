package cz.jilek.daniel.electionsimplified.blockchain;

import cz.jilek.daniel.electionsimplified.blockchain.block.dao.BlockDao;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import cz.jilek.daniel.electionsimplified.blockchain.block.utils.Miner;
import cz.jilek.daniel.electionsimplified.blockchain.config.Configuration;
import org.springframework.stereotype.Service;

@Service
public class BlockChainServiceImpl implements BlockChainService{

    private final BlockDao blockDao;
    private final Miner<Block> blockMiner;
    private final BlockChainInfo blockChainInfo;

    public BlockChainServiceImpl(BlockDao blockDao, Miner<Block> blockMiner, BlockChainInfo blockChainInfo) {
        this.blockDao = blockDao;
        this.blockMiner = blockMiner;
        this.blockChainInfo = blockChainInfo;
    }

    @Override
    public void addBlock(Block block) {
        blockMiner.mine(block, Configuration.DIFFICULTY);
        if (!blockChainInfo.isHashMinedByAnotherNode(block)){
            blockDao.saveAndFlush(block);
        } else {
        }
    }


}
