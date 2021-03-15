package Chap02.Practice;

import java.util.Scanner;

public class Practice02 {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a) {
        for(int i = 0; i <= (a.length/2); i++) {
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }

            if(i == a.length/2) {
                System.out.println("\n역순 정렬을 마쳤습니다.");
            }
            else {
                System.out.println(String.format("\na[%d]과(와) a[%d]를 교환합니다.", i, a.length-1-i));
                swap(a, i, a.length-1-i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 ：");
        int num = stdIn.nextInt();		// 요솟수

        int[] x = new int[num];			// 요솟수가 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);
    }
}
