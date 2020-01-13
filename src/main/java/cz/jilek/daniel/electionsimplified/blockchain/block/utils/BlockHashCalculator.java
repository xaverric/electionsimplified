package cz.jilek.daniel.electionsimplified.blockchain.block.utils;

import com.google.common.primitives.Bytes;
import cz.jilek.daniel.electionsimplified.blockchain.config.Configuration;
import cz.jilek.daniel.electionsimplified.blockchain.block.entity.Block;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class BlockHashCalculator implements HashCalculator<Block> {

    @Override
    public String calculate(Block data) {
        try {
            MessageDigest md = MessageDigest.getInstance(Configuration.DEFAULT_HASH_ALGORITHM);
            List<Byte> bytes = Bytes.asList(md.digest(data.toString().getBytes()));
            return toHexString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String toHexString(List<Byte> bytes) {
        StringBuilder sb = new StringBuilder();
        bytes.forEach(b -> {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                sb.append(Configuration.LEADING_ZERO);
            }
            sb.append(hex);
        });
        return sb.toString();
    }
}