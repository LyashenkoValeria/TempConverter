import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConverterApp {
    private static Double celsius = null;
    private static Double fahrenheit = null;
    private static Double kelvin = null;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();

            String[] commandParts = command.split(" ",3);

            switch (commandParts[0]){
                case "-c": celsius = Double.parseDouble(commandParts[1]); break;
                case "-f": fahrenheit = Double.parseDouble(commandParts[1]); break;
                case "-k": kelvin = Double.parseDouble(commandParts[1]); break;
            }

            Converter converter = new Converter(celsius, fahrenheit, kelvin, commandParts[2]);
        } catch (IOException e){
            System.out.println("Error reading input data");
        }
    }
}
