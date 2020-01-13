package cz.jilek.daniel.electionsimplified.blockchain.block.utils;

public interface HashCalculator<T> {

    String calculate(T data);
}
