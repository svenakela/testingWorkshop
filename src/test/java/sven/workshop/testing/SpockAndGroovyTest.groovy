package sven.workshop.testing

import spock.lang.Specification

/**
 * <a href="http://spockframework.org/spock/docs/1.1/index.html">How to use Spock</a>
 *
 */
class SpockAndGroovyTest extends Specification {

    def 'Verify the String in AnotherLanguage'() {

        when:
            def value = new AnotherLanguage().languge
        then:
            value.contains('Groovy')
    }

}
