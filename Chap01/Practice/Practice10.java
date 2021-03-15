package Chap01.Practice;

import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a의 값 : ");
        int a = sc.nextInt();
        int b = 0;

        while(true) {
            System.out.print("b의 값 : ");
            b = sc.nextInt();
            if(b <= a) {
                System.out.println("a보다 큰 값을 입력하세요!");
            }
            else {
                break;
            }
        }

        System.out.println(String.format("b - a는 %d입니다.", b-a));
    }
}
