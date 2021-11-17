import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class problem_p2 {
    static int totalTime=0;

    private void program_run(ArrayList<String> input) {

        Queue<Integer> time = new LinkedList<>();
        Queue<String> direction = new LinkedList<>();

        int nCars=0; // number of cars on ship
        boolean side=true; // true = left, false = right
        boolean tempSide=true; // side of next
        boolean first=true;
        boolean last=false;

        String[] initial = input.get(0).split("\\s+"); // get first input
        String[] temp;
        int n = Integer.parseInt(initial[0]); // set m to first value
        int t = Integer.parseInt(initial[1]); // set m to second value
        int m = Integer.parseInt(initial[2]); // set m to third value

        for(int i = 0; i<m; i++) { // set up dictionary
            temp = input.get(i + 1).split("\\s+"); // convert array list input into a string array
            time.add(Integer.parseInt(temp[0])); // add time to queue
            direction.add(temp[1]); // add distance to queue
        }

        for(int i=0; i<m; i++) {
            System.out.println("PEEK: " + time.peek() + ", " + direction.peek());

            switch(direction.peek()) { // set tempSide
                case "left":
                    tempSide = true;
                    break;
                case "right":
                    tempSide = false;
                    break;
            }

            if (first) { // Check if car time to arrive is longer than total time and car count is still lower than max
                switch (direction.remove()) {
                    case "left":
                        totalTime += time.remove() + t;
                        side = false;
                        break;
                    case "right":
                        totalTime += time.remove() + (2 * t);
                        side = true;
                        break;
                }
                first = false;

            } else if (nCars == n || totalTime <= time.peek() || last) {
                nCars = 0; // unload
                switch (direction.remove()) { // check side
                    case "left":
                        if (side) {
                            totalTime += t; // add time of arrival and transport time to totalTime
                            side = false;
                        } else if (!side && tempSide) {
                            totalTime += (2 * t);
                            side = false;
                        } else {
                            totalTime += (2 * t); // double t for back and forth
                            side = true;
                        }
                        break;

                    case "right":
                        if (side) {
                            totalTime += (2 * t); // double t for back and forth
                            side = false;
                        } else {
                            totalTime += t; // add time of arival and transport time to totalTime
                            side = true;
                        }
                        break;
                }
                time.remove();
            }
            else{
                nCars++;
                time.remove();
                direction.remove();
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

        String[] initial = input.get(0).split("\\s+"); // get first input
        int m = Integer.parseInt(initial[2]); // set m to third value
        for(int i=0; i<m; i++) // ask for input m times
            input.add(in.nextLine());

        P2.program_run(input);
    }
}