package Chap01.Practice;

import java.util.Scanner;

public class Practice01 {
    static int max4(int a, int b, int c, int d){
        int max = a;
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        if(d > max) {
            max = d;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

        int max = max4(a, b, c, d);
        System.out.println(max);
    }
}
