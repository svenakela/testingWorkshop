# The Tests Workshop

[![forthebadge](https://forthebadge.com/images/badges/gluten-free.svg)](https://forthebadge.com)

## Create Tests On Existing Code

Get to know testing tools and aim for high test coverage!

### Scenario

One morning at the coffee machine you are being told by your boss that the quiet dude Barky in the corner just left. You have to take over his project and dig into the code only to realize - there are no tests at all!

First off, without existing tests we actually don't know if code is doing what it is supposed to do. But code shouldn't be untested and by writing tests you ensure that the code still works as expected when you start refactoring. And when the time comes where code actually is guilty for doing wrong, you change your tests accordingly. So lets dig into the existing code and create tests!

### Task

Write tests for the existing code. You should reach at least 90 % test coverage.

Is the code not-so-pretty (lets be honest, ugly)? Yes! When you finally have a high code coverage, rewrite code, make it easier to read, break out code blocks to new methods and refine the tests. Make it better!


### Things To Test

- Do we actually get the correct result from the cipher method?
- What about the time range?
- Is the entire method touched by the tests?
- Do we get the expected value out?
- If we run a range of numbers, how many times do we hit the `ModulusCipher` type? Count!


### Check Coverage

```bash
any-user$ mvn clean test jacoco:report
```

Now there is an index.html that can be opened in your favourite web browser:

```
mac-user$ open target/site/jacoco/index.html
```

or for a Linux user:

```
linux-user$ xdg-open target/site/jacoco/index.html
```

All popular IDEs have support for code coverage presentation, the measurements can be generated directly within your favourite editor. How to do it depends on the IDE, see the documentation for your version.
