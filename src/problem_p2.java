import java.util.ArrayList;
import java.util.Scanner;

public class P2 {

    void partyBudget(ArrayList<String> inputs) {
        String[] initial = inputs.get(0).split("\\s");
        int budget = Integer.parseInt(initial[0]);
        int[] cost = new int[inputs.size() - 1];
        int[] fun = new int[inputs.size() - 1];
        int[][] matrix = new int[inputs.size()][budget + 1];

        for (int i = 1; i < inputs.size(); i++) { // Store the values on each array
            String[] temp = inputs.get(i).split("\\s");
            cost[i - 1] = Integer.parseInt(temp[0]);
            fun[i - 1] = Integer.parseInt(temp[1]);
        }
        inputs.remove(0); // Remove initial input

        for (int i = 0; i <= inputs.size(); i++) {
            for (int j = 0; j <= budget; j++) {
                if (i == 0 || j == 0) //Empty
                    matrix[i][j] = 0;
                else if (cost[i - 1] <= j) {
                    matrix[i][j] = Math.max(fun[i - 1] + matrix[i - 1][j - cost[i - 1]], matrix[i - 1][j]);
                } else matrix[i][j] = matrix[i - 1][j];
            }
        }
        int spent = 0;
        int budgetIndex = budget;

        for (int inputIndex = inputs.size(); inputIndex > 0; inputIndex--) {
            if (matrix[inputIndex][budgetIndex] != matrix[inputIndex - 1][budgetIndex]) {
                budgetIndex = budgetIndex - cost[inputIndex - 1];
                spent += cost[inputIndex - 1];
            }
        }
        System.out.println(spent + " " + matrix[inputs.size()][budget]);
    }

    public static void main(String[] args) {
        P2 problem_p2 = new P2();
        ArrayList<String> inputs = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        inputs.add(in.nextLine()); // First input
        String[] temp = inputs.get(0).split("\\s"); // split first input

        int n = Integer.parseInt(temp[1]);
        for (int i = 0; i < n; i++)
            inputs.add(in.nextLine()); // get values

        problem_p2.partyBudget(inputs);
    }
}

/*
https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
https://www.gatevidyalay.com/0-1-knapsack-problem-using-dynamic-programming-approach/
https://www.guru99.com/knapsack-problem-dynamic-programming.html#:~:text=The%20basic%20idea%20of%20Knapsack,dynamic%20programming%20are%20very%20effective.
 */
