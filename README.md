This is a shell for Java autograder assignments with test classes for
GitHub Classroom with codespaces and maven. It requires a newer version
of maven compatible with Java 17. It works locally.

The devcontainer.json specifies a container with Java 17 and (hopefully)
a compatible version of maven.

Refactor App.java to the main file for the assignment.
Refactor AppTest and AnotherAppTest to be unit test classes.
In GitHub Classroom, add `mvn test -Dtest=AppTest` to run the first, and
`mvn test -Dtest=AnotherAppTest` to run the second. Create additional
files full of tests for additional partial credit.

Alternatively, for Classroom, you can make one test class with carefully
named tests according to a pattern, then run them in groups in separate
calls to give partial credit. e.g. `mvn test -Dtest=AppTest#xxx`, where
`xxx` is a method name or pattern. So if you, for example, prefix all
tests for part 1 with `part1`, like `public void part1testGetter`, 
`part1testSetter`, `part1testConstructor`, you can run all those with 
`mvn test -Dtest=AppTest#part1*` and assign a point value for just those.

For testing standard input/output, an example test is given for a main
method that computes the sum of two integers. Be careful with line
separators, and with clearing streams if you are testing multiple
separate input/output items. It's definitely not the best way to test
but often necessary before students learn how to write methods.