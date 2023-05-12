package Assignment4;

import java.util.Locale;

public class IRUtil {
    public static int getFrequencyCount(final String term, final String doc) {
        var termLc = term.toLowerCase();
        var docLc = doc.toLowerCase();

        boolean contains = false;
        int frequencyCount = 0;
        int index = docLc.indexOf(termLc);
        while (index >= 0) {
            frequencyCount++;
            docLc = docLc.substring(index + term.length());
            index = docLc.indexOf(termLc);
        }
        return frequencyCount;
    }

    public static double termFrequency(String term, String doc) {
        int frequencyCount = getFrequencyCount(term, doc);
        int totalTermCount = getTotalNumberCount(doc);

        return (double)frequencyCount / totalTermCount;

    }

    private static int getTotalNumberCount(String doc) {
        return doc.split(" ").length;
    }
}
