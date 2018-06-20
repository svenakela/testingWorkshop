package barky.fizzy.cipher;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public final class CallThatStupidServerCipher extends SimpleChannelInboundHandler<String> implements Cipher {

    private static final StringDecoder DECODER = new StringDecoder(StandardCharsets.UTF_8);
    private static final StringEncoder ENCODER = new StringEncoder(StandardCharsets.UTF_8);

    private final String  host;
    private final int     port;
    private final ChannelInitiator channelInitiator;
    private       Channel channel;

    public CallThatStupidServerCipher(final String host, final int port, final ChannelInitiator channelInitiator) {
        this.host = host;
        this.port = port;
        this.channelInitiator = channelInitiator;
        this.channel = connect();
    }

    private Channel connect() {
        return channelInitiator.connect(host, port, ENCODER, DECODER);
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
