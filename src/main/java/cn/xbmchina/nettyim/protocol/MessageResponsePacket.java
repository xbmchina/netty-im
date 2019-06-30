package cn.xbmchina.nettyim.protocol;

import lombok.Data;

import static cn.xbmchina.nettyim.protocol.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}