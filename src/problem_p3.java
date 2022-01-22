import java.util.*;
public class problem_3 {
    void program_run(ArrayList<String> input) {
        String[] temp = input.get(0).split("\\s+");
        if (Integer.parseInt(temp[0]) != input.get(1).length()) System.out.println("Invalid Input");
        else if (Integer.parseInt(temp[0]) == 0) System.out.println();
        else System.out.println(getMin(input.get(1), Integer.parseInt(temp[1])));
    }

    long getMin(String n, int k){
        long min = Long.parseLong(n); // Integer.parseInt can not take high values
        String curN;

        for(int i=0; i<k; i++){
            curN = String.valueOf(min);
            for(int y=0; y<curN.length(); y++){
                StringBuilder temp = new StringBuilder();
                temp.append(curN); // copy n to temp
                temp.deleteCharAt(y); // deletes char at y
                if(temp.charAt(0) != '0') // no trailing zero
                    min = Long.min(min, Integer.parseInt(temp.toString())); // stores the minimum value
            }
        }
        return min;
    }
    public static void main(String[] args){
        problem_3 P3 = new problem_3();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);

        input.add(in.nextLine());
        input.add(in.nextLine());

        P3.program_run(input);
    }
}
