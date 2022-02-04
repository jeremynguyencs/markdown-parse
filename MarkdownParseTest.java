import static org.junit.Assert.*;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for tests for MarkdownParse.java
 */
public class MarkdownParseTest {
  @Test
  public void addition() {
    // This should fail
    assertEquals(6, 1 + 1);
  }

  @Test
  public void markdownTest() throws IOException {
    String contents = Files.readString(Path.of("test-file.md"));
    ArrayList<String> links = MarkdownParse.getLinks(contents);
    List<String> expected = List.of("https://something.com", "some-page.html");
    assertEquals("Should have expected links", expected, links);
  }

  @Test
  public void markdownTest2() throws IOException {
    String contents = Files.readString(Path.of("/Users/jeremy/Documents/Github/markdown-parse/test-file-2.md"));
    ArrayList<String> links = MarkdownParse.getLinks(contents);
    ArrayList<String> expected = new ArrayList<>();
    assertEquals("Should have expected links", expected, links);
  }

  @Test
  public void markdownTest3() throws IOException {
    String contents = Files.readString(Path.of("/Users/jeremy/Documents/Github/markdown-parse/test-file-3.md"));
    ArrayList<String> links = MarkdownParse.getLinks(contents);
    ArrayList<String> expected = new ArrayList<>();
    assertEquals("Should have expected links", expected, links);
  }

  @Test
  public void markdownTestDetermineLink() {
    boolean test1 = MarkdownParse.determineLink("[test](https://i_am_a_link)");
    boolean test2 = MarkdownParse.determineLink("![test](https://i_am_an image)");
    boolean test3 = MarkdownParse.determineLink("[hi]");
    assertTrue("Test was supposed to be true", test1);
    assertFalse("Test was supposed to be false", test2);
    assertFalse("Test was supposed to be false", test3);
  }

  @Test
  public void markdownTestReturnLink() {
    String test1 = MarkdownParse.returnLink("[test](https://i_am_a_link)");
    String test2 = MarkdownParse.returnLink("[hi](#joebiden)");
    String test3 = MarkdownParse.returnLink("[hi](howdy)");
    assertEquals("Did not return correct link", "https://i_am_a_link", test1);
    assertEquals("Did not return correct link", "#joebiden", test2);
    assertEquals("Did not return correct link", "howdy", test3);
  }

  @Test
  public void markdownTestNewTests() {
    List<String> expected = List.of("https://something.com", "some-page.html");
    List<String> expected2 = List.of("https://something.com", "some-page.html");
    List<String> expected3 = new ArrayList<String>();
    List<String> expected4 = new ArrayList<String>();
    List<String> expected5 = new ArrayList<String>();
    List<String> expected6 = new ArrayList<String>();
    List<String> expected7 = new ArrayList<String>();
    List<String> expected8 = List.of("a link on the first line");
    // A list of lists of each file's expected links
    List<List<String>> expectedOutputs = List.of(expected, expected2, expected3, expected4, expected5, expected6, expected7, expected8);

    // Loop through each file and add their path to a list
    File[] files = new File("/Users/jeremy/Documents/Github/markdown-parse/new_tests").listFiles();
    ArrayList<Path> paths = new ArrayList<>();
    for (File file : files) {
      paths.add(file.toPath());
    }
    // Sort the paths since for some reason it's not in alphabetical order
    paths.sort(null);

    // Loop through each file and test the expected links
    int index = 0;
    for (Path path : paths) {
      String contents = null;
      try {
        contents = Files.readString(path);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Should have expected links", expectedOutputs.get(index), links);
        index++;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}