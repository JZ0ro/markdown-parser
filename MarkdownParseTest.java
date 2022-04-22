import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {
    String[] testFile1Output = {"https://something.com", "some-thing.html"};
    ArrayList<String> stringOutput = new ArrayList<String>();
    List string = Arrays.asList(testFile1Output);
    
    
    @Test
    public void addition() { // Tester method
        assertEquals(2, 1 + 1); // Determines whether or not our users input equals the expected output of 2
    }

    @Test
    public void linkGetter () throws IOException {
        Path fileName = Paths.get("C:/Users/Justin/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(fileName);

        MarkdownParse linkTester = new MarkdownParse();
        ArrayList<String> links = linkTester.getLinks(content);
        assertEquals("Link printed out should be the same",string.get(0),  links.get(0));
        assertEquals("link printed out should be the the same", string.get(1), links.get(1));
    }
}