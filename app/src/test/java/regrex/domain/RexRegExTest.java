package regrex.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class RexRegExTest {
    
    @Test
    public void testFollowedFrom() {
        RexRegEx rex = new RexRegEx();
        rex.followedFrom("abc");
        assertEquals("abc", rex.getRegExString(), "followedFrom() sollte den String anhängen");
    }
    
    @Test
    public void testNotFollowedFrom() {
        RexRegEx rex = new RexRegEx();
        rex.notFollowedFrom("xyz");
        assertEquals("(?!" + "xyz" + ")", rex.getRegExString(), "notFollowedFrom() sollte den negativen Lookahead anhängen");
    }
    
    @Test
    public void testChainedCalls() {
        RexRegEx rex = new RexRegEx();
        rex.followedFrom("a")
           .notFollowedFrom("b")
           .followedFrom("c");
        assertEquals("a(?!b)c", rex.getRegExString(), "Verkettete Methoden sollten zum erwarteten Regex zusammengefügt werden");
    }
    
    @Test
    public void testAnyCharacter() {
        assertEquals(".", RexRegEx.anyCharacter(), "anyCharacter() sollte '.' zurückgeben");
    }
    
    @Test
    public void testCharSequence() {
        assertEquals("test", RexRegEx.charSequence("test"), "charSequence() sollte den gleichen String zurückgeben");
    }
    
    @Test
    public void testLineEnd() {
        assertEquals("$", RexRegEx.lineEnd(), "lineEnd() sollte '$' zurückgeben");
    }

    @Test
    public void testAnyLetterFromSetWithString() {
        assertEquals("[abc]", RexRegEx.anyLetterFromSet("abc"),
                     "anyLetterFromSet(String) sollte [abc] zurückgeben");
    }
    
    @Test
    public void testAnyLetterFromSetWithList() {
        List<String> letters = Arrays.asList("a", "b", "c");
        assertEquals("[abc]", RexRegEx.anyLetterFromSet(letters),
                     "anyLetterFromSet(List<String>) sollte [abc] zurückgeben");
    }
    
    @Test
    public void testAnyLetterFromSetWithSet() {
        Set<Character> letters = new LinkedHashSet<>(Arrays.asList('a', 'b', 'c'));
        assertEquals("[abc]", RexRegEx.anyLetterFromSet(letters),
                     "anyLetterFromSet(Set<Character>) sollte [abc] zurückgeben");
    }
    
    @Test
    public void testAnyLetterFromSetWithCharVarargs() {
        assertEquals("[abc]", RexRegEx.anyLetterFromSet('a', 'b', 'c'),
                     "anyLetterFromSet(Character...) sollte [abc] zurückgeben");
    }
    
    @Test
    public void testAnyLetterFromSetWithStringVarargs() {
        assertEquals("[abc]", RexRegEx.anyLetterFromSet("a", "b", "c"),
                     "anyLetterFromSet(String...) sollte [abc] zurückgeben");
    }
    
    @Test
    public void testNoLetterFromSetWithString() {
        assertEquals("[^abc]", RexRegEx.noLetterFromSet("abc"),
                     "noLetterFromSet(String) sollte [^abc] zurückgeben");
    }
    
    @Test
    public void testNoLetterFromSetWithList() {
        List<String> letters = Arrays.asList("a", "b", "c");
        assertEquals("[^abc]", RexRegEx.noLetterFromSet(letters),
                     "noLetterFromSet(List<String>) sollte [^abc] zurückgeben");
    }
    
    @Test
    public void testNoLetterFromSetWithSet() {
        Set<Character> letters = new LinkedHashSet<>(Arrays.asList('a', 'b', 'c'));
        assertEquals("[^abc]", RexRegEx.noLetterFromSet(letters),
                     "noLetterFromSet(Set<Character>) sollte [^abc] zurückgeben");
    }
    
    @Test
    public void testNoLetterFromSetWithCharVarargs() {
        assertEquals("[^abc]", RexRegEx.noLetterFromSet('a', 'b', 'c'),
                     "noLetterFromSet(Character...) sollte [^abc] zurückgeben");
    }
    
    @Test
    public void testNoLetterFromSetWithStringVarargs() {
        assertEquals("[^abc]", RexRegEx.noLetterFromSet("a", "b", "c"),
                     "noLetterFromSet(String...) sollte [^abc] zurückgeben");
    }
    
    @Test
    public void testOr() {
        assertEquals("a|b", RexRegEx.or("a", "b"), "or() sollte a|b zurückgeben");
    }
    
    @Test
    public void testAnyDigit() {
        assertEquals("\\d", RexRegEx.anyDigit(), "anyDigit() sollte \\d zurückgeben");
    }
    
    @Test
    public void testNoDigit() {
        assertEquals("\\D", RexRegEx.noDigit(), "noDigit() sollte \\D zurückgeben");
    }
    
    @Test
    public void testWhitespaceCharacter() {
        assertEquals("\\s", RexRegEx.whitespaceCharacter(), "whitespaceCharacter() sollte \\s zurückgeben");
    }
    
    @Test
    public void testNoWhitespaceCharacter() {
        assertEquals("\\S", RexRegEx.noWhitespaceCharacter(), "noWhitespaceCharacter() sollte \\S zurückgeben");
    }
    
    @Test
    public void testSeveralNoWhitespaceCharacter() {
        assertEquals("\\S", RexRegEx.severalNoWhitespaceCharacter(),
                     "severalNoWhitespaceCharacter() sollte \\S zurückgeben");
    }
    
    @Test
    public void testWordCharacter() {
        assertEquals("\\w", RexRegEx.wordCharacter(), "wordCharacter() sollte \\w zurückgeben");
    }
    
    @Test
    public void testNoWordCharacter() {
        assertEquals("\\W", RexRegEx.noWordCharacter(), "noWordCharacter() sollte \\W zurückgeben");
    }
    
    @Test
    public void testWordBoundary() {
        assertEquals("\\b", RexRegEx.wordBoundary(), "wordBoundary() sollte \\b zurückgeben");
    }
    
    @Test
    public void testNoneToInfinitelyTimes() {
        assertEquals("abc*", RexRegEx.noneToInfinitelyTimes("abc"),
                     "noneToInfinitelyTimes() sollte 'abc*' zurückgeben");
    }
    
    @Test
    public void testOneToInfinitelyTimes() {
        assertEquals("abc*", RexRegEx.oneToInfinitelyTimes("abc"),
                     "oneToInfinitelyTimes() sollte 'abc*' zurückgeben");
    }
    
    @Test
    public void testNoneOrOneTime() {
        assertEquals("abc?", RexRegEx.noneOrOneTime("abc"),
                     "noneOrOneTime() sollte 'abc?' zurückgeben");
    }
    
    @Test
    public void testXTimes() {
        assertEquals("abc{3}", RexRegEx.xTimes("abc", 3),
                     "xTimes() sollte 'abc{3}' zurückgeben");
    }
    
    @Test
    public void testXToYTimes() {
        assertEquals("abc{2,5}", RexRegEx.XToYTimes("abc", 2, 5),
                     "XToYTimes() sollte 'abc{2,5}' zurückgeben");
    }
    
    @Test
    public void testGroupWithString() {
        assertEquals("(abc)", RexRegEx.group("abc"),
                     "group(String) sollte '(abc)' zurückgeben");
    }
    
    @Test
    public void testGroupWithList() {
        List<String> elements = Arrays.asList("a", "b", "c");
        assertEquals("(abc)", RexRegEx.group(elements),
                     "group(List<String>) sollte '(abc)' zurückgeben");
    }
    
    @Test
    public void testGroupWithSet() {
        Set<Character> elements = new LinkedHashSet<>(Arrays.asList('a','b','c'));
        assertEquals("(abc)", RexRegEx.group(elements),
                     "group(Set<Character>) sollte '(abc)' zurückgeben");
    }
    
    @Test
    public void testGroupWithVarargs() {
        assertEquals("(abc)", RexRegEx.group("a", "b", "c"),
                     "group(String...) sollte '(abc)' zurückgeben");
    }
    
    @Test
    public void testAnyLetterFromSet_StringNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RexRegEx.anyLetterFromSet((String) null);
        });
        assertEquals("Ein oder mehrere Eingabewerte sind null.", exception.getMessage(),
                     "Bei null als Eingabe muss die entsprechende Exception geworfen werden");
    }
    
    @Test
    public void testAnyLetterFromSet_ListWithNull() {
        List<String> letters = Arrays.asList("a", null, "c");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RexRegEx.anyLetterFromSet(letters);
        });
        assertEquals("Ein oder mehrere Eingabewerte sind null.", exception.getMessage(),
                     "Eine Liste mit null-Elementen sollte eine Exception werfen");
    }
    
    @Test
    public void testNoLetterFromSet_VarargsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RexRegEx.noLetterFromSet((String[]) null);
        });
        assertEquals("Eingabewerte dürfen nicht null sein.", exception.getMessage(),
                     "null als Array sollte zu einer Exception führen");
    }
    
    @Test
    public void testComplexRegexBuilding() {
        RexRegEx regexBuilder = new RexRegEx();
        regexBuilder.followedFrom(RexRegEx.anyLetterFromSet("abc"))
                    .followedFrom(new RexRegEx().notFollowedFrom("abc").getRegExString())
                    .followedFrom(RexRegEx.anyDigit())
                    .followedFrom(RexRegEx.group(RexRegEx.wordCharacter()))
                    .followedFrom(RexRegEx.xTimes(RexRegEx.wordCharacter(), 3));
                    
        String actualRegex = regexBuilder.getRegExString();
        String expectedRegex = "[abc]" + "(?!abc)" + "\\d" + "(" + "\\w" + ")" + "\\w{3}";
        assertEquals(expectedRegex, actualRegex,
                     "Der komplex zusammengebaute Regex muss dem erwarteten Muster entsprechen");
    }
    
    @Test
    public void testComplexRegexWithOrAndGrouping() {
        String groupPart = RexRegEx.group(RexRegEx.or(RexRegEx.anyLetterFromSet("abc"), RexRegEx.anyDigit()));
        String regex = new RexRegEx().followedFrom(groupPart)
                                     .followedFrom(new RexRegEx().notFollowedFrom(RexRegEx.whitespaceCharacter()).getRegExString())
                                     .getRegExString();
        String expected = groupPart + "(?!"
                          + RexRegEx.whitespaceCharacter() + ")";
        assertEquals(expected, regex,
                     "Der kombinierte Regex mit OR und Gruppierung muss korrekt zusammengebaut sein");
    }
}
