#!/bin/bash
cp src/test/java/adventofcode/TestDayTemplate.java src/test/java/adventofcode/TestDay$1.java
echo "Created file: src/test/java/adventofcode/TestDay$1.java"
sed -i "s/Template/$1/g" src/test/java/adventofcode/TestDay$1.java
mkdir src/main/java/adventofcode/day$1
echo "Created folder: src/main/java/adventofcode/day$1"
cp src/main/java/adventofcode/dayTemplate/DayTemplate.java src/main/java/adventofcode/day$1/Day$1.java
echo "Created file: src/main/java/adventofcode/day$1/Day$1.java"
sed -i "s/Template/$1/g" src/main/java/adventofcode/day$1/Day$1.java
touch src/main/resources/testinput$1.txt
echo "Created file: src/main/resources/testinput$1.txt"
touch src/main/resources/input$1.txt
echo "Created file: src/main/resources/input$1.txt"
