package Chap05.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice05 {
    static void recur3(int n) {
        IntStack s = new IntStack(100);
        while(true) {
            if(n > 0) {
                s.push(n);
                n = n-1;
                continue;
            }
            if(!s.isEmpty()) {
                n = s.pop();
                if(n > 0) {
                    s.push(n);
                    n = n-2;
                    continue;
                }
                System.out.println(n);
            }
            break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("정수를 입력하세요. : ");
        int x = Integer.parseInt(br.readLine());

        recur3(x);
    }
}
