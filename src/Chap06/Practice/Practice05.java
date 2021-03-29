package Chap06.Practice;

import java.util.Scanner;

public class Practice05 {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    // 버블 정렬(버전 3)
    static void bubbleSort(int[] a, int n) {
        int countCompare = 0;
        int countChange = 0;

        int k = 0;								// a[k]보다 앞쪽은 정렬을 마친 상태
        int i = 0;
        while (k < n - 1) {
            System.out.printf("패스%d:\n", i+1);
            if(i%2 == 0) {
                int last = n - 1;					// 마지막으로 요소를 교환한 위치
                for (int j = n - 1; j > k; j--) {
                    if (a[j - 1] > a[j]) {
                        swap(a, j - 1, j);
                        last = j;
                        countChange++;
                    }
                    countCompare++;
                }
                k = last;
            }
            else {
                int last = n - 1;					// 마지막으로 요소를 교환한 위치
                for (int j = k; j < n-1; j++) {
                    if (a[j] > a[j+1]) {
                        swap(a, j, j+1);
                        last = j;
                        countChange++;
                    }
                    countCompare++;
                }
                k = last;
            }

            i++;
        }
        System.out.printf("비교를 %d회 했습니다.\n", countCompare);
        System.out.printf("교환을 %d회 했습니다.\n", countChange);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 3)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);				// 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
