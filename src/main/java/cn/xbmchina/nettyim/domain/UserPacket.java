package cn.xbmchina.nettyim.domain;

import lombok.Data;

import static cn.xbmchina.nettyim.domain.Command.LOGIN_REQUEST;
@Data
public class UserPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
