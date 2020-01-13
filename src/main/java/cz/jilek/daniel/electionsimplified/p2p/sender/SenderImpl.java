package cz.jilek.daniel.electionsimplified.p2p.sender;

import cz.jilek.daniel.electionsimplified.p2p.channel.Channel;
import org.jgroups.Address;
import org.jgroups.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderImpl implements Sender {

    private final Channel channel;

    @Autowired
    public SenderImpl(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void sendMessageUnicast(Address address, Message message) throws Exception {
        message.setDest(address);
        channel.get().send(message);
    }

    @Override
    public void sendMessageMulticast(List<Address> addresses, Message message) throws Exception {
        for (Address address : addresses){
            message.setDest(address);
            channel.get().send(message);
        }
    }

    @Override
    public void sendMessageBroadcast(Message message) throws Exception {
        message.setDest(null);
        channel.get().send(message);
    }
}
