import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for tests for MarkdownParse.java
 */
public class MarkdownParseTest {
  @Test
  public void addition() {
    assertEquals(2, 1 + 1);
  }

  @Test
  public void markdownTest() throws IOException {
    String contents = Files.readString(Path.of("/Users/jeremy/Documents/Github/markdown-parse/test-file.md"));
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
}