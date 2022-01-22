import java.util.*;

public class problem_1 {
    void program_run(ArrayList<String> input) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int floorCount=0;


        for (int i = 1; i < input.size(); i++) { // Add each floor to its respective ArrayList
            int n = Integer.parseInt(input.get(i));
            if (n > 0) positive.add(n);
            else if (n < 0) negative.add(n);
        }

        // Sort array lists
        Collections.sort(positive);
        Collections.reverse(positive);
        Collections.sort(negative);

        // add all elements of positive to queue
        Queue<Integer> positiveQueue = new LinkedList<>(positive);
        Queue<Integer> negativeQueue = new LinkedList<>(negative);

        if(!positiveQueue.isEmpty() && !negativeQueue.isEmpty()){
            if(positiveQueue.peek() > Math.abs(negativeQueue.peek()))
                System.out.println(getFloors(positiveQueue, negativeQueue));
            else
                System.out.println(getFloors(negativeQueue,positiveQueue));
        }
        else if (!positiveQueue.isEmpty() || !negativeQueue.isEmpty()) // if either one is empty
            System.out.println(1);
        else // both are empty
            System.out.println(0);

    }

    int getFloors(Queue<Integer> firstQueue, Queue<Integer> secondQueue){
        ArrayList<Integer> result = new ArrayList<>();
        int resultIndex=-1;
        boolean flag=true;
        // add the largest number to result
        result.add(Math.abs(firstQueue.remove()));

        // while both queues are still not empty || in order
        while(flag){
            boolean run=true;
            resultIndex++;
            while(run) { // repeatedly dequeue secondQueue until a smaller abs(n) is found
                if (!secondQueue.isEmpty()) {
                    int n = Math.abs(secondQueue.remove());

                    if (n < Math.abs(result.get(resultIndex))) {
                        result.add(n);
                        break;
                    }
                } else{
                    flag=false;
                    run = false;
                }
            }
            if(!flag)
                break;

            resultIndex++;
            while(run){ // repeatedly dequeue firstQueue until a smaller abs(n) is found
                if(!firstQueue.isEmpty()){
                    int n = Math.abs(firstQueue.remove());
                    if(n < Math.abs(result.get(resultIndex))){
                        result.add(n);
                        break;
                    }
                }
                else{
                    flag=false;
                    run=false;
                }
            }
        }

        return result.size();
    }
    public static void main(String[] args){
        problem_1 P1 = new problem_1();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);

        input.add(in.nextLine());
        for(int i=0; i<Integer.parseInt(input.get(0)); i++)
            input.add(in.nextLine());

        P1.program_run(input);
    }
}
