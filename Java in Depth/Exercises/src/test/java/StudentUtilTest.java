import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentUtilTest {



    @Test
    void calculateGPA() {
        int[] students = {100,101};
        char[][] grades = {{'A','A','A'},{'A','A','B'}};
        double[] gpas = StudentUtil.calculateGPA(students,grades);
        assertEquals(4.0    , gpas[0]);
        assertEquals(3.6666666666666665, gpas[1]);
    }



    @Test
    void parseText() {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        assertEquals("Walden", parse(response, "<title>","<"));
        assertEquals(1854, Integer.parseInt(parse(response, "<original_publication_year type=\"integer\">","<").strip()));
    }

    private String parse(final String text, final String startRule, final String endRule) {
        String substring = text.substring(text.indexOf(startRule) + startRule.length());
        String value = substring.substring(0, substring.indexOf(endRule));
        return value;
    }
}