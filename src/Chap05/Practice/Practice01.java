package Chap05.Practice;

import java.io.*;

public class Practice01 {
    static int factorial(int n) {
        int sum = 1;
        for(int i = n; i > 0; i--) {
            sum *= i;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("정수를 입력하세요 : ");
        int x = Integer.parseInt(br.readLine());

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");

        br.close();
    }
}
