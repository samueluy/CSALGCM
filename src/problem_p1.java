import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
public class problem_p1 {
    private void program_run(ArrayList<String> input) {
        Stack<Character> values = new Stack(); // Declare stack data structure
        String item;

        for(int i=0; i<input.size(); i++){ // itterate through all values in array list
            boolean valid = true;
            item = input.get(i);
            for(int y=0; y<item.length(); y++) { //itterate through all characters of the string
                char ch = item.charAt(y);
                if(ch == '(' || ch == '[')
                    values.push(item.charAt(y)); // push opening parenthesis or bracket to stack
                else if(values.empty()){ // terminate if current stack is empty
                    y=item.length();
                    valid = false;
                }
                else if(ch == ')') {
                    if (values.pop() != '(') {
                        y = item.length(); // Terminate loop
                        valid = false;
                    }
                }
                    else if(ch == ')') {
                        if (values.pop() != '(') {
                            y = item.length(); // Terminate loop
                            valid = false;
                        }
                    }
                    else if (ch == ']') {
                            if (values.pop() != '[') {
                                y = item.length(); // Terminate loop
                                valid = false;
                            }
                    }
            }
            if(values.empty() && valid)  // Check if current stack is empty and valid
                System.out.println("Yes");
            else System.out.println("No");
            values.clear();
        }
        input.clear(); // Clear stack
    }

    public static void main(String[] args){
        problem_p1 P1 = new problem_p1();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(); // Ask for n value
        in.nextLine(); // clear input buffer

        for(int i=0; i<n; i++)
            input.add(in.nextLine());

        P1.program_run(input);
    }
}
