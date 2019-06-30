package cn.xbmchina.nettyim.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();

    @JSONField(serialize = false)
    private boolean isSuccess;

    @JSONField(serialize = false)
    private String reason;
}