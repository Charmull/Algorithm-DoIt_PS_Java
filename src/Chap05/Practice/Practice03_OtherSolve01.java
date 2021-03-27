package Chap05.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03_OtherSolve01 {
    static int gcd(int x, int y) {
        int max = Math.max(x,y);
        int min = Math.min(x,y);

        if(min == 0) {
            return max;
        }
        else {
            return gcd(min, max % min);
        }
    }

    static int gcdArray(int[] a, int start, int size) {
        if (size == 1)
            return a[start];
        else if (size == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray(a, start + 1, size - 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("최대공약수는 " + gcdArray(arr, 0, N) + "입니다.");
    }
}
