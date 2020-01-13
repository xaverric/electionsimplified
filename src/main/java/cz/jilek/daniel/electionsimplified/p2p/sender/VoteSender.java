package cz.jilek.daniel.electionsimplified.p2p.sender;

import org.jgroups.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteSender {

    private Sender sender;

    @Autowired
    public VoteSender(Sender sender) {
        this.sender = sender;
    }

    public void sendVoteToAllNodes(String candidateUuid) throws Exception {
        Message message = new Message();
        message.setObject(candidateUuid);
        sender.sendMessageBroadcast(message);
    }
}
