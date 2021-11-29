public class Converter {
    private Double celsius;
    private Double fahrenheit;
    private Double kelvin;
    private String input;


    public Converter(Double celsius, Double fahrenheit, Double kelvin, String input) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
        this.input = input;
    }

    public void result() {
        char[] convertFlags = input.toCharArray();
        if (celsius != null) {
            for (char flag : convertFlags) {
                if (flag == 'f') {
                    celsiusToFahrenheit();
                } else if (flag == 'k') {
                    celsiusToKelvin();
                }
            }
        }
    }

    private void celsiusToFahrenheit(){
        double value = celsius * 1.8 + 32;
        System.out.println(String.format("Fahrenheit value: %.3f",value));
    }

    private void celsiusToKelvin(){
        double value = celsius + 273.15;
        System.out.println(String.format("Kelvin value: %.3f",value));
    }
}
