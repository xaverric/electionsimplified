package cz.jilek.daniel.electionsimplified.blockchain.block.utils;

import cz.jilek.daniel.electionsimplified.blockchain.BlockChainInfo;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import cz.jilek.daniel.electionsimplified.blockchain.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockMiner implements Miner<Block> {

    private final BlockHashCalculator blockHashCalculator;
    private final BlockChainInfo blockChainInfo;

    @Autowired
    public BlockMiner(BlockHashCalculator blockHashCalculator, BlockChainInfo blockChainInfo) {
        this.blockHashCalculator = blockHashCalculator;
        this.blockChainInfo = blockChainInfo;
    }

    @Override
    public void mine(Block block, int difficulty) {
        String hash = mineHash(block, difficulty);
        String leadingZeros = getLeadingZerosByDifficulty(difficulty);

        int counter = 0;
        while (!isHashMined(hash, leadingZeros)){
            block.increaseNonce();
            hash = mineHash(block, difficulty);

            if (counter == 100000){
                if (blockChainInfo.isHashMinedByAnotherNode(block)){
                    return;
                }
                counter = 0;
            }

            counter++;
        }
    }

    private boolean isHashMined(String hash, String leadingZeros){
        return hash.equals(leadingZeros);
    }

    /**
     *
     * @param block
     * @param difficulty
     * @return hash substring by given {@link Integer} difficulty
     */
    private String mineHash(Block block, int difficulty) {
        String hash = blockHashCalculator.calculate(block);
        block.setHash(hash);

        return hash.substring(0, difficulty);
    }

    private String getLeadingZerosByDifficulty(int difficulty) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < difficulty; i++){
            sb.append(Configuration.LEADING_ZERO);
        }
        return sb.toString();
    }
}
