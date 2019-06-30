package cn.xbmchina.nettyim.handler;

import cn.xbmchina.nettyim.covertor.PacketCodeC;
import cn.xbmchina.nettyim.domain.Packet;
import cn.xbmchina.nettyim.domain.ResponsePacket;
import cn.xbmchina.nettyim.domain.UserPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端开始登录");

        // 创建登录对象
        UserPacket userEntity = new UserPacket();
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setUsername("bilibili");
        userEntity.setPassword("123456");

        // 编码
        ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(),userEntity);

        // 写数据
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;

        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if (packet instanceof ResponsePacket) {
            ResponsePacket responsePacket = (ResponsePacket) packet;

            if (responsePacket.isSuccess()) {
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + responsePacket.getReason());
            }
        }
    }
}
