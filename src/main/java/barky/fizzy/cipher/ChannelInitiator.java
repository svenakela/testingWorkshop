package barky.fizzy.cipher;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

class ChannelInitiator {

    public Channel connect(final String host, final int port, final StringEncoder encoder, final StringDecoder decoder) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(final SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(encoder);
                            ch.pipeline().addLast(new LineBasedFrameDecoder(Short.MAX_VALUE, true, true));
                            ch.pipeline().addLast(decoder);
                            ch.pipeline().addLast(this);
                        }
                    });

            return b.connect(host, port).sync().channel();
        }
        catch (Exception e) {
            return connect(host, port, encoder, decoder);
        }
        finally {
            group.shutdownGracefully();
        }
    }
}
