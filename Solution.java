import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        StringBuffer noSpaces = new StringBuffer();
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                noSpaces.append(s.charAt(i));
            }
        }
        double root = Math.sqrt(noSpaces.length());
        double a;
        double b;
        if (root % 1 == 0) {
            a = root;
            b = root;
        } else {
            a = Math.floor(root);
            b = Math.ceil(root);
            if ((a * b) < noSpaces.length()) {
                a++;
            }
        }
        StringBuffer[] resultGrid = new StringBuffer[(int) b];
        for (i = 0; i < b; i++) {
            resultGrid[i] = new StringBuffer();
        }
        for (i = 0; i < noSpaces.length(); i++) {
            resultGrid[i % resultGrid.length].append(noSpaces.charAt(i));
        }
        StringBuffer result = new StringBuffer();
        for (i = 0; i < resultGrid.length; i++) {
            result.append(resultGrid[i].toString() + " ");
        }
        return result.toString().trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
