import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarkdownParseTest {
    String[] testFile1Output = {"www.skylanders", " www.roblox.com"};
    ArrayList<String> stringOutput = new ArrayList<String>();
    List string = Arrays.asList(testFile1Output);
    boolean test = true;

    
    
    @Test
    public void addition() { // Tester method
        assertEquals(2, 1 + 1); // Determines whether or not our users input equals the expected output of 2
    }

    @Test
    public void linkGetter () throws IOException {
        Path fileName = Paths.get("C:/Users/Justin/Documents/GitHub/markdown-parser/test-file5.md");
        String content = Files.readString(fileName);

        MarkdownParse linkTester = new MarkdownParse();
        ArrayList<String> links = linkTester.getLinks(content);
        assertEquals("Link printed out should be the same",string.get(0),  links.get(0));
    }
    @Test
    public void test() {
        assertEquals("Boolean inputted should be true", true, test);
    }

    @Test
    public void falseLinkTest() throws IOException {
        Path fileName = Paths.get("C:/Users/Justin/Documents/GitHub/markdown-parser/test-file5.md");
        String content = Files.readString(fileName);

        MarkdownParse linkTester = new MarkdownParse();
        ArrayList<String> links = linkTester.getLinks(content);
        try {
            links.get(1);
            fail();
        } catch(IndexOutOfBoundsException e) {
            System.out.println("index 1 should not exist");
            System.out.println("index one million should not exist");
        }
    }
}