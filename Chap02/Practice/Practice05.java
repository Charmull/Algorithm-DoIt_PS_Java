package Chap02.Practice;

import java.util.Scanner;

public class Practice05 {
    static void rcopy(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            a[i] = b[b.length-1-i];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 ：");
        int num = stdIn.nextInt();		// 요솟수

        int[] a = new int[num];			// 요솟수가 num인 배열
        int[] b = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        System.out.println("rcopy 전, 배열 a");
        for (int i = 0; i < num; i++) {
            System.out.print(a[i] + " ");
        }

        rcopy(a, b);

        System.out.println("\nrcopy 후, 배열 a");
        for (int i = 0; i < num; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
