package Chap01.Practice;

import java.util.Scanner;

public class Practice08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result;

        if(n % 2 == 0) {
            result = (1 + n) * (n / 2);
        }
        else {
            result = (1+n) * ((n+1)/2) - (n+1)/2;
        }
        System.out.println(result);
    }
}
