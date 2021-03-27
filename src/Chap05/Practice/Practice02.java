package Chap05.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice02 {
    static int gcd(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        while(true) {
            if(max % min == 0) {
                return min;
            }
            else {
                int temp = max;
                max = min;
                min = temp % min;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");
        int x = Integer.parseInt(br.readLine());
        System.out.print("정수를 입력하세요 : ");
        int y = Integer.parseInt(br.readLine());

        System.out.println("최대공약수는 " + gcd(x,y) + "입니다.");
    }
}
