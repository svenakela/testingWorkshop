package sven.workshop.testing

import static org.junit.Assert.*
import org.junit.Assert
import org.junit.Test

class JunitInGroovyTest {

    @Test
    void checkTheString() {

        def matcher = new AnotherLanguage().getLanguage() =~ /Groovy.*/
        Assert.assertTrue(matcher.matches())
    }

}
