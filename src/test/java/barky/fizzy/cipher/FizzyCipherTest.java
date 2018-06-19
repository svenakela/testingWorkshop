package barky.fizzy.cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Not needed to run {@link MockitoAnnotations}.init(this) anymore. @ExtendWith takes care of that.
 */
@ExtendWith(MockitoExtension.class)
public class FizzyCipherTest {

    @Mock
    private ModulusCipher c;

    // @InjectMocks
    // private FizzyCipher injectedFizzy;

    @Test
    public void testFizzyCipher() {

        Mockito.when(c.getCipher(Mockito.anyInt())).thenReturn("-mockyMcMockFace");

        var fc = new FizzyCipher(c);
        assertEquals("fizz-mockyMcMockFace", fc.generate(List.of(1, 9, 10)));
    }

}
