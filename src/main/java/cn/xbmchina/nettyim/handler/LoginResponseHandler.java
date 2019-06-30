package cn.xbmchina.nettyim.handler;

import cn.xbmchina.nettyim.protocol.ResponsePacket;
import cn.xbmchina.nettyim.protocol.UserPacket;
import cn.xbmchina.nettyim.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

public class LoginResponseHandler extends SimpleChannelInboundHandler<ResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // 创建登录对象
        UserPacket loginRequestPacket = new UserPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");

        // 写数据
//        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponsePacket loginResponsePacket) {
        if (loginResponsePacket.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
        }
    }
}