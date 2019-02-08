import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().validIPAddress("2.34.43.25"));
}

    public boolean validIPAddress(String IP) {
       //return IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");
        return IP.matches("[0-255]\\.[0-255]\\.[0-255]\\.[0-255]");
    }

}





