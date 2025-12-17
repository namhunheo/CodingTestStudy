import java.util.Scanner;

public class Main{
	//n=13이상인 경우부터는 오버플로우가 발생되어 큰수를 입력받기 위해서 long사용해야한다.
    public static long fac(int i) {
        if (i == 0 || i == 1) return 1;
        return i * fac(i - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fac(n));
    }
}
