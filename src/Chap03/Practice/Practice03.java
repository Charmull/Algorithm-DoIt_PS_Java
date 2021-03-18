package Chap03.Practice;

import java.util.Scanner;

public class Practice03 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] == key) {
                idx[count] = i;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수：");
        int num = stdIn.nextInt();
        int[] x = new int[num];				// 요솟수 num + 1
        int[] idx = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값：");			// 키값을 입력
        int ky = stdIn.nextInt();

        int result = searchIdx(x, num, ky, idx);		// 배열x에서 값이 ky인 요소를 검색

        if (result == 0)
            System.out.println("그 값의 요소가 없습니다.");
        else {
            for(int i = 0; i < result; i++) {
                System.out.printf("[%d], ", idx[i]);
            }
            System.out.println("\n" + ky +"은(는) " + result + "개 있습니다.");
        }
    }
}
