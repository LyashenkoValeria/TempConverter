import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConverterTest {

    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void outputToStream() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void celsiusToFahrenheitTest(){
        Converter converter = new Converter(40.0,null,null,"f");
        converter.result();
        Assert.assertEquals("Fahrenheit value: 104,000",output.toString().trim());
    }

    @Test
    public void celsiusToKelvinTest(){
        Converter converter = new Converter(0.0,null,null,"k");
        converter.result();
        Assert.assertEquals("Kelvin value: 273,150",output.toString().trim());
    }

    @Test
    public void fahrenheitToCelsiusTest(){
        Converter converter = new Converter(null,-451.0,null,"c");
        converter.result();
        Assert.assertEquals("Celsius value: -268,333",output.toString().trim());
    }

    @Test
    public void fahrenheitToKelvinTest(){
        Converter converter = new Converter(null,451.0,null,"k");
        converter.result();
        Assert.assertEquals("Kelvin value: 505,928",output.toString().trim());
    }

    @Test
    public void kelvinToCelsiusTest(){
        Converter converter = new Converter(null,null,57.0,"c");
        converter.result();
        Assert.assertEquals("Celsius value: -216,150",output.toString().trim());
    }

    @Test
    public void kelvinToFahrenheitTest(){
        Converter converter = new Converter(null,null,57.0,"f");
        converter.result();
        Assert.assertEquals("Fahrenheit value: -357,070",output.toString().trim());
    }

    @Test
    public void celsiusToBothTest(){
        Converter converter = new Converter(100.0, null,null,"fk");
        converter.result();
        Assert.assertEquals("Fahrenheit value: 212,000\r\nKelvin value: 373,150",output.toString().trim());
    }

    @Test
    public void fahrenheitToBothTest(){
        Converter converter = new Converter(null, -5.0,null,"ck");
        converter.result();
        Assert.assertEquals("Celsius value: -20,556\r\nKelvin value: 252,594",output.toString().trim());
    }

    @Test
    public void kelvinToBothTest(){
        Converter converter = new Converter(null, null,-1234.0,"cf");
        converter.result();
        Assert.assertEquals("Celsius value: -1507,150\r\nFahrenheit value: -2680,870",output.toString().trim());
    }
}
