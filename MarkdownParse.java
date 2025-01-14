import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket); 
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            
        }
        CharSequence www = "www";
        CharSequence https = "https://";
        CharSequence com = ".com";
        CharSequence commitTester = "Line to be seen as a new commit";
        for (int i = 0; i < toReturn.size(); i++) {
            // loops through links and checks if they have valid URL's
            String link = toReturn.get(i);
            if (link.contains(" ")) {
                toReturn.remove(i);
                continue;
            } if (link.contains(www) == true || link.contains(https) == true || link.contains(com)) {
                continue;
            } else {
                toReturn.remove(i);
            }
        }
        int arraySize = toReturn.size();
        System.out.println(arraySize);
        
        
        return toReturn;
    }
    

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
        System.out.println(links.get(0));

    }
}
