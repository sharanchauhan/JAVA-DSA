import java.util.Collections;
import java.util.PriorityQueue;

public class Priority_Queue {
    public static void PQIntro(){
        // Collections.reverseOrder() will be used for max Priority Queue and will be declared as shown below
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(pq);
        pq.add(10);
        // System.out.println(pq);
        pq.add(-1);
        // System.out.println(pq);
        pq.add(2);
        // System.out.println(pq);
        pq.add(15);
        // System.out.println(pq);
        pq.add(3);
        // System.out.println(pq);
        pq.add(6);
        // System.out.println(pq);
        pq.add(4);
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.size());

        while(pq.size() > 0){
            System.out.print(pq.remove()+" ");
        }
    }
}
