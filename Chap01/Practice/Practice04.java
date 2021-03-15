package Chap01.Practice;

import java.util.Scanner;

public class Practice04 {
    static int med3(int a, int b, int c) {
        if(a >= b) {
            if(b >= c) {
                return b;
            }
            else if(a >= c) {
                return c;
            }
            else {
                return c;
            }
        }
        else if(a >= c) {
            return a;
        }
        else if(b >= c) {
            return c;
        }
        else {
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        int med = med3(a, b, c);
        System.out.println(med);
    }
}
