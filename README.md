# Markdown Link Parser

## Description

This application was created for the purpose of parsing markdown links for the course CSE 15L: Software Tools and Techniques Laboratory at the University of California San Diego. The application is written in Java and uses the JUnit library to parse the program with markdown test files. The application is capable of parsing the markdown file and returning the links in the file. The application uses the following libraries: CommonMark, JUnit, and Hamcrest.

The directory structure of the application is as follows:
```bash
├── MarkdownParse.java
├── MarkdownParseTest.java
├── README.md
├── lib
│   ├── commonmark-0.18.2.jar
│   ├── hamcrest-core-1.3.jar
│   └── junit-4.13.2.jar
├── makefile
├── mdparse
├── my-test-files
│   ├── ...other test files
├── test-files
│   ├── ...other test files
└── script.sh
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

The user can use the application to run any given markdown test file by running the following command using bash:
```shell
bash mdparse test-file.md
```
where `test-file.md` is the name of the markdown file to be parsed.


## Tests

To run `MarkdownParseTest.java` please use the `make` command to compile and run the Java program and corresponding JUnit tests.
```shell
make test
```

## Contact

You can view more of my projects at [https://github.com/jeremynguyencs](https://github.com/jeremynguyencs).