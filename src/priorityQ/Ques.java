package priorityQ;

import java.util.*;
import java.util.stream.Stream;

public class Ques {

    public static int buyTicket(int[] input, int k) {
        PriorityQueue<Integer> max_pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : input){
            max_pq.add(x);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            q.add(i);
        }


        int time = 0;

        while(true ){
            if (input[q.element()] == max_pq.element()){
                int pos = q.remove();
                max_pq.remove();
                time++;
                if (pos == k){
                    break;
                }
            }
            else {
                q.add(q.remove());
            }
        }
        return time;
    }

    public static void findMedian(int[] arr) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            if (maxPQ.isEmpty()) {
                maxPQ.add(x);
            } else {
                if (maxPQ.element() > x) {
                    maxPQ.add(x);
                } else {
                    minPQ.add(x);
                }
            }

            if (maxPQ.size() - minPQ.size() > 1) {
                minPQ.add(maxPQ.remove());
            } else if (minPQ.size() - maxPQ.size() > 1) {
                maxPQ.add(minPQ.remove());
            }

            if (maxPQ.size() == minPQ.size()) {
                System.out.print((maxPQ.element() + minPQ.element()) / 2);
                System.out.print(" ");
            } else if (maxPQ.size() > minPQ.size()) {
                System.out.print(maxPQ.element() + " ");
            } else {
                System.out.print(minPQ.element() + " ");
            }
        }
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> x : input) {
            pq.addAll(x);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove());
        }

        return result;

    }

    public static int kthLargest(int n, int[] input, int k) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : input) {
            if (pq.size() <= k) {
                pq.add(x);
            } else {
                if (pq.element() < x) {
                    pq.remove();
                    pq.add(x);
                }
            }
        }
        if (pq.size() > k) {
            pq.remove();
        }

        return pq.element();
    }

    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : input) {
            if (pq.size() <= k) {
                pq.add(x);
            } else {
                if (pq.element() > x) {
                    pq.poll();
                    pq.add(x);
                }
            }
        }

        if (pq.size() > k) {
            pq.poll();
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove());
        }
        return result;

    }

    public static ArrayList<Integer> kLargest(int[] input, int k) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : input) {
            if (pq.size() <= k) {
                pq.add(x);
            } else {
                if (pq.element() < x) {
                    pq.remove();
                    pq.add(x);
                }
            }
        }


        if (pq.size() > k) {
            pq.poll();
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove());
        }
        return result;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(18);
        pq.add(9);
        pq.add(13);
        pq.add(31);
        pq.add(11);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}
