// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
// Split string from https://www.geeksforgeeks.org/split-string-java-examples/
// Indexof from https://www.w3schools.com/java/ref_string_indexof.asp
// Substring from https://www.tutorialspoint.com/Java-String-substring-Method-example/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
  /**
   * Returns a list of links found in the given markdown file.
   *
   * @param markdown the markdown file to parse
   * @return an ArrayList of links found in the given markdown file
   */
  public static ArrayList<String> getLinks(String markdown) {
    ArrayList<String> toReturn = new ArrayList<>();
    String[] lines = markdown.split("\n");
    for (String line : lines) {
      if (determineLink(line)) {
        toReturn.add(returnLink(line));
      }
    }
    return toReturn;
  }

  /**
   * Determines whether or not the given line is a link.
   *
   * @param line the line to check
   * @return true if the line is a link, false otherwise
   */
  public static boolean determineLink(String line) {
    // markdown link requires "[", "]", "(" and ")"
    if (line.contains("[") && line.contains("]") && line.contains("(") && line.contains(")")) {
      // check if line contains a ] that follows a [ or a ) that follows a (
      int indexOfBracket = line.indexOf("]", line.indexOf("["));
      int indexOfParen = line.indexOf(")", line.indexOf("("));
      if (indexOfBracket == -1 || indexOfParen == -1) {
        // if there is no ] after the [ or no ) after the (, then it is not a
        // link
        return false;
      }
      // if the the letter directly after ] is not (, then it is not a link
      if (line.charAt(indexOfBracket + 1) != '(') {
        return false;
      }
      // if the letter ! exists and is directly before [, it is an image and
      // not a link
      if (line.contains("!") && line.indexOf("!") + 1 == line.indexOf("[")) {
        return false;
      }
      // if letter ) imemdiately follows ), empty link, return false
      if (line.charAt(line.indexOf('(') + 1) == ')') {
        return false;
      }
      return true;
    }
    return false;
  }

  /**
   * Returns the link found in the given markdown line.
   *
   * @param line the line to parse
   * @return the link found in the given markdown line
   */
  public static String returnLink(String line) {
    String link = "";
    // get the text between the ( and the )
    link = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
    if (link.contains(" ")) {
      link = link.substring(0, link.indexOf(" "));
    }
    // throw error if link is not formatted correctly
    if (!determineLink(line)) {
      throw new IllegalArgumentException("Link is not formatted correctly");
    }
    return link;
  }

  /**
   * Returns a list of links found in the given markdown file.
   *
   * @param args the markdown file to parse
   */
  public static void main(String[] args) throws IOException {
    Path fileName = Path.of(args[0]);
    String contents = Files.readString(fileName);
    ArrayList<String> links = getLinks(contents);
    System.out.println(links);
  }
}
