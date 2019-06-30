package cn.xbmchina.nettyim.protocol;

import lombok.Data;

import static cn.xbmchina.nettyim.protocol.Command.LOGIN_RESPONSE;

@Data
public class ResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}