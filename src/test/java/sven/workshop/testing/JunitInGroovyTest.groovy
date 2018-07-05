package sven.workshop.testing

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test

class JunitInGroovyTest {

    @Test
    void checkTheString() {

        def matcher = new AnotherLanguage().getLanguge() =~ /Groovy.*/
        Assert.assertTrue(matcher.matches())
    }

}
