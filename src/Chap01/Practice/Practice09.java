package Chap01.Practice;

import java.util.Scanner;

public class Practice09 {
    static int sumof(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int sum = 0;
        for(int i = b; i <= a; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();

        int sum = sumof(a, b);
        System.out.println(sum);
    }
}
