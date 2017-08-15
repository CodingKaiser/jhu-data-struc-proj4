This program sorts files containing positive integers.

Usage: java Lab4 [input folder name] [output file path name]

The input folder must contain the files that are supposed to be sorted.

Input files must be of form:
"
1
2
3
4
5

"
i.e. they
1. May not contain whitespace
2. The last character must be a newline character
3. One number per line
4. Integers only

The filename must be of form: "xxx100.yyy" or "xxx1K.yyy"
* xxx can be any combination of non-digit characters
* yyy can be any file extension
* A "K" will multiply the digit amount by 1000
* The digit count can be of any size BUT must match the total number of integers in the file
  i.e. a file called asc24K.txt must contain exactly 24 integers

Written in Java jdk1.8.0_131

Developed on Windows

Used IntelliJ IDEA 2017.1.4
--> Dumps compilation into out/production/ directory.
