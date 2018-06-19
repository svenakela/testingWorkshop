package barky.fizzy.cipher;

public class ModulusFiveCipher extends ModulusCipher {

    protected String getCipher(final int fiverr) {

        return fiverr % 5 == 0 ? "-buzz" + fiverr : "x";
    }

}
