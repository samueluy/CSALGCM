import java.util.ArrayList;
import java.util.Scanner;

public class problem_p2 {

    private void program_run(ArrayList<String> input) {
        String[] initial = input.get(0).split("\\s+"); // get first input
        String[] temp;
        boolean side = true; // true = left, false = right
        int totalTime=0;

        int n = Integer.parseInt(initial[0]); // set m to first value
        int t = Integer.parseInt(initial[1]); // set m to second value
        int m = Integer.parseInt(initial[2]); // set m to third value
        String[][] values = new String[m][m];

        for(int i = 0; i<m; i++){
            temp = input.get(i+1).split("\\s+");
            int arrival = Integer.parseInt(temp[0]);
            switch (temp[1]){ // check side
                case "left":
                    if(side){
                        totalTime+=arrival+t; // add time of arrival and transport time to totalTime
                        side=false;
                    }

                    else {
                        totalTime+=arrival+(2 * t); // double t for back and forth}
                        side=true;
                    }
                    break;

                case "right":
                    if(side){
                        totalTime+=arrival+(2*t); // double t for back and forth
                        side=false;
                        }
                    else{
                        totalTime+=arrival+t; // add time of arival and transport time to totalTime
                        side=true;
                        }
                    break;
            }
            System.out.println(totalTime);
        }


    }

    public static void main(String[] args) {
        problem_p2 P2 = new problem_p2();
        ArrayList<String> input = new ArrayList();
        Scanner in = new Scanner(System.in);

        String set = in.nextLine(); // Ask for n,t,m
        input.add(set);
        // in.nextLine(); // clear input buffer

        String[] initial = input.get(0).split("\\s+"); // get first input
        int m = Integer.parseInt(initial[2]); // set m to third value
        for(int i=0; i<m; i++) // ask for input m times
            input.add(in.nextLine());

        P2.program_run(input);
    }
}
