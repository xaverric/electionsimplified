package cz.jilek.daniel.electionsimplified;

import cz.jilek.daniel.electionsimplified.blockchain.BlockChainService;
import cz.jilek.daniel.electionsimplified.blockchain.block.factory.BlockFactory;
import cz.jilek.daniel.electionsimplified.election.VoteService;
import cz.jilek.daniel.electionsimplified.election.dao.CandidateDao;
import cz.jilek.daniel.electionsimplified.init.InitialDataSet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ElectionsimplifiedApplication {

    @Autowired
    private BlockChainService blockChainService;

    @Autowired
    private BlockFactory blockFactory;

    @Autowired
    private CandidateDao candidateDao;

    @Autowired
    private VoteService voteService;

    @Autowired
    private InitialDataSet initialDataSet;

    public static void main(String[] args) {
        SpringApplication.run(ElectionsimplifiedApplication.class, args);

    }

    @Bean
    public InitializingBean init(){
        initialDataSet.load();

        blockChainService.addBlock(blockFactory.getGenesisBlock());

        return null;
    }

}
