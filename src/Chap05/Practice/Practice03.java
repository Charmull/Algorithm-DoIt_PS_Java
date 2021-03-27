package Chap05.Practice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice03 {
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

    static int gcdArray(int[] a) {
        int gcdTemp = gcd(a[0], a[1]);

        for(int i = 2; i < a.length; i++) {
            gcdTemp = gcd(gcdTemp, a[i]);
        }

        return gcdTemp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("최대공약수는 " + gcdArray(arr) + "입니다.");
    }
}
