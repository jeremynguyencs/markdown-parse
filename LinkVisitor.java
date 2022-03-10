import java.util.ArrayList;
import org.commonmark.node.*;

public class LinkVisitor extends AbstractVisitor {
  public ArrayList<String> links = new ArrayList<>();

  /** Constructor for LinkVisitor. */
  public LinkVisitor() {
    super();
  }

  /**
   * Getter for links.
   *
   * @return links
   */
  public ArrayList<String> getLinks() {
    return links;
  }

  /**
   * Visitor method for Link.
   *
   * @param link Link
   */
  public void visit(Link link) {
    String url = link.getDestination();
    links.add(url);
  }
}
