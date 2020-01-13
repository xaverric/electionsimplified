package cz.jilek.daniel.electionsimplified.p2p.receiver;

import cz.jilek.daniel.electionsimplified.Context;
import cz.jilek.daniel.electionsimplified.p2p.receiver.vote.VoteReceiver;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class ChannelReceiver extends ReceiverAdapter {

    @Override
    public void viewAccepted(View view) {

    }

    @Override
    public void receive(Message msg) {
        getVoteService().receiveMessage(msg);
    }

    private VoteReceiver getVoteService(){
        return Context.getBean(VoteReceiver.class);
    }
}
