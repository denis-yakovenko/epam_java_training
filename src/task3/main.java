package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {
    public static void main(String[] args) throws IOException {
        Text text = new Text(
                new StringBuffer(
                        new String(
                                Files.readAllBytes(Paths.get("src/task3/input.txt")))));
        /*int i = 0;
        for (Sentence sentence : text.getSentences()
                ) {
            i++;
            System.out.println("sentence: " + i + " " + sentence.getSentence());
            System.out.println("shortest: " + sentence.getShortestWord()+", longest: " + sentence.getLongestWord());
            System.out.println("start-end: " + sentence.getStartPosition()+" - " + sentence.getEndPosition());
            int j = 0;
            for (String word : sentence.getWords()
                    ) {
                j++;
                System.out.println("word: " + j + " " + word);
            }
        }*/
        System.out.println("first unique word: " + text.getFirstUniqueWordInText());
        text.replaceShortestWordWithLongestInEachSentence();
        Files.write(Paths.get("src/task3/output.txt"),text.getText().toString().getBytes());
        text.getFrequencyDictionary().forEach((k,v)->System.out.println("word: "+k+", frequency: "+v));
    }
}
