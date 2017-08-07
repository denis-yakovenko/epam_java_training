package task3;

import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Text {
    private StringBuffer text;
    private List<Sentence> sentences = new ArrayList<>();
    private Map<String, Integer> frequencyDictionary = new HashMap<>();

    public StringBuffer getText() {
        return text;
    }

    public Map<String, Integer> getFrequencyDictionary() {
        return frequencyDictionary;
    }

    public Text(StringBuffer text) {
        this.text = text;
        analyze();
    }

    private void analyze() {
        splitIntoSentences();
        calculateFrequencyDictionary();
    }

    private void splitIntoSentences() {
        sentences.clear();
        Pattern abbreviations = Pattern.compile("\\b(Mrs?|Dr|Rev|Mr|Ms|st)\\.$", Pattern.CASE_INSENSITIVE);
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        sentenceIterator.setText(text.toString());
        int start = sentenceIterator.first();
        StringBuilder sb = new StringBuilder();
        int sentenceStart = start;
        int sentenceEnd;
        boolean newSentence = true;
        for (int end = sentenceIterator.next(); end != BreakIterator.DONE; start = end, end = sentenceIterator.next()) {
            if (newSentence) {
                sentenceStart = start;
            }
            sb.append(text.substring(start, end).trim());
            String sentence = sb.toString();
            if (!abbreviations.matcher(sentence).find()) {
                newSentence = true;
                sb.setLength(0);
            } else {
                newSentence = false;
                sb.append(" ");
            }
            if (newSentence) {
                sentenceEnd = end;
                sentences.add(new Sentence(sentence, sentenceStart, sentenceEnd));
                sentenceStart = start;
            }
        }
    }

    public String getFirstUniqueWordInText() {
        for (Sentence sentence : sentences
                ) {
            for (String word : sentence.getWords()
                    ) {
                int hitCount = 0;
                for (Sentence sentence1 : sentences
                        ) {
                    for (String word1 : sentence1.getWords()
                            ) {
                        if (word1.equalsIgnoreCase(word)) hitCount++;
                    }
                }
                if (hitCount == 1) {
                    return word;
                }
            }
        }
        return null;
    }

    public void replaceShortestWordWithLongestInEachSentence() {
        for (int i = sentences.size() - 1; i >= 0; i--) {
            String sentence = text.substring(
                    sentences.get(i).getStartPosition(),
                    sentences.get(i).getEndPosition());
            sentence = sentence.replaceAll(
                    "\\b" + sentences.get(i).getShortestWord() + "\\b",
                    sentences.get(i).getLongestWord());
            text.replace(
                    sentences.get(i).getStartPosition(),
                    sentences.get(i).getEndPosition(),
                    sentence);
        }
        analyze();
    }

    private void calculateFrequencyDictionary() {
        for (Sentence sentence : sentences
                ) {
            for (String word : sentence.getWords()
                    ) {
                frequencyDictionary.put(word, frequencyDictionary.getOrDefault(word, 0) + 1);
            }
        }
        frequencyDictionary = frequencyDictionary.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
