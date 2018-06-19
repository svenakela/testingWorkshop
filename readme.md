# The Tests Workshop

[![forthebadge](https://forthebadge.com/images/badges/gluten-free.svg)](https://forthebadge.com)

## Create Tests On Existing Code

Get to know testing tools and aim for high test coverage!

### Scenario

So, you were told by your boss to manage the quiet dude Barky's old code. Now you realize it's a code smell el Grande...

There is a Cipher generator for an external application that tries to get data from an external server. Of course, everything untested.

### Task

Write tests for the existing code. You should reach at least 90 % test coverage. Try to test as close to the external calls as possible.


### Things To Test

- Do we actually get the correct result from the cipher method?
- Mock or Spy away the external client
- Verify the number of times the client is invoked
- Is the entire method touched by the tests (no branching)?
- Do we get the expected value out?


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
