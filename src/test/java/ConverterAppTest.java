import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterAppTest {

    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void outputToStream() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void requestWithHelp(){
        String input = "-help\n-c 40 fk";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        ConverterApp.launch();
        String[] consoleOut = output.toString().split("\n");
        try(FileReader fileReader = new FileReader("."+File.separator+"file"+File.separator+"helpTest.txt"))
        {
            BufferedReader reader = new BufferedReader(fileReader);
        assertTrue(comparison(reader,consoleOut));
        }
        catch(IOException e){
            System.out.println("Test file not found");
        }
    }

    public boolean comparison(BufferedReader reader,String[] consoleOut) throws IOException{
        int i = 0;
        String line = reader.readLine();
        while (line != null) {
            if (!line.trim().equals(consoleOut[i].trim())) return false;
            line = reader.readLine();
            i++;
        }
        return true;
    }

    @Test
    public void request(){
        String input = "-f 222 kc";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        String[] answer = {"Enter the command or use -help:", "Kelvin value: 378,706", "Celsius value: 105,556"};
        ConverterApp.launch();
        String[] consoleOut = output.toString().split("\r\n");
        assertArrayEquals(answer, consoleOut);
    }

    @Test
    public void requestWithError(){
        String input = "-c fk 99";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        String[] answer = {"Enter the command or use -help:", "Error reading input data. Call -help to learn about service"};
        ConverterApp.launch();
        String[] consoleOut = output.toString().split("\r\n");
        assertArrayEquals(answer, consoleOut);
    }
}
