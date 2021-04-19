package Chap05.Practice;

import java.util.Scanner;

// wrong answer
// TODO : IntStack으로 풀어보기
public class Practice07 {
    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        IntStack noStack = new IntStack(no);
        IntStack xStack = new IntStack(no);
        IntStack yStack = new IntStack(no);

        while(true) {
            if (no > 1) {
                noStack.push(no-1);
                xStack.push(x);
                yStack.push(6-x-y);

                no--;
                continue;
            }

            if(noStack.isEmpty() != true) {
                no = noStack.pop();
                System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

                no--;
                x = 6 - x - y;
                y = y;

                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수：");
        int n = stdIn.nextInt();

        move(n, 1, 3);	// 1번 기둥의 n개를 3번 기둥으로 옮김
    }
}
