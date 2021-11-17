import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;

public class problem_p3 {
    static int counter=0;

    Hashtable<Integer, Integer> convert (ArrayList<String> input){
        Hashtable<Integer, Integer> values = new Hashtable<>();
        String[] initial;
        initial = input.get(1).split("\\s+"); // get train order

        for(int i=1; i<=Integer.parseInt(input.get(0)); i++) {
            values.put(i, Integer.parseInt(initial[i-1]));
        }
        return values;
    }

    void insertionSort(ArrayList<String> input){
        Hashtable<Integer, Integer> values;
        values = convert(input);

        for(int i=2; i<=Integer.parseInt(input.get(0)); i++){
            int holder = values.get(i);
            int y = i-1;
            while(y>0 && holder < values.get(y)){
                values.put(y+1, values.get(y));
                y--;
                counter++;
            }
            values.put(y+1, holder);
        }
    }

    public static void main(String[] args){
        problem_p3 P3 = new problem_p3();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);

        for(int i=0; i<2; i++)
            input.add(in.nextLine());

        P3.insertionSort(input);
        System.out.println("The most optimal train swaps: " +  counter);
    }
}
