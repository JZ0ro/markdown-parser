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

    @Test
    public void snippetTest1() throws IOException {
        Path fileName = Paths.get("C:/Users/justi/Desktop/github folder/markdown-parser/Snippet-1.md");
        String[] snippet2Output = {"`google.com", "google.com", "ucsd.edu"};
        String fileContent = Files.readString(fileName);

        MarkdownParse linkTester = new MarkdownParse();
        ArrayList<String> links = linkTester.getLinks(fileContent);
        List expectedLinks = Arrays.asList(snippet2Output);

        assertEquals("Link printed out should be the same", expectedLinks.get(0), links.get(0));
        assertEquals("Link printed out should be the same", expectedLinks.get(1), links.get(1));
        assertEquals("Link printed out should be the same", expectedLinks.get(2), links.get(2));
    }

    @Test
    public void snippetTest2() throws IOException {
        Path fileName = Paths.get("C:/Users/justi/Desktop/github folder/markdown-parser/Snippet-2.md");
        String[] snippet2Output = {"a.com", "a.com(())", "example.com"};
        String fileContent = Files.readString(fileName);

        MarkdownParse linkTester = new MarkdownParse();
        ArrayList<String> links = linkTester.getLinks(fileContent);
        List expectedLinks = Arrays.asList(snippet2Output);

        assertEquals("Link printed out should be the same", expectedLinks.get(0), links.get(0));
        assertEquals("Link printed out should be the same", expectedLinks.get(1), links.get(1));
        assertEquals("Link printed out should be the same", expectedLinks.get(2), links.get(2));
    }

    @Test
    public void snippetTest3() throws IOException {
        Path fileName = Paths.get("C:/Users/justi/Desktop/github folder/markdown-parser/Snippet-3.md");
        String[] snippet3Output = {"https://www.twitter.com", "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "(https://cse.ucsd.edu/"};
        String fileContent = Files.readString(fileName);

        MarkdownParse linkTester = new MarkdownParse();
        ArrayList<String> links = linkTester.getLinks(fileContent);
        List expectedLinks = Arrays.asList(snippet3Output);

        assertEquals("Link printed out should be the same", expectedLinks.get(0), links.get(0));
        assertEquals("Link printed out should be the same", expectedLinks.get(1), links.get(1));
        assertEquals("Link printed out should be the same", expectedLinks.get(2), links.get(2));
    }
}