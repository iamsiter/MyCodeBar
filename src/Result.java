
import java.util.*;

class Result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = 0;
        double[] input = new double[5];
        for (String c : s.split("\\s+")) {
            input[k++] = Double.parseDouble(c.trim());
        }

        double result = 0;
        for (int i = 1; i <= 5; i++) {

            result += (input[i - 1] * Math.log(2) / Math.log(i + 1));

        }

        System.out.println(result);
    }
}