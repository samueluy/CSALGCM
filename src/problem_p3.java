import java.util.ArrayList;
import java.util.Scanner;

public class problem_p3 {
    void insertionSort(ArrayList<String> input){
        int counter=0;
        for(int i=0; i<input.size(); i++){
            int holder = Integer.parseInt(input.get(i));
            int y = i-1;
            while(y>=0 && holder < Integer.parseInt(input.get(y))){
                input.set(y+1, input.get(y));
                y--;
                counter++;
            }
            input.set(y+1, Integer.toString(holder));
        }
        System.out.println("The most optimal train swaps: " +  counter);
    }

    public static void main(String[] args){
        problem_p3 P3 = new problem_p3();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(); // Ask for n value
        in.nextLine(); // clear input buffer

        for(int i=0; i<n; i++)
            input.add(in.nextLine());

        P3.insertionSort(input);
    }
}
