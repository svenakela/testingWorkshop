# The Tests Workshop

[![forthebadge](https://forthebadge.com/images/badges/gluten-free.svg)](https://forthebadge.com)


This is a working example how to write tests with Groovy and Spock!

To be able to run this branch locally, you need at least Java 10, Groovy 2.5 and Maven installed. 
How to install Groovy can be found [here](http://groovy-lang.org/install.html#SDKMAN).

## What To Do?

This is actually a walk through session with not so much coding, but you are more than welcome to checkout the branch and write tests yourself! The [Spock Documentation](http://spockframework.org/spock/docs/1.1/index.html) will be your friend.

### Go Another Language - Meet Groovy!

There are test tools and then there are test tools. This is _the_ test tool for a developer. Why? Well, check it out.

By using Groovy and Spock we have a very clean way of writing tests, with little effort and just a few lines of code you can produce powerful test cases. They will behave as Junit tests, will be executed by Maven as usual and will be included in the test coverage reports.

Groovy is accepting mixing of Java code and pure Groovy code. You can write Java syntax and use Java classes within a Groovy class. You can even use semicolon if you'd like and it will still work.

Groovy has a lot of powerful features built-in, such as string shifting, Json/Xml transformers (Check the [slurpers](http://groovy-lang.org/json.html)) and [closures](http://docs.groovy-lang.org/latest/html/documentation/#_closures). 

Spock includes mocking mechanisms, checking features such as _did we get an Exception?_ (`throw()` or `notThrown`), timeout controls and much more. Already mentioned, but have a look at the [Spock Documentation](http://spockframework.org/spock/docs/1.1/index.html).

To continue with the [Another Language session](https://github.com/svenakela/testingWorkshop/tree/another-language-groovy), do a checkout on the branch and dig into the test examples:

```
git pull
git checkout another-language-groovy
```

### So, how do we check the coverage?

There are several ways to get test coverage. For these exercises JaCoCo (*Ja*va *Co*de *Co*verage) is already configured and you can get the result locally. JaCoCo creates a binary report, to be able to read it as a human being we need to create the report:

```bash
any-user$ mvn clean test jacoco:report
```
Note that the JaCoCo report itself is created in the test phase, the `jacoco:report` command generates an html based report from the binary analysis. To run the test only, without the report creation, just remove the `jacoco` statement.

Now there is an index.html that can be opened in your favourite web browser:

```
mac-user$ open target/site/jacoco/index.html
```

or for a Linux user:

```
linux-user$ xdg-open target/site/jacoco/index.html
```
