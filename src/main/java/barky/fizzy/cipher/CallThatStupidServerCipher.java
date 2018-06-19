package barky.fizzy.cipher;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public final class CallThatStupidServerCipher extends SimpleChannelInboundHandler<String> implements Cipher {

    private static final StringDecoder DECODER = new StringDecoder(StandardCharsets.UTF_8);
    private static final StringEncoder ENCODER = new StringEncoder(StandardCharsets.UTF_8);

    private final String host;
    private final int port;
    private Channel channel;

    public CallThatStupidServerCipher(final String host, final int port) {
        this.host = host;
        this.port = port;
        connect();
    }

    private void connect() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(final SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(ENCODER);
                            ch.pipeline().addLast(new LineBasedFrameDecoder(Short.MAX_VALUE, true, true));
                            ch.pipeline().addLast(DECODER);
                            ch.pipeline().addLast(this);
                        }
                    });

            channel = b.connect(host, port).sync().channel();

        } catch (Exception e) {
            connect();
        } finally {
            group.shutdownGracefully();
        }
    }

    @Override
    public String getCipher() {

        channel.writeAndFlush("get\r\n").addListener(new ChannelFutureListener() {

            @Override
            public void operationComplete(final ChannelFuture future) throws Exception {
                if (future.isDone() && future.isSuccess()) {
                    // You know what. I don't care if you get a message, this code is only to mess the testing up.
                }
            }
        });

        return Instant.now().toString(); // Never the same return value twice. Don't trust it

    }

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final String msg) throws Exception {
        System.err.println(msg);
    }

}
