#!/bin/bash
# Run this ONCE before anything else.
# Downloads the JUnit 5 standalone JAR into tests/lib/

JAR_URL="https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar"
JAR_PATH="tests/lib/junit-standalone.jar"

mkdir -p tests/lib

if [ -f "$JAR_PATH" ]; then
    echo "JUnit JAR already present. Nothing to do."
    exit 0
fi

echo "Downloading JUnit 5 standalone JAR..."

if command -v curl &>/dev/null; then
    curl -L "$JAR_URL" -o "$JAR_PATH"
elif command -v wget &>/dev/null; then
    wget "$JAR_URL" -O "$JAR_PATH"
else
    echo "ERROR: Neither curl nor wget found. Install one and retry."
    exit 1
fi

echo ""
echo "Done. Run ./run_tests.sh to test your solutions."
