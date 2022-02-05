/*
https://www.geeksforgeeks.org/java-program-for-matrix-chain-multiplication-dp-8/
https://medium.com/javarevisited/implementation-of-matrix-chain-multiplication-using-dynamic-programming-in-java-e8828c1e9f9b
https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class P1 {
    void assignTable(ArrayList<String> inputs){
        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Character> letters = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) { // Store the values on each array
            String[] temp = inputs.get(i).split("\\s");
            letters.add(temp[0].charAt(0)); // Store the symbol
            original.add(Integer.parseInt(temp[1])); // Store X
            original.add(Integer.parseInt(temp[2])); // Store Y
        }

        ArrayList<Integer> nums = properDim(original);
        if(nums.get(0) == -1){ // Input error check
            System.out.println("Invalid matrix");
            return;
        }
        int numsSize = nums.size();
        int[][] matrix = new int[numsSize][numsSize];
        int[][] parSequence = new int[numsSize][numsSize];


        for(int i = 1; i < numsSize; i++)
            matrix[i][i] = 0;
        // L is chain length.
        for(int L = 2; L < numsSize; L++)
        {
            for(int i = 1; i < numsSize - L + 1; i++)
            {
                int j = i + L - 1;
                matrix[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++)
                {

                    // q = cost/scalar multiplications
                    int q = matrix[i][k] + matrix[k + 1][j] +
                        nums.get(i-1) * nums.get(k) * nums.get(j);

                    if (q < matrix[i][j])
                    {
                        matrix[i][j] = q;

                        // Each entry bracket[i,j]=k shows
                        // where to split the product arr
                        // i,i+1....j for the minimum cost.
                        parSequence[i][j] = k;
                    }
                }
            }
        }

        ArrayList<Character> parenthesisFormat = new ArrayList<>();
        int parCount = -1;
        parFormat(1, numsSize-1, parSequence, letters, parenthesisFormat, parCount);
        for (Character character : parenthesisFormat) System.out.print(character);

    }

    void parFormat(int i, int j,
                                 int[][] matrix, ArrayList<Character> letters, ArrayList<Character> parFinal, int parCounter)
    {
        // If only one matrix left in current segment
        if (i == j)
        {
            parFinal.add(letters.get(0));
            letters.remove(0);
            return;
        }
        parCounter++;
        if(parCounter!=0)
            parFinal.add('(');
        parFormat(i, matrix[i][j], matrix, letters, parFinal, parCounter);

        parFormat(matrix[i][j] + 1, j, matrix,letters, parFinal, parCounter);
        if(parCounter!=0)
            parFinal.add(')');
    }

    ArrayList<Integer> properDim(ArrayList<Integer> original){
        ArrayList<Integer> trimmed = new ArrayList<>();
            trimmed.add(original.get(0));
            for(int i = 1; i < original.size()-1; i++){
                if(original.get(i) == original.get(i+1)){
                    trimmed.add(original.get(i));
                    i++; // Skip to next number
                }
                else
                    trimmed.add(0, -1); // Add error check value at the start
            }
            trimmed.add(original.get(original.size()-1));
        return trimmed;
    }
    // Driver code
    public static void main(String[] args) {
        P1 problem_p1 = new P1();
        ArrayList<String> inputs = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        inputs.add(in.nextLine()); // First input
        int size = Integer.parseInt(inputs.get(0));
        inputs.clear(); // Empty
        for (int i = 0; i < size; i++)
            inputs.add(in.nextLine());

        problem_p1.assignTable(inputs);
    }
}
