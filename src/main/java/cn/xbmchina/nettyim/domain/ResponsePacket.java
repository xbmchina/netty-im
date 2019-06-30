package cn.xbmchina.nettyim.domain;

import lombok.Data;

import static cn.xbmchina.nettyim.domain.Command.LOGIN_RESPONSE;

@Data
public class ResponsePacket extends Packet {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}