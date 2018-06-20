# The Tests Workshop

[![forthebadge](https://forthebadge.com/images/badges/gluten-free.svg)](https://forthebadge.com)

## Create Tests On Existing Code

Get to know testing tools and aim for high test coverage!

### Scenario

We need to remake this thing! Time to do it as it should've been, right?

### Task

Write tests FIRST, then the implementation!
The requirements are the same as the branch [Deal With External Code session](https://github.com/svenakela/testingWorkshop/tree/deal-with-external-code), you 
are supposed to re-implement the FizzBuzz Cipher but TDD style


### Things To Test

It's up to you. Good luck!


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
