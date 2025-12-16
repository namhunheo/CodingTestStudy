package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;



public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size()!=1) {

            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);

        }
        int LastOne = queue.poll();

        bw.write(LastOne+"");


        bw.close();



    }
}
