package barky.fizzy.cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

@TestInstance(Lifecycle.PER_CLASS) // Needed to get @BeforeAll to work, unless you like static fields
class NetBoundCipherTest {
    Cipher         cipher;
    NetBoundCipher netBoundCipher;

    @BeforeAll
    public void setUp() {
        cipher = Mockito.mock(Cipher.class);
        netBoundCipher = new NetBoundCipher(cipher);
        Mockito.when(cipher.getCipher()).thenReturn("TEST");
    }

    @Test
    public void returnExpectedValue_whenEmptyListGiven() {
        final String result = netBoundCipher.generate(Collections.emptyList());

        assertEquals("", result);
    }

    @Test
    public void returnExpectedValue_whenListWithNonDividibleBy10DigitsGiven() {
        final String result = netBoundCipher.generate(Arrays.asList(1, 2));

        assertEquals("TEST-TEST", result);
    }

    @Test
    public void returnExpectedValue_whenListWithDividibleBy10DigitsGiven() {
        final String result = netBoundCipher.generate(Arrays.asList(10, 20));

        assertEquals("xyz-xyz", result);
    }

    @Test
    public void returnExpectedValue_whenListWithDividibleBy10AndNotDigitsGiven() {
        final String result = netBoundCipher.generate(Arrays.asList(10, 15));

        assertEquals("xyz-TEST", result);
    }
}