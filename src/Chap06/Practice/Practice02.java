package Chap06.Practice;

import java.util.Scanner;

public class Practice02 {
    // a[idx1]와 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // isSwap이 true면 for문 돌릴때, i가 idx2와 같으면 교환한다는 표시해주기(+)
    // isSwap이 false면 for문 돌릴때, i가 idx2와 같으면 교환하지않는다는 표시해주기(-)
    static void print(int[] a, int idx2, boolean isSwap) {
        for(int i = 0; i < a.length; i++) {
            if(i == idx2) {
                if(isSwap) {
                    System.out.printf(" + %d", a[i]);
                }
                else {
                    System.out.printf(" - %d", a[i]);
                }
            }
            else {
                System.out.printf("%4d", a[i]);
            }
        }
        System.out.println();
    }

    // 버블 정렬
    static void bubbleSort(int[] a, int n) {
        int countCompare = 0;
        int countChange = 0;

        for (int i = 0; i < n - 1; i++) {
            System.out.printf("패스%d:\n", i+1);
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    print(a, j, true);
                    swap(a, j - 1, j);
                    countChange++;
                }
                else {
                    print(a, j, false);
                }
                countCompare++;
            }
            // 패스i번째 완료 후, 정렬된 모습 출력
            // idx2는 -1를 넘겨주어 print 함수 내에서 i==idx2일 확률을 0으로 만들어줌.
            // isSwap은 어떤 값을 넘겨줘도 상관없음.
            print(a, -1, false);
        }

        System.out.printf("비교를 %d회 했습니다.\n", countCompare);
        System.out.printf("교환을 %d회 했습니다.\n", countChange);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);				// 배열 x를 버블 정렬합니다.

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
