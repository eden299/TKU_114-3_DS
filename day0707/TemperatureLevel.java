package day0707;

public class TemperatureLevel {
    public static void main(String[] args) {
        int temperature = 16;

        if (temperature < 15){
            System.out.println("Cold");
        }else if (temperature < 28) {
            System.out.println("Comfortable");
        }else if (temperature >28){
            System.out.println("Hot");
        }
    }
}
