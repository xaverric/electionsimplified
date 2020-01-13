package cz.jilek.daniel.electionsimplified.blockchain.validation;

import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;

public interface BlockChainValidator {

    boolean isFirstBlockValid();

    boolean isNewBlockValid(Block newBlock);

    boolean isBlockChainValid();
}
