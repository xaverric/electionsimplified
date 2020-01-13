package cz.jilek.daniel.electionsimplified.blockchain;

import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;

import java.util.List;

public interface BlockChainInfo {

    List<Block> getBlockChain();

    boolean isHashMinedByAnotherNode(Block block);

    Block getLatestBlock();

    boolean isGenesisBlock(Block block);
}
