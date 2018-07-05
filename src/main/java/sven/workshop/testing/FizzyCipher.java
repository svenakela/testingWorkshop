package sven.workshop.testing;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import groovy.lang.Tuple2;

public final class FizzyCipher {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    Predicate<Integer> mod3 = i -> i % 3 == 0;
    Predicate<Integer> mod5 = i -> i % 5 == 0;

    Function<Tuple2<Integer, String>, Tuple2<Integer, String>> toFizz = t -> mod3.test(t.getFirst())
            ? new Tuple2<>(t.getFirst(), FIZZ)
            : t;
    Function<Tuple2<Integer, String>, Tuple2<Integer, String>> toBuzz = t -> mod5.test(t.getFirst())
            ? new Tuple2<>(t.getFirst(), BUZZ)
            : t;
    Function<Tuple2<Integer, String>, Tuple2<Integer, String>> toFizzBuzz = t -> mod3.and(mod5).test(t.getFirst())
            ? new Tuple2<>(t.getFirst(), FIZZ + BUZZ)
            : t;

    public String generate(final List<Integer> numbers) {

        return numbers.stream()
                .map(this::tuple)
                .map(toFizz)
                .map(toBuzz)
                .map(toFizzBuzz)
                .map(Tuple2::getSecond)
                .collect(Collectors.joining("-"));
    }

    private Tuple2<Integer, String> tuple(final Integer integer) {
        return new Tuple2<>(integer, "x");
    }

}
