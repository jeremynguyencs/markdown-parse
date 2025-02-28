# Markdown Link Parser

## Description

This application was created for the purpose of parsing markdown links for the course CSE 15L: Software Tools and Techniques Laboratory with Professor Joe Politz at the University of California San Diego. The application is written in Java and uses the JUnit library to parse the program with markdown test files. The application is capable of parsing the markdown file and returning the links in the file. The application uses the following libraries: CommonMark, Hamcrest, and JUnit. It includes the scripts `mdparse` and `script.sh` and a makefile. The repository also uses a Github Action to run the tests with a continuous integration workflow.

The directory structure of the application is as follows:
```
├── lib
│   ├── commonmark-0.18.2.jar
│   ├── hamcrest-core-1.3.jar
│   └── junit-4.13.2.jar
├── my-test-files
│   └── ...other test files
├── test-files
│   └── ...other test files
├── MarkdownParse.java
├── MarkdownParseTest.java
├── makefile
├── mdparse
├── script.sh
└── README.md
```

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Tests](#tests)
- [Contact](#contact)

## Installation

The user should clone the repository from GitHub through the command line with the following command:
```shell
git clone https://github.com/jeremynguyencs/markdown-parse.git
```

## Usage

The user can use the application to run any given markdown file by running the following command using bash:
```shell
bash mdparse test-file.md
```
where `test-file.md` is the name of the markdown file to be parsed.

The user can also use the `java` command to also run the program with any given markdown file:
```java
javac MarkdownParse.java
java MarkdownParse test-file.md
```

To debug the program, the user can use the Java debugger `jdb` through the makefile `make` command.
```shell
make debug
```

## Tests

To run `MarkdownParseTest.java`, use the `make` command to compile and run the Java program and corresponding JUnit tests.
```shell
make test
```

## Contact

You can view more of my projects at [https://github.com/jeremynguyencs](https://github.com/jeremynguyencs).
