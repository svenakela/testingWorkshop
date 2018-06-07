# The Tests Workshop

[![forthebadge](https://forthebadge.com/images/badges/gluten-free.svg)](https://forthebadge.com)


Welcome to the testing workshop, a practical guide into testing in the Java world!

Is this a complete testing bible? No! This is a workshop into _how_ to test your (or someone else's) code with practical tips how to write code that is easier to test and what tools can be used to do it.

## What To Do?

There are a few sessions that you can go through, either all in a row or one at a time. Read the readme.md for each session to get the details. Every session has a specific task and each session has its own branch. To get the code and session practices, checkout the branch and start coding!

Your task is to get to know testing tools and the goal is to get a high test coverage.

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

All popular IDEs have support for code coverage presentation, the measurements can be generated directly within your favourite editor. How to do it depends on the IDE, see the documentation for your version.

To get deeper and automatic analysis there are some great server side tools. 

+ [SonarQube](https://www.sonarqube.org/) runs triggered by a build server (Jenkins, Travis etc) or by you manually sending a code coverage from command line. SonarQube gives more than code coverage like _Code Smell_, _Vulnerabilities_, _Duplications_. There is also a very powerful and free plugin called [SonarLint](https://www.sonarlint.org/) that can be installed in your IDE and it will give you direct feedback. You don't need a Sonar server to run the plugin. Use it!
Sonarqube has an official Docker image, you can run it locally to test the features.

+ [Atlassian's Clover](https://www.atlassian.com/software/clover) and the forked version [OpenClover](http://openclover.org/) is also very powerful server side tools. Clover has built in support for Groovy out of the box.

+ [Codecov](https://codecov.io/) also runs triggered by a build server or via command line. CodeCov is very easy to setup on github repositories with a CI tool like [Travis](https://travis-ci.org/). The service is free but there are payment plans for enhanced features.

Unfortunately a great tool died when Java 9 arrived. The [Maven Corbetura plugin](https://github.com/cobertura/cobertura/wiki) doesn't work any longer because of the missing tools jar that no longer exists. If you still are on Java 8 you can try it out, but remember you should upgrade your Java version ASAP. The plugin can be executed without changes to the POM file.

This workshop is based on [Maven](https://maven.apache.org/) and also [Spring Boot](http://spring.io/projects/spring-boot) but there is no need to use the Spring Boot test support until later in the workshop. You can use standard libraries for testing until it's time to check in the Spring Boot test support.

## Sessions

Here follows a brief explanation of the sessions in this workshop. 

### Create Tests On Existing Code

How do we deal with code that already exists which is untested? Write tests! First session and introduction to some test tools.

To continue with the [Test On Existing Code session](https://github.com/svenakela/testingWorkshop/tree/create-tests-on-existing-code), do a checkout on the branch and open this file again:

```
git pull
git checkout create-tests-on-existing-code
```

### When We Have To Deal With External Code

Mock it, and mock some more. When code relies on other methods, classes, requests we have the power to fake them away, even spy on them.

To continue with the [Deal With External Code session](https://github.com/svenakela/testingWorkshop/tree/deal-with-external-code), do a checkout on the branch and open this file again:

```
git pull
git checkout deal-with-external-code
```

### Test Driven Development

Dream Scenario, you have the power to be the first developer and your spec is clear as whisky. Hello TDD!

To continue with the [Test Driven Development session](https://github.com/svenakela/testingWorkshop/tree/test-driven-development), do a checkout on the branch and open this file again:

```
git pull
git checkout test-driven-development
```

### Write Tests In Spring Boot

Spring Boot (2) comes with a lot of testing tools. If you are going to code and test in Spring Boot, check this chapter.

To continue with the [Spring Boot 2 session](https://github.com/svenakela/testingWorkshop/tree/spring-boot-2), do a checkout on the branch and open this file again:

```
git pull
git checkout spring-boot-2
```

### Go Another Language - Meet Groovy!

There are test tools and then there are test tools. This is _the_ test tool for a developer. Why? Well, check it out.

To continue with the [Another Language session](https://github.com/svenakela/testingWorkshop/tree/another-language-groovy), do a checkout on the branch and open this file again:

```
git pull
git checkout another-language-groovy
```