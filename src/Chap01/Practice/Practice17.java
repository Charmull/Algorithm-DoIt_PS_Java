package Chap01.Practice;

import java.util.Scanner;

public class Practice17 {
    static void nspira(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < (n-i); j++) {
                System.out.printf(" ");
            }
            for(int j = 0; j < (i*2 - 1); j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nspira(n);
    }
}
