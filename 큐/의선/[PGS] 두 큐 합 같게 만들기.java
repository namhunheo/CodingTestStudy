package queue;

import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int solution(int[] queue1, int[] queue2) {
        int answer =0;
        int sum1=0;
        int sum2=0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            sum1+=queue1[i];
            q1.offer(queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2+=queue2[i];
            q2.offer(queue2[i]);
        }
        int half = (sum1+sum2)/2;
        int cnt = 0;
        while(true){

            if(sum1>half){
                int temp = q1.poll();
                sum1-=temp;
                q2.offer(temp);
                sum2+=temp;
                cnt++;
            }else if(sum1<half){
                int temp = q2.poll();
                sum2-=temp;
                q1.offer(temp);
                sum1+=temp;
                cnt++;
            }else if(sum1==half){
                return cnt;
            }
            if(cnt>q1.size()+q2.size()){
                return -1;
            }


        }





    }
}