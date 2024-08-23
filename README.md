# HW2_CPL

This is the implementation of a COOL Compiler (Lexer, Parser and Code Generation) written in Java.
To run it, you'll need IntelliJ IDEA [1] in order to load the project (which is ready to be as it is).

Project structure:
1. antlr-4.13.0-complete.jar - This .jar Module needs to be added in Project Structure for being able to import ANTLR necessary implementations.
2. tester.sh - Script used for running the tests. It also shows the passed and failed tests.

This Java Compiler generates code compatible with MIPS architecture. Because MIPS architecture oriented computers are not produced anymore, for testing I've used this simulator [2] (get this if you're a Windows user).

If you're using some Unix based OS or Distro, you should install SPIM via CLI (note that the script tester.sh expects you to have it installed).

For testing it yourself, simply create a file in cool/compiler directory with your COOL program and pass its Path from Content Root to Compiler standard input (see [3]). It should output the equivalent MIPS code.


[1]: https://www.jetbrains.com/help/idea/installation-guide.html#standalone
[2]: https://spimsimulator.sourceforge.net/
[3]: https://hyperskill.org/learn/step/10630
