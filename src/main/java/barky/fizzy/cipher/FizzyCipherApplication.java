package barky.fizzy.cipher;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Those bloody devops came up with the "brilliant" idea that the database cipher could be used for the hdfs as well.
 * "You just need to call that REST for IDs"... Yeah right. It is not even the same algorithm. And it was telnet.
 * 
 * @author Barky Slomotski
 *
 */
public class FizzyCipherApplication {

    public static void main(final String[] args) {
        new FizzyCipherApplication().generateCipherKey();
    }

    private void generateCipherKey() {

        List<Integer> listToValidate = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        NetBoundCipher fb = new NetBoundCipher();
        System.out.println(fb.generate(listToValidate));
    }

}
