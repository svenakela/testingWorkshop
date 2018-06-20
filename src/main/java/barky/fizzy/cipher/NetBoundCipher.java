package barky.fizzy.cipher;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Whateva, it works. At least on Java 10.
 *
 * @author Barky Slomotski
 */
public class NetBoundCipher {

    private static final String DELIM        = "-";
    private static final String BASE_TEN_VAL = "xyz";
    private final        Cipher netCipher;

    public NetBoundCipher(final Cipher netCipher) {
        this.netCipher = netCipher;
    }

    public String generate(final List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n % 10 == 0 ? BASE_TEN_VAL : netCipher.getCipher())
                .collect(Collectors.joining(DELIM));
    }
}
