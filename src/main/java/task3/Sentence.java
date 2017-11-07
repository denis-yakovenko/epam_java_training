package task3;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private String sentence;
    private int startPosition;
    private int endPosition;
    private List<String> words = new ArrayList<>();
    private String shortestWord = "";
    private String longestWord = "";

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public String getSentence() {
        return sentence;
    }

    public List<String> getWords() {
        return words;
    }

    public Sentence(String sentence, int startPosition, int endPosition) {
        this.sentence = sentence;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        splitIntoWords();
    }

    private void splitIntoWords() {
        words.clear();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(sentence);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(sentence.charAt(firstIndex))) {
                String word = sentence.substring(firstIndex, lastIndex);
                words.add(word);
                if (word.length() > longestWord.length()) longestWord = word;
                if (shortestWord.length() == 0 || word.length() < shortestWord.length()) shortestWord = word;
            }
        }
    }
}
