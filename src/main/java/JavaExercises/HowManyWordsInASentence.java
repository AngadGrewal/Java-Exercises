package JavaExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * you're given a string sentence filled with words and punctuation. If the word
 * ends in a comma, full stop, question or exclamation mark its the end of the
 * sentence. 1232 or fw0ewfw are not words. Write a program to return the number
 * of words in the sentence
 * 
 * @author Angad
 *
 */
public class HowManyWordsInASentence {

	private HowManyWordsInASentence() {
		throw new IllegalStateException("Utility class");
	}

	public static int numberOfWordsInSentence(String sentence) {
		String[] punctuations = { ",", "?", "!", "." };
		Optional<Integer> minIndex = Arrays.asList(punctuations).stream()
				.map(punctuation -> sentence.indexOf(punctuation))
				.filter(index -> index >= 0)
				.min(Comparator.naturalOrder());

		int endIndex = (minIndex.isPresent()) ? minIndex.get() : -1;
		if (endIndex == -1)
			throw new IllegalArgumentException("Sentence \"" + sentence + "\" is not a valid sentence");

		List<String> wordsList = Arrays.asList(sentence.substring(0, endIndex).split(" "));
		return wordsList.stream()
				.filter(w -> !w.matches(".*\\d.*"))
				.filter(w -> !w.isEmpty())
				.collect(Collectors.toList())
				.size();
	}
}
