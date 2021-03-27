package Chap05.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice05_Solution {
    // 메소드 recur의 비재귀적 구현
    static void recur3(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;
                System.out.println("sw : " + sw);

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;
                System.out.println("dowhile문 sw : " + sw);

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("정수를 입력하세요. : ");
        int x = Integer.parseInt(br.readLine());

        recur3(x);
    }
}
