package cz.jilek.daniel.electionsimplified.blockchain;

import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;

public interface BlockChainService {

    void addBlock(Block block);

}
