package Chap01.Practice;

import java.util.Scanner;

public class Practice03 {
    static int min4(int a, int b, int c, int d) {
        int min = a;
        if(b < min) {
            min = b;
        }
        if(c < min) {
            min = c;
        }
        if(d < min) {
            min = d;
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

        int min = min4(a, b, c, d);
        System.out.println(min);
    }
}