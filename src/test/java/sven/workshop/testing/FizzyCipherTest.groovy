package sven.workshop.testing

import spock.lang.Specification

/**
 * Groovy tests. Documentation found at
 * <a href="http://spockframework.org/spock/docs/1.0/">The Spock web site</a>.
 *
 */
class FizzyCipherTest extends Specification {

    def 'Run FizzyCipher With List'() {

        given:
        def numbers = List.of(1,3,10,11,15)

        when:
        def result = new FizzyCipher().generate(numbers)

        then:
        result.equals('x-fizz-buzz-x-fizzbuzz')
    }

    def 'Run FizzyChiper Data Driven'() {

        expect:
        new FizzyCipher().generate(List.of(a, b)).equals(c)

        where:
        a |  b || c
        1 |  2 || 'x-x'
        3 |  5 || 'fizz-buzz'
        15 | 18 || 'fizzbuzz-fizz'
    }

    def 'Fail When null Is Used'() {

        when:
        new FizzyCipher().generate(null)

        then:
        thrown(NullPointerException)
    }
}
