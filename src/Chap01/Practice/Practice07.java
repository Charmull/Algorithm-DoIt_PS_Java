package Chap01.Practice;

import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += i;
            if(i == n) {
                System.out.print(i + " = " + sum);
            }
            else {
                System.out.print(i + " + ");
            }
        }
    }
}
