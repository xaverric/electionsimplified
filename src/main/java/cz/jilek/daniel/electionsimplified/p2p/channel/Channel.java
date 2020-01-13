package cz.jilek.daniel.electionsimplified.p2p.channel;

import cz.jilek.daniel.electionsimplified.p2p.receiver.ChannelReceiver;
import org.jgroups.JChannel;
import org.springframework.stereotype.Service;

@Service
public class Channel {

    private static final String DEFAULT_CLUSTER = "DEFAULT_CLUSTER";

    private JChannel jChannel;

    public JChannel get() {
        try {
            initChannel();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return jChannel;
        }
    }

    private void initChannel(){
        try {
            if (this.jChannel == null ){
                jChannel = new JChannel("channel_udp.xml");
                //jChannel.getProtocolStack().findProtocol(TP.class).setValue("bind_addr", InetAddress.getByName("192.168.0.1"));
                jChannel.setReceiver(new ChannelReceiver());
                jChannel.connect(DEFAULT_CLUSTER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
