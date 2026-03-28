# Section 1 — Java Syntax and Language Basics

These exercises force you to write Java from zero. You know programming logic. The goal here is to get Java's specific syntax.

---

## Exercise 1.1 — Temperature Converter

**Difficulty:** Starter | **Topic:** Java Syntax, Methods, Static

Create a file called `TemperatureConverter.java`. Write a class with three static methods and a main method that demonstrates all three.

**Methods to write:**
- `celsiusToFahrenheit(double c)` — returns double
- `fahrenheitToCelsius(double f)` — returns double
- `celsiusToKelvin(double c)` — returns double

**You must use:**
- `static` methods
- `double` return types
- `System.out.printf` or `String.format` for 2 decimal places
- At least 5 test conversions in `main`

**Expected output (example):**
```
100.0 C = 212.00 F
32.0 F = 0.00 C
0.0 C = 273.15 K
37.0 C = 98.60 F
-40.0 C = -40.00 F
```

---

## Exercise 1.2 — Number Analyser

**Difficulty:** Starter | **Topic:** Loops, Conditionals, Arrays

Create `NumberAnalyser.java`. In `main`, create an `int` array of at least 10 numbers (mix of positive, negative, odd, even). Write separate static methods for each of the following and print the results:

- `findMax(int[] arr)` — returns int
- `findMin(int[] arr)` — returns int
- `calculateAverage(int[] arr)` — returns double
- `countEvens(int[] arr)` — returns int
- `reverseArray(int[] arr)` — returns new `int[]`

> **Hint:** Java arrays have a `.length` property, not a method. `int[] arr = {1,2,3}; arr.length` is 3.

---

## Exercise 1.3 — String Detective

**Difficulty:** Starter | **Topic:** String Methods, Loops, char

Create `StringDetective.java`. Write these static methods and test each one in `main` with at least 2 examples:

- `isPalindrome(String s)` — returns boolean, ignore case
- `countVowels(String s)` — returns int
- `reverseWords(String s)` — returns String, reverses word order not letters
- `capitaliseEachWord(String s)` — returns String

**You must use:**
- String methods: `toLowerCase()`, `toUpperCase()`, `charAt()`, `split()`, `length()`
- A `for` loop or enhanced for loop over characters
- `StringBuilder` for building results

**Expected output (example):**
```
isPalindrome("Racecar") = true
isPalindrome("Hello") = false
countVowels("WeThinkCode") = 4
reverseWords("hello world java") = java world hello
capitaliseEachWord("we think code") = We Think Code
```