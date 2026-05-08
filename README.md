**Project Description**
A simple Java 11 console application created as part of a technical assignment.
The project demonstrates clean code structure, input handling, and basic algorithmic problem-solving

**Overview**
The application processes several console-based tasks:
- Validates numeric input against a threshold
- Compares user input strings with predefined values
- Processes and filters numeric arrays
- Validates bracket sequences and identifies error positions
- Provides both static explanation and dynamic algorithmic solution for bracket validation

**Key Features**
- Clean separation of concerns (input, logic, processing)
- Robust console input handling with retry mechanism
- Stack-based algorithm for bracket sequence validation
- Clear and structured console workflow
- Testable business logic design

**Project Structure**
* Main – application entry point
* TaskProcessor – task orchestration and coordination
* InputUtil – safe console input handling with retry logic
* SequenceAnalyzerUtil – bracket sequence validation algorithm

**Testing**
The project includes basic unit tests covering core business logic:
- numeric comparisons
- string validation
- array processing logic
- bracket sequence validation
- input retry behavior

**Run**
Run the Main class from any Java IDE or via terminal (don't forget pathing to java folder):
javac application/Main.java
java application.Main
