import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {   
        
        // 제일 큰것이랑 작은것이랑 곱해야해
        //정렬하고 곱해서 결과
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i<B.length/2 ; i++){
            int temp = B[i];
            B[i] = B[B.length-1-i];
            B[B.length-1-i] = temp;
        }
        for(int j = 0; j < A.length; j++){
             answer += A[j] * B[j];
        }
        
        
        

        return answer;
    }
}