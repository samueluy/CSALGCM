// https://www.geeksforgeeks.org/merge-sort/

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.lang.Object;

public class problem_p2 {
    static Point firstPoint;
    static Point secondPoint;
    void program_run(ArrayList<String> input) {

    }

    void merge(Point[] values, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Point L[] = new Point[n1];
        Point R[] = new Point[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = values[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = values[middle + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].x <= R[j].x) {
                values[k] = L[i];
                i++;
            } else {
                values[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            values[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            values[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(Point[] values, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;

            sort(values, left, m);
            sort(values, m + 1, right);

            merge(values, left, m, right);
        }
    }

    int search(Point[] array, Point toFind){
        for(int i=0; i<array.length; i++){
            if(array[i]==toFind)
                return i;
        }
        return -1;
    }

    double brute(Point[] use){
        double closest = Double.MAX_VALUE;
        for(int i=0; i<use.length; i++){
            for(int j=i+1; j<use.length; j++){
                if(distance(use[i], use[j]) < closest){
                    closest=distance(use[i], use[j]);
                    firstPoint = use[i];
                    secondPoint = use[j];
                }

            }
        }
        return closest;
    }

    double createInside(Point[] inside, int n, double d){
        double minimum =d;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(distance(inside[i], inside[j])<d)
                    minimum=distance(inside[i], inside[j]);
            }
        }
        return minimum;
    }

    double closestPoint(Point[] values, int n){
        if(n<4)
            return brute(values);

        int middle = n/2;
        Point temp = values[middle];

        int n1 = values.length-middle;
        int n2 = values.length-middle;
        Point[] left = new Point[n1];
        Point[] right = new Point[n2];

        for(int i=0; i<n1; i++){
            left[i]=new Point();
            left[i]=values[i];
        }
        for (int i = 0; i < n2; ++i){
            right[i]=new Point();
            right[i] = values[middle+i];
        }

        double leftClosest = closestPoint(values, middle);
        double rightClosest = closestPoint(values, n-middle); // to change like merge sort

        double d;
        if(leftClosest<rightClosest)
            d = leftClosest;
        else
            d = rightClosest;


        Point[] inside = new Point[n];
        for(int i=0; i<n; i++){
            inside[i] = new Point();
        }
        int j=0;
        for(int i=0; i<n; i++){
            if((values[i].x - temp.x) < d){
                inside[j] = values[i];
                j++;
            }
        }

        double insideValue = createInside(inside,j,d);
        if(d < insideValue)
            return d;
        else
            return insideValue;
    }

    double distance(Point a, Point b){
        return Point2D.distance(a.x, a.y, b.x, b.y);
    }


    static void printArray(Point arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i].x + " ");
        System.out.println();
    }

    double findClosestPoint(Point[] values){
        sort(values, 0, values.length-1);
        return closestPoint(values, values.length);
    }

    public static void main(String args[]) {
        Point arr[] = new Point[8];
        Point temp[] = new Point[arr.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = new Point();
        arr[0].x = 1;
        arr[0].y = 1;

        arr[1].x = 14;
        arr[1].y = 2;

        arr[2].x = 8;
        arr[2].y = 7;

        arr[3].x = 2;
        arr[3].y = 2;

        arr[4].x = 9;
        arr[4].y = 2;

        arr[5].x = 16;
        arr[5].y = 12;

        arr[6].x = 7;
        arr[6].y = 4;

        arr[7].x = 34;
        arr[7].y = 53;

        System.out.println("Given Array");
        printArray(arr);
        temp = arr.clone();
        problem_p2 ob = new problem_p2();


        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);

        double closest = ob.findClosestPoint(arr);
        System.out.println("Closest: ");
        System.out.format("%.6f\n", closest);

        int firstIndex=ob.search(temp, firstPoint);
        int secondIndex=ob.search(temp, secondPoint);
        printArray(temp);
        System.out.println(firstIndex + " "+ secondIndex);
    }
}

    /*
    public static void main(String[] args){
        problem_p2 P2 = new problem_p2();
        ArrayList<String>  input = new ArrayList();
        Scanner in = new Scanner(System.in);

        input.add(in.nextLine());
        for(int i=0; i<Integer.parseInt(input.get(0)); i++)
            input.add(in.nextLine());

        // Parse Array list and put into an array pof Points
        Point[] values = new Point[input.size()];
        String[] temp;
        for(int i=1; i<=Integer.parseInt(input.get(0)); i++) {
            values[i] = new Point();
            temp = input.get(i).split("\\s+");
            values[i].setLocation(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        Arrays.sort(values, new problem_p2());




        //convert(input);

        //P2.program_run(input);
    }
     */