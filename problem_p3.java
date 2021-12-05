import java.util.ArrayList;
import java.util.Scanner;

public class problem_p3 {
    int laugh(int n, ArrayList<String> sequence) {
        if (n > 1)
            return laugh(n-2, sequence) * laugh(n - 1, sequence);

        if (n == 0) {
            sequence.add("H");
            return 0;
        } else{
            sequence.add("A");
            return 1;
        }
    }

    public static void main(String[] args) {
        problem_p3 P3 = new problem_p3();
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> sequence = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        input.add(in.nextLine());
        String[] temp = input.get(0).split("\\s+");

        P3.laugh((Integer.parseInt(temp[0])), sequence);
        System.out.println(sequence.get(Integer.parseInt(temp[1])));
    }
}
