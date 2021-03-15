package Chap01.Practice;

import java.util.Scanner;

public class Practice02 {
    static int min3(int a, int b, int c) {
        int min = a;
        if(b < min) {
            min = b;
        }
        if(c < min) {
            min = c;
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        int min = min3(a, b, c);
        System.out.println(min);
    }
}
