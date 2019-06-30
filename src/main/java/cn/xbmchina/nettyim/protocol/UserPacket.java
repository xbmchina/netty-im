package cn.xbmchina.nettyim.protocol;

import lombok.Data;

import static cn.xbmchina.nettyim.protocol.Command.LOGIN_REQUEST;
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
