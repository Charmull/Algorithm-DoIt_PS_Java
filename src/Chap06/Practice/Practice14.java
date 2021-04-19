package Chap06.Practice;

import java.util.Scanner;

public class Practice14 {
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    // 단순 삽입 정렬
    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];
            for (j = i; j > 0 && a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    // 중앙값 찾기
    static int med(int a, int b, int c) {
        int med = 0;
        if(a >= b) {
            if(b >= c) {    // a >= b >= c
                med = b;
            }
            else if(a >= c) {   // a >= c > b
                med = c;
            }
            else if(c > a) {    // c > a >= b
                med = a;
            }
        }
        else if(b > a) {
            if(a >= c) {    // b > a >= c
                med = a;
            }
            else if(b >= c) {   // b >= c > a
                med = c;
            }
            else if(c > b) {    // c > b > a
                med = b;
            }
        }
        return med;
    }

    // 퀵 정렬(재귀 버전)
    static void quickSort1(int[] a, int left, int right) {
        int pl = left;					// 왼쪽 커서
        int pr = right;					// 오른쪽 커서
        int x = med(a[left], a[right], a[(pl + pr) / 2]);		// 피벗

        // 요소의 개수가 9개 이하이면 단순 삽입 정렬
        if(right - left + 1 <= 9) {
            insertionSort(a,right-left+1);
        }
        // 요소의 개수가 10개 이상이면 퀵 정렬
        else {
            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            // 요소의 개수가 많은 그룹을 먼저 push해서 요소의 개수가 적은 그룹을 먼저 분할하게 한다.
            if(pr - left >= right - pl) {
                if (left < pr)  quickSort1(a, left, pr);
                if (pl < right) quickSort1(a, pl, right);
            }
            else {
                if (pl < right) quickSort1(a, pl, right);
                if (left < pr)  quickSort1(a, left, pr);
            }
        }
    }

    // 퀵정렬(비재귀 버전)
    static void quickSort2(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left  = lstack.pop();		// 왼쪽 커서
            int pr = right = rstack.pop();		// 오른쪽 커서
            int x = med(a[left], a[right], a[(left + right) / 2]);		// 피벗

            // 요소의 개수가 9개 이하이면 단순 삽입 정렬
            if(right - left + 1 <= 9) {
                insertionSort(a,right-left+1);
            }
            // 요소의 개수가 10개 이상이면 퀵 정렬
            else {
                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr)
                        swap(a, pl++, pr--);
                } while (pl <= pr);

                // 요소의 개수가 많은 그룹을 먼저 push해서 요소의 개수가 적은 그룹을 먼저 분할하게 한다.
                if(pr - left >= right - pl) {
                    if (left < pr) {
                        lstack.push(left);				// 왼쪽 그룹 범위의
                        rstack.push(pr);				// 인덱스를 푸시합니다.
                    }
                    if (pl < right) {
                        lstack.push(pl);				// 오른쪽 그룹 범위의
                        rstack.push(right);				// 인덱스를 푸시합니다.
                    }
                }
                else {
                    if (pl < right) {
                        lstack.push(pl);				// 오른쪽 그룹 범위의
                        rstack.push(right);				// 인덱스를 푸시합니다.
                    }
                    if (left < pr) {
                        lstack.push(left);				// 왼쪽 그룹 범위의
                        rstack.push(pr);				// 인덱스를 푸시합니다.
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬(요소가 9개 이하일 때는 단순 삽입 정렬)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        quickSort1(x, 0, nx - 1);			// 배열 x를 퀵 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
