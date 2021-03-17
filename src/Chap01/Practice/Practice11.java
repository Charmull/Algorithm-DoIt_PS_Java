package Chap01.Practice;

import java.util.Scanner;

public class Practice11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int result = 1;
        for(int i = num; i >= 10; i /= 10) {
            result++;
        }

        System.out.println(String.format("그 수는 %d자리입니다.", result));
    }
}
