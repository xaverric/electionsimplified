package cz.jilek.daniel.electionsimplified.p2p.sender;

import org.jgroups.Address;
import org.jgroups.Message;

import java.util.List;

public interface Sender {

    void sendMessageUnicast(Address address, Message message) throws Exception;

    void sendMessageMulticast(List<Address> addresses, Message message) throws Exception;

    void sendMessageBroadcast(Message message) throws Exception;

}
