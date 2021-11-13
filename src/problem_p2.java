import java.util.ArrayList;
import java.util.Scanner;

public class problem_p2 {

    private void program_run(ArrayList<String> input) {
        String[] initial = input.get(0).split("\\s+"); // get first input
        String[] temp;
        String[] temp2;

        boolean side = true; // true = left, false = right
        boolean tempSide=true;
        int totalTime=0;
        int nCars=0;
        int arrival2=0;

        boolean first=true;
        boolean last=false;

        int n = Integer.parseInt(initial[0]); // set m to first value
        int t = Integer.parseInt(initial[1]); // set m to second value
        int m = Integer.parseInt(initial[2]); // set m to third value
        String[][] values = new String[m][m];

        for(int i = 0; i<m; i++){
            temp = input.get(i+1).split("\\s+");
            if(i+2<=m){ // set the values of next input
                temp2 = input.get(i+2).split("\\s+");
                arrival2=Integer.parseInt(temp2[0]);
                switch(temp2[1]){
                    case "left": tempSide=true;
                                break;
                    case "right": tempSide=false;
                                break;
                }
            }
            else
                last=true;

            int arrival = Integer.parseInt(temp[0]);

            if(first) { // Check if car time to arrive is longer than total time and car count is still lower than max
                    switch(temp[1]){
                        case "left": totalTime+=arrival+t;
                                    side=false;
                                    break;
                        case "right": totalTime+=arrival+(2*t);
                            side=true;
                            break;
                    }
                    first = false;
            }
            else if(nCars==n || totalTime<arrival2 || last){
                nCars=0; // unload
                    switch (temp[1]){ // check side
                        case "left":
                            if(side){
                                totalTime+=t; // add time of arrival and transport time to totalTime
                                side=false;
                            }
                            else if(!side && tempSide){
                                totalTime+=(2*t);
                                side=false;
                            }
                            else {
                                totalTime+=(2*t); // double t for back and forth
                                side=true;
                            }
                            break;

                        case "right":
                            if(side){
                                totalTime+=(2*t); // double t for back and forth
                                side=false;
                            }
                            else{
                                totalTime+=t; // add time of arival and transport time to totalTime
                                side=true;
                            }
                            break;
                    }
            }
            else
                nCars++;

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