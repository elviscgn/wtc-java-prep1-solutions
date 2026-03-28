#!/bin/bash
JAR="tests/lib/junit-standalone.jar"
BUILD_DIR="build"
SOLUTIONS_DIR="solutions"
TESTS_DIR="tests"

if [ ! -f "$JAR" ]; then
    echo "JUnit JAR not found. Run ./setup.sh first."
    exit 1
fi

if [ ! -d "$SOLUTIONS_DIR" ]; then
    echo "No solutions/ folder found."
    exit 1
fi

SOLUTION_FILES=$(find "$SOLUTIONS_DIR" -name "*.java" 2>/dev/null)
if [ -z "$SOLUTION_FILES" ]; then
    echo "No .java files in solutions/ yet."
    exit 1
fi

rm -rf "$BUILD_DIR"
mkdir -p "$BUILD_DIR"

echo "Compiling solutions..."
javac -cp "$JAR" -d "$BUILD_DIR" $SOLUTION_FILES 
if [ $? -ne 0 ]; then exit 1; fi

FILTER="${1:-}"
if [ -n "$FILTER" ]; then
    TEST_FILES=$(find "$TESTS_DIR" -name "*${FILTER}*.java" ! -path "*/lib/*" 2>/dev/null)
else
    TEST_FILES=$(find "$TESTS_DIR" -name "*.java" ! -path "*/lib/*" 2>/dev/null)
fi

if [ -z "$TEST_FILES" ]; then
    echo "No test files found matching '${FILTER}'."
    exit 1
fi

echo "Compiling tests..."
javac -cp "$JAR:$BUILD_DIR" -d "$BUILD_DIR" $TEST_FILES
if [ $? -ne 0 ]; then exit 1; fi

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# THE FIX: Instead of hardcoding "wtc.", we use --scan-classpath 
# and filter by the classname pattern.
if [ -n "$FILTER" ]; then
    echo "  Running tests matching: $FILTER"
    java -jar "$JAR" --classpath "$BUILD_DIR" --scan-classpath --include-classname ".*${FILTER}.*"
else
    echo "  Running all tests"
    java -jar "$JAR" --classpath "$BUILD_DIR" --scan-classpath
fi

echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"