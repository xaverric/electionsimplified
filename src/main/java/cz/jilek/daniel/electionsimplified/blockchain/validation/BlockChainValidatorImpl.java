package cz.jilek.daniel.electionsimplified.blockchain.validation;

import cz.jilek.daniel.electionsimplified.blockchain.BlockChainService;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockChainValidatorImpl implements BlockChainValidator {

    private final BlockChainService blockChainService;

    @Autowired
    public BlockChainValidatorImpl(BlockChainService blockChainService) {
        this.blockChainService = blockChainService;
    }

    @Override
    public boolean isFirstBlockValid() {
        return false;
    }

    @Override
    public boolean isNewBlockValid(Block newBlock) {
        return false;
    }

    @Override
    public boolean isBlockChainValid() {
        return false;
    }
}
