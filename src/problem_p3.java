/*
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
https://www.programiz.com/dsa/longest-common-subsequence
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P3 {

    void printLCS(String X, String Y) {
        int lenX = X.length();
        int lenY = Y.length();
        int[][] matrix = new int[lenX + 1][lenY + 1];

        for (int i = 0; i < lenX + 1; i++) {
            for (int j = 0; j < lenY + 1; j++) {
                if (i == 0 || j == 0) matrix[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
        }
        ArrayList<Character> result = matrixBacktrack(matrix, X, Y, X.length(), Y.length());
        Collections.reverse(result); // reverse array list
        for (Character character : result) System.out.print(character);
    }

    ArrayList<Character> matrixBacktrack(int[][] matrix, String str1, String str2, int i, int j) {
        ArrayList<Character> result = new ArrayList<>();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                result.add(str1.charAt(i - 1));
                i--;
                j--;
            } else if (matrix[i - 1][j] > matrix[i][j - 1]) i--;
            else j--;
        }
        return result;
    }

    public static void main(String[] args) {
        P3 problem_p2 = new P3();
        Scanner in = new Scanner(System.in);

        String X = in.nextLine();
        String Y = in.nextLine();

        problem_p2.printLCS(X, Y);
    }
}
