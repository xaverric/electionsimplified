package cz.jilek.daniel.electionsimplified.blockchain.block.utils;

public interface Miner<T> {

    void mine(T data, int difficulty);
}
