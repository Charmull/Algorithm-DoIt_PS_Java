package Chap01.Practice;

import java.util.Scanner;

public class Practice16 {
    static void spira(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < (n-i); j++) {
                System.out.printf(" ");
            }
            for(int j = 0; j < (i*2 - 1); j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        spira(n);
    }
}
