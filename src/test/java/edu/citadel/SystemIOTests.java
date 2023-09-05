package edu.citadel;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SystemIOTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }



    @Test
    public void shouldComputeSum() {
        String consoleInput = "5 7";
        InputStream in = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(in);
        App.main(null);
        String result = outContent.toString();
        assertTrue(result.contains("12-Thank You.".replaceAll("-", System.lineSeparator())));
    }
}