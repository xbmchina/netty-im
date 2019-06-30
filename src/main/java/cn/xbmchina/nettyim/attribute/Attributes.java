package cn.xbmchina.nettyim.attribute;

import io.netty.util.AttributeKey;

public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
