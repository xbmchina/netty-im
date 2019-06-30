package cn.xbmchina.nettyim.protocol;

import lombok.Data;

import static cn.xbmchina.nettyim.protocol.Command.MESSAGE_REQUEST;
@Data
public class MessageRequestPacket extends Packet {

    public MessageRequestPacket() {
    }

    public MessageRequestPacket(String message) {
        this.message = message;
    }

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}