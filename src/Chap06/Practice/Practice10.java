package Chap06.Practice;

import java.util.Scanner;

// TODO : overloading 외의 방법으로 해보기
public class Practice10 {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right) {
        int pl = left;					// 왼쪽 커서
        int pr = right;					// 오른쪽 커서
        int x = a[(pl + pr) / 2];		// 피벗

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr)  quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }

    static void quickSort(int[] a, int n) {
        quickSort(a, 0, n-1);
    }

//    // 왼쪽 그룹 정렬만 가능한 상태
//    static void quickSort(int[] a, int n) {
//        int pl = 0;					// 왼쪽 커서
//        int pr = n-1;					// 오른쪽 커서
//        int x = a[(pl + pr) / 2];		// 피벗
//
//        do {
//            while (a[pl] < x) pl++;
//            while (a[pr] > x) pr--;
//            if (pl <= pr)
//                swap(a, pl++, pr--);
//        } while (pl <= pr);
//
//        if (left < pr)  quickSort(a, pr+1);
//        if (pl < right) quickSort(a, n-pl+1);
//    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, nx);			// 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
