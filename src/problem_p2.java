import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class problem_2 {
    void program_run(ArrayList<String> input) {
        String[] temp = input.get(1).split("\\s+");
        int size = Integer.parseInt(input.get(0));
        int counter=0;
        int total=0;
        Integer[] numbers = new Integer[size];

        for(int i=0; i<size; i++) // add each number to the Integer array
            numbers[i] = Integer.parseInt(temp[i]);

        Arrays.sort(numbers, Collections.reverseOrder()); // sort the array in decending order

        for(int i=0; i<size; i++){
            if(counter==2){
                total+=numbers[i];
                counter=-1;
            }
            counter++;
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        problem_2 P2 = new problem_2();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);

        input.add(in.nextLine());
        input.add(in.nextLine());

        P2.program_run(input);
    }
}
