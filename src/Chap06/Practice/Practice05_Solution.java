package Chap06.Practice;

import java.util.Scanner;

public class Practice05_Solution {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 양방향 버블정렬(셰이커정렬)
    static void shakerSort(int[] a, int n) {
        int countCompare = 0;
        int countChange = 0;

        int left = 0;
        int right = n - 1;
        int last = right;

        int i = 0;
        while (left < right) {
            System.out.printf("패스%d:\n", i+1);
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                    countChange++;
                }
                countCompare++;
            }
            left = last;
            i++;

            System.out.printf("패스%d:\n", i+1);
            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                    countChange++;
                }
                countCompare++;
            }
            right = last;
            i++;
        }
        System.out.printf("비교를 %d회 했습니다.\n", countCompare);
        System.out.printf("교환을 %d회 했습니다.\n", countChange);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양방향 버블정렬(셰이커정렬)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        shakerSort(x, nx); // 배열 x를 양방향 버블정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
