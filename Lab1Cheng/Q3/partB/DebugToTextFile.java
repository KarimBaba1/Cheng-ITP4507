import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DebugToTextFile implements Debug, AutoCloseable {
    private final PrintWriter out;

    public DebugToTextFile() throws IOException {
        this.out = new PrintWriter(new FileWriter("log.txt"));
    }

    @Override
    public void log(String message) {
        out.println(message);
        out.flush();
    }

    @Override
    public void close() {
        out.flush();
        out.close();
    }
}

