package sequenceResemblance;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SequenceReader {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.nextLine();

    protected static int getParts(String word) {
        return IntStream.range(0, word.length())
                .boxed()
                .map(integer -> word.substring(integer))
                .mapToInt(sequence -> countSimilarLetters(word, sequence))
                .sum();
    }

    private static long countSimilarLetters(String word, String sequence) {
        return IntStream.range(0, sequence.length())
                .boxed()
                .filter(n -> word.charAt(n) == sequence.charAt(n))
                .count();
    }


    public static void main(String[] args) {
        System.out.println(getParts("ababaa"));
        System.out.println("---------");
        System.out.println(countSimilarLetters("ababaa", "abaa"));

    }
}

