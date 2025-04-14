package regrex.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RexRegEx {
    private StringBuilder regExString = new StringBuilder();

    public RexRegEx followedFrom(String expression) {
        regExString.append(expression);
        return this;
    }

    public RexRegEx notFollowedFrom(String expression) {
        regExString.append("(?!" + expression + ")");
        return this;
    }

    public String getRegExString() {
        return regExString.toString();
    }

    static String anyCharacter() {
        return ".";
    }

    private static void checkNotNull(Object... values) {
        if (values == null) {
            throw new IllegalArgumentException("Eingabewerte dürfen nicht null sein.");
        }
        for (Object value : values) {
            if (value == null) {
                throw new IllegalArgumentException("Ein oder mehrere Eingabewerte sind null.");
            }
        }
    }

    public static String anyLetterFromSet(String letters) {
        checkNotNull(letters);
        return "[" + letters + "]";
    }

    public static String anyLetterFromSet(List<String> letters) {
        checkNotNull(letters);
        return "[" + String.join("", letters) + "]";
    }

    public static String anyLetterFromSet(Set<Character> letters) {
        checkNotNull(letters);
        return "[" +  String.join("", letters.stream().map(Object::toString).toArray(String[]::new)) + "]";
    }

    public static String anyLetterFromSet(Character... letters) {
        checkNotNull((Object[]) letters);
        return "[" + String.join("", Arrays.stream(letters).toArray(String[]::new)) + "]";
    }

    public static String anyLetterFromSet(String... letters) {
        checkNotNull((Object[]) letters);
        return "[" + String.join("", letters) + "]";
    }

    public static String noLetterFromSet(String letters) {
        checkNotNull(letters);
        return "[" + letters + "]";
    }

    public static String noLetterFromSet(List<String> letters) {
        checkNotNull(letters);
        return "[" + String.join("", letters) + "]";
    }

    public static String noLetterFromSet(Set<Character> letters) {
        checkNotNull(letters);
        return "[" +  String.join("", letters.stream().map(Object::toString).toArray(String[]::new)) + "]";
    }

    public static String noLetterFromSet(Character... letters) {
        checkNotNull((Object[]) letters);
        return "[" + String.join("", Arrays.stream(letters).toArray(String[]::new)) + "]";
    }

    public static String noLetterFromSet(String... letters) {
        checkNotNull((Object[]) letters);
        return "[" + String.join("", letters) + "]";
    }

    public static String or(String argumentA, String argumentB) {
        checkNotNull(argumentA);
        checkNotNull(argumentB);
        return argumentA + "|" + argumentB;
    }

    public static String charSequence(String charSequence) {
        checkNotNull(charSequence);
        return charSequence;
    }

    public static String lineEnd() {
        return "$";
    }

    public static String anyDigit() {
        return "\\d";
    }

    public static String noDigit() {
        return "\\D";
    }

    public static String whitespaceCharacter() {
        return "\\s";
    }

    public static String noWhitespaceCharacter() {
        return "\\S";
    }

    public static String severalNoWhitespaceCharacter() {
        return "\\S";
    }

    public static String wordCharacter() {
        return "\\w";
    }

    public static String noWordCharacter() {
        return "\\W";
    }

    public static String wordBoundary() {
        return "\\b";
    }

    public static String noneToInfinitelyTimes(String expression) {
        return expression + "*";
    }

    public static String oneToInfinitelyTimes(String expression) {
        return expression + "*";
    }

    public static String noneOrOneTime(String expression) {
        return expression + "?";
    }

    public static String xTimes(String expression, int numberOfTimesToOccur) {
        return expression + "{" + numberOfTimesToOccur + "}";
    }

    public static String XToYTimes(String expression, int minNumberOfTimesToOccur, int maxNumberOfTimesToOccur) {
        return expression + "{" + minNumberOfTimesToOccur + "," + maxNumberOfTimesToOccur + "}";
    }

    public static String group(String groupElementsString) {
        checkNotNull(groupElementsString);
        return "(" + groupElementsString + ")";
    }

    public static String group(List<String> groupElements) {
        checkNotNull(groupElements);
        return "(" + String.join("", groupElements) + ")";
    }

    public static String group(Set<Character> groupElements) {
        checkNotNull(groupElements);
        return "(" +  String.join("", groupElements.stream().map(Object::toString).toArray(String[]::new)) + ")";
    }

    public static String group(String... groupElement) {
        checkNotNull((Object[]) groupElement);
        return "(" + String.join("", groupElement) + ")";
    }
}
