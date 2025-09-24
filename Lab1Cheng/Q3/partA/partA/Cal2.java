import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cal2 extends Cal implements AutoCloseable {
  private final PrintWriter out;

  public Cal2() throws IOException {
    // overwrite each run; use new FileWriter("log.txt", true) to append
    this.out = new PrintWriter(new FileWriter("log.txt"));
  }

  @Override
  protected void log(String message) {
    out.println(message);
    out.flush();
  }

  @Override
  public void close() {
    out.flush();
    out.close();
  }
}

