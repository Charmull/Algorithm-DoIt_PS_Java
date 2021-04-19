package Chap06.Practice;

import java.util.Scanner;

public class Practice11 {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    // 퀵정렬
    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        // push 출력
        System.out.printf("a[%d]~a[%d] 분할을 위한 left와 right를 IntStack에 push\n", left, right);
        System.out.println("현재 lstack 출력 : ");
        lstack.dump();
        System.out.println("현재 rstack 출력 : ");
        rstack.dump();
        System.out.println("");

        while (lstack.isEmpty() != true) {
            int pl = left  = lstack.pop();		// 왼쪽 커서
            int pr = right = rstack.pop();		// 오른쪽 커서
            int x = a[(left + right) / 2];		// 피벗

            // pop 출력
            System.out.printf("a[%d]~a[%d] 분할을 위한 pl(left)과 pr(right)를 IntStack에서 pop\n", left, right);
            System.out.printf("현재 pl(left) : %d\n", pl);
            System.out.printf("현재 pr(right) : %d\n", pr);
            System.out.println("");

            // 분할 과정 출력
            System.out.printf("a[%d]~a[%d] : {", left, right);
            for(int i = left; i < right; i++) {
                System.out.printf("%d, ", a[i]);
            }
            System.out.printf("%d}\n", a[right]);
            System.out.println("");

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);				// 왼쪽 그룹 범위의
                rstack.push(pr);				// 인덱스를 푸시합니다.

                // push 출력
                System.out.printf("왼쪽 그룹 a[%d]~a[%d] 분할을 위한 left와 right를 IntStack에 push\n", left, pr);
                System.out.println("현재 lstack 출력 : ");
                lstack.dump();
                System.out.println("현재 rstack 출력 : ");
                rstack.dump();
                System.out.println("");
            }
            if (pl < right) {
                lstack.push(pl);				// 오른쪽 그룹 범위의
                rstack.push(right);				// 인덱스를 푸시합니다.

                // push 출력
                System.out.printf("오른쪽 그룹 a[%d]~a[%d] 분할을 위한 left와 right를 IntStack에 push\n", pl, right);
                System.out.println("현재 lstack 출력 : ");
                lstack.dump();
                System.out.println("현재 rstack 출력 : ");
                rstack.dump();
                System.out.println("");
            }

            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬(비재귀 버전)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx - 1);			// 배열 x를 퀵 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
