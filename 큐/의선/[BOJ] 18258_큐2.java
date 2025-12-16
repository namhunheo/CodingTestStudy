package queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue    = new LinkedList<>();
        for (int i = 0; i < n; i++) {

            String temp = br.readLine();

            String[] input = temp.split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        int num = queue.poll();
                        sb.append(num).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }


        }

        bw.write(String.valueOf(sb));

        bw.close();



    }
}
