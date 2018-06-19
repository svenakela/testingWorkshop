package barky.fizzy.cipher;

import java.util.List;

/**
 * Whateva, it works right.
 * 
 * @author Barky Slomotski
 *
 */
public class FizzyCipher {

    private final ModulusCipher fiverCipher;

    public FizzyCipher(final ModulusCipher fiverCipher) {
        this.fiverCipher = fiverCipher;
    }

    public String generate(final List<Integer> numbers) {

        String retVal = "";

        for (Integer integer : numbers) {
            if (integer % 3 == 0) {
                if (integer % 5 == 0) {
                    retVal = retVal + "-fizzbuzz";
                } else {
                    retVal = retVal + "-fizz";
                }
            } else if (integer % 5 == 0) {
                retVal = retVal + fiverCipher.getCipher(integer);
            }

        }
        
        if (retVal.startsWith("-")) {
            retVal = retVal.substring(1);
        }

        return retVal;
    }

    public boolean isValid(final String cipher) {
        return !cipher.isEmpty();
    }

}
