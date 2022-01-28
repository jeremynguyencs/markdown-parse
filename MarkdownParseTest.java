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
  public void markdownTest() {
    try {
      String contents = Files.readString(Path.of("test-file.md"));
      ArrayList<String> links = MarkdownParse.getLinks(contents);
      List<String> expected = List.of("https://something.com", "some-page.html");
      assertEquals(expected, links);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}