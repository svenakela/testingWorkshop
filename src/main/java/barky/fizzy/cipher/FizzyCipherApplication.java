package barky.fizzy.cipher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is so difficult to maintain but I can't remove it even though I want to because the password gen for the
 * database is using this cipher. Can't we just replace the database with something else, like a file area. I don't
 * wanna touch it because it works.
 * 
 * @author Barky Slomotski
 *
 */
public class FizzyCipherApplication {

    public static void main(final String[] args) {
        new FizzyCipherApplication().generateCipherKey();
    }

    private void generateCipherKey() {

        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String time = dateFormat.format(date);
        List<Integer> listToValidate = null;

        if (time.equals("12") || time.equals("13")) {
            listToValidate = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        } else {
            listToValidate = IntStream.range(0, 33).boxed().collect(Collectors.toList());
        }

        FizzyCipher fb = new FizzyCipher(new ModulusFiveCipher());
        System.out.println(fb.generate(listToValidate));
    }

}
