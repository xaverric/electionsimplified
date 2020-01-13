package cz.jilek.daniel.electionsimplified.p2p.receiver.vote;

import org.jgroups.Message;

public interface Receiver {
    
    void receiveMessage(Message message);
}
