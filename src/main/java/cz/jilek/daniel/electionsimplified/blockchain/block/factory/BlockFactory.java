package cz.jilek.daniel.electionsimplified.blockchain.block.factory;

import cz.jilek.daniel.electionsimplified.election.Vote;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;

public interface BlockFactory {

    Block getGenesisBlock();

    Block getBlock(Vote data);
}
