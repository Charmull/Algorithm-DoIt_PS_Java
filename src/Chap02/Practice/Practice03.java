package Chap02.Practice;

import java.util.Scanner;

public class Practice03 {
    static int sumOf(int[] a) {
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 ：");
        int num = stdIn.nextInt();		// 요솟수

        int[] x = new int[num];			// 요솟수가 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        int sum = sumOf(x);
        System.out.println(sum);
    }
}
