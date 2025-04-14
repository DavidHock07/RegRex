# RegRex – Java Builder for Regular Expressions

RegRex is a Java library that simplifies the creation of regular expressions through an intuitive API. Instead of manually writing complex regex strings, RegRex lets you compile your expressions in a modular and readable way.

---

## 🚀 Quick Start

```java
import regrex.domain.RexRegEx;

public class Example {
    public static void main(String[] args) {
        RexRegEx builder = new RexRegEx();
        String regex = builder
        .followedFrom(RexRegEx.anyDigit())
        .followedFrom(RexRegEx.anyLetterFromSet("abc"))
        .getRegExString();

        System.out.println(regex); // Prints, for example, "\d[abc]"
    }
}
```

## 🔧 Functions

### 🔁 Combinatorics & Repetitions

- `noneToInfinitelyTimes(String expression)`
Returns the expression that repeats the pattern zero to infinitely many times (`*`).

- `oneToInfinitelyTimes(String expression)`
Returns the expression that repeats the pattern at least once (`+`).

- `noneOrOneTime(String expression)`
Returns the expression that repeats the pattern zero or once (`?`).

- `xTimes(String expression, int numberOfTimesToOccur)`
Returns the expression that repeats the pattern exactly `numberOfTimesToOccur` times (`{n}`).

- `XToYTimes(String expression, int minNumberOfTimesToOccur, int maxNumberOfTimesToOccur)`
Returns the expression that repeats the pattern between `min` and `max` times (`{min,max}`).

### 🔤 Character Classes

- `anyCharacter()`
Returns the expression that represents any character (`.`).

- `anyDigit()`
Returns the expression that represents a digit (`\d`).

- `noDigit()`
Returns the expression that represents a non-digit character (`\D`).

- `whitespaceCharacter()`
Returns the expression that represents a whitespace character (`\s`).

- `noWhitespaceCharacter()`
Returns the expression that represents a non-whitespace character (`\S`).

- `wordCharacter()`
Returns the expression that represents a word character (`\w`).

- `noWordCharacter()`
Returns the expression that represents a non-word character (`\W`).

- `wordBoundary()`
Returns the expression that represents a word boundary (`\b`).

### 🔡 Character Sets

- `anyLetterFromSet(...)`
Returns the expression that represents any character from the specified set (`[...]`). Supports `String`, `List<String>`, `Set<Character>`, `Character...`, and `String...`.

- `noLetterFromSet(...)`
Returns the expression that represents any character that is **not** in the specified set (`[^...]`). Supports the same parameters as `anyLetterFromSet`.

### 🧱 Groups & Sequences

- `group(...)`
Returns the expression that groups the specified elements (`(...)`). Supports `String`, `List<String>`, `Set<Character>`, and `String...`.

- `charSequence(String charSequence)`
Returns the expression that represents the exact character sequence.

- `or(String argumentA, String argumentB)`
Returns the expression that accepts either `argumentA` or `argumentB` (`|`).

### 🔚 Anchors & Positions

- `lineEnd()`
Returns the expression that marks the end of a line (`$`).

### 🧱 Fluent Interface

- `followedFrom(String expression)`
Appends the specified expression to the current pattern.

- `notFollowedFrom(String expression)`
Adds a negative lookahead condition that ensures that the specified expression **does not** follow.

- `getRegExString()`
Returns the currently constructed regular expression as a `String`.

### 📦 Predefined Patterns (`RegRexCave`)

- `eMailRegEx`
Regular expression for validating email addresses.

- `internationalTelephoneNumberRegEx`
Regular expression for validating international phone numbers.

- `urlRegEx`
Regular expression for validating URLs.

- `iPv4RegEx`
Regular expression for validating IPv4 addresses.

- `userNameRegEx`
Regular expression for validating usernames.

- `weakPasswordRegEx`
Regular expression for validating weak passwords.

- `macAdressRegEx`
Regular expression for validating MAC addresses.

### 🔠 Character Sets (`CharacterSet`)

- `upperCaseLetters`
Contains all uppercase letters of the alphabet.

- `lowerCaseLetters`
Contains all lowercase letters of the alphabet.

- `specialCharacters`
Contains a selection of special characters.

- `numbers`
Contains the numbers 0 to 9.

---

## 🌐 Further Documentation & Examples

For detailed instructions, usage examples, and interactive code snippets, please visit our [documentation website](https://regrex.example.com).

---

## 🛠️ License

This project is licensed under the MIT License. For more information, see the [LICENSE](LICENSE) file.