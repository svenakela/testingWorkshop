package barky.fizzy.cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Not needed to run {@link MockitoAnnotations}.init(this) anymore. @ExtendWith takes care of that.
 */
@ExtendWith(MockitoExtension.class)
public class FizzyCipherSpyTest {

    @Spy
    private ModulusCipher c = new ModulusFiveCipher();

    @Test
    public void testFizzyCipher() {

        var fc = new FizzyCipher(c);
        assertEquals("fizz-buzz10", fc.generate(List.of(1, 9, 10)));
        Mockito.verify(c).getCipher(10);
        Mockito.verify(c, Mockito.times(1)).getCipher(Mockito.anyInt());

    }

    @Test
    public void testFizzyCipher2() {

        var cipher = Mockito.mock(ModulusCipher.class);
        Mockito.doReturn("-mockyMcMockFace").when(cipher).getCipher(10);
        FizzyCipher fc = Mockito.spy(new FizzyCipher(cipher));
        
        fc.isValid(fc.generate(List.of(1, 9, 10)));

        verify(cipher).getCipher(10);
        verify(cipher, atLeast(1)).getCipher(Mockito.anyInt());
        verify(cipher, atLeastOnce()).getCipher(Mockito.anyInt());

        InOrder order = Mockito.inOrder(fc);

        order.verify(fc).generate(Mockito.any());
        order.verify(fc).isValid(Mockito.anyString());
    }


}
