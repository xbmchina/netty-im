package cn.xbmchina.nettyim.handler;

import cn.xbmchina.nettyim.protocol.ResponsePacket;
import cn.xbmchina.nettyim.protocol.UserPacket;
import cn.xbmchina.nettyim.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class LoginRequestHandler extends SimpleChannelInboundHandler<UserPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UserPacket loginRequestPacket) {
        System.out.println(new Date() + ": 收到客户端登录请求……");

        ResponsePacket loginResponsePacket = new ResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            // 基于我们前面小节的代码，添加如下一行代码
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(UserPacket loginRequestPacket) {
        return true;
    }
}