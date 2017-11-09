
package rommel;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import javax.swing.JTextArea;

public class Mostrar extends OutputStream {

    private final PipedOutputStream out = new PipedOutputStream();
    private final Reader reader;
    private final JTextArea JTextArea2;

    public Mostrar(JTextArea area) throws IOException {
        this.JTextArea2 = area;
        PipedInputStream in = new PipedInputStream(out);
        reader = new InputStreamReader(in, "UTF-16");
    }

    @Override
    public void write(int i) throws IOException {
        out.write(i);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        out.write(bytes, i, i1);
    }

    @Override
    public void flush() throws IOException {
        String content;
        if (reader.ready()) {
            char[] chars = new char[1024];
            int n = reader.read(chars);
            content = new String(chars, 0, n);
            JTextArea2.append(content);
        }
    }   
}
