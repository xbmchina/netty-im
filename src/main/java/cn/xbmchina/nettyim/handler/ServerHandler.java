package cn.xbmchina.nettyim.handler;

import cn.xbmchina.nettyim.covertor.PacketCodeC;
import cn.xbmchina.nettyim.domain.Packet;
import cn.xbmchina.nettyim.domain.ResponsePacket;
import cn.xbmchina.nettyim.domain.UserPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(new Date() + ": 客户端开始登录……");
        ByteBuf requestByteBuf = (ByteBuf) msg;

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        if (packet instanceof UserPacket) {
            // 登录流程
            UserPacket loginRequestPacket = (UserPacket) packet;

            ResponsePacket loginResponsePacket = new ResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() + ": 登录成功!");
            } else {
                loginResponsePacket.setReason("账号密码校验失败");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() + ": 登录失败!");
            }
            // 登录响应
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private boolean valid(UserPacket loginRequestPacket) {
        return true;
    }
}
