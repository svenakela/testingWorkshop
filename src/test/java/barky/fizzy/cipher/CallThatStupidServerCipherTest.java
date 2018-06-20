package barky.fizzy.cipher;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

class CallThatStupidServerCipherTest {
    Channel          channel;
    ChannelFuture    channelFuture;
    String           host;
    int              port;
    ChannelInitiator channelInitiator;

    @BeforeAll
    public void setUp() {
        channelInitiator = Mockito.mock(ChannelInitiator.class);
        host = "10.0.0.14";
        port = 21;
        channel = Mockito.mock(Channel.class);
        channelFuture = Mockito.mock(ChannelFuture.class);
    }

    @Test
    public void doesWhatExpected() {
        Mockito.when(channelInitiator.connect(anyString(), anyInt(), any(), any())).thenReturn(channel);
        Mockito.when(channel.writeAndFlush(any())).thenReturn(channelFuture);

        final Cipher cipher = new CallThatStupidServerCipher(host, port, channelInitiator);

        cipher.getCipher();

        Mockito.verify(channel).writeAndFlush(any());
    }
}