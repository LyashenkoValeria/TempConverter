import java.io.*;
import java.util.Arrays;

public class ConverterApp {
    private static Double celsius = null;
    private static Double fahrenheit = null;
    private static Double kelvin = null;

    public static void main(String[] args) {
        launch();
    }

    public static void launch(){
        try {
            System.out.println("Enter the command or use -help:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command = reader.readLine();

            if (command.equals("-help")) {
                help();
                System.out.println("\n\nEnter your command:");
                command = reader.readLine();
            }

            String[] commandParts = command.split(" ",3);

            switch (commandParts[0]){
                case "-c": celsius = Double.parseDouble(commandParts[1]); break;
                case "-f": fahrenheit = Double.parseDouble(commandParts[1]); break;
                case "-k": kelvin = Double.parseDouble(commandParts[1]); break;
            }

            Converter converter = new Converter(celsius, fahrenheit, kelvin, commandParts[2]);
            converter.result();
        } catch (Exception e){
            System.out.println("Error reading input data. Call -help to learn about service");
        }
    }

    private static void help(){
        try(FileReader fileReader = new FileReader("."+File.separator+"file"+File.separator+"help.txt"))
        {
            char[] buffer = new char[256];
            int c;
            while((c = fileReader.read(buffer))>0){
                if(c < 256){
                    buffer = Arrays.copyOf(buffer, c);
                }
                System.out.print(buffer);
            }
        }
        catch(IOException e){
            System.out.println("File read error");
        }
    }
}
