package Chap06.Practice;

import java.util.Scanner;

public class Practice08 {
    static int binSearch(int[] a, int n, int key) {
        int pl = 0;			// 검색 범위의 첫 인덱스
        int pr = n - 1;		// 검색 범위의 끝 인덱스
        int pc;
        int location;

        do {
            pc = (pl + pr) / 2;		// 중앙 요소의 인덱스
            if (a[pc] == key)
                break;
            else if (a[pc] < key)
                pl = pc + 1;			// 검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1;			// 검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

        // pr+1인 이유 : 위의 doWhile문이 끝나는 경우는 a[pc] == key일 때 이외에, pl >= pr인 경우밖에 없음.
        // 1. 이때, pl == pr인 경우, a[pc] < key이면 pl=pc+1이 되고, pr=pc이다. --> a[pc]<key일때 location은 pc+1 위치로 설정해주어야한다.
        // 2. 이때, pl == pr인 경우, a[pc] > key이면 pr=pc-1이 되고, pl=pc이다. --> a[pc]<key일때 location은 pc 위치로 설정해주어야한다.
        // 즉, pl>pr일 경우, location은 pr+1 또는 pl로 해야한다.
        location = (pl <= pr) ? pc + 1 : pr + 1;

        return location;
    }

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];

            int location = binSearch(a, i, tmp);


            for (j = i; j > location; j--)
                a[j] = a[j - 1];
            a[location] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);				// 배열 x를 단순 삽입 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }}
