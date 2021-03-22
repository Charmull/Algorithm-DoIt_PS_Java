package Chap04.Practice;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수：" + s.size() + " / "
                    + s.capacity());
            System.out.print("(1)푸시　(2)팝　(3)피크　" +
                    "(4)덤프　(5)indexOf (6)clear (7)isEmpty (8)isFull  (0)종료：");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: 							// 푸시
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2: 							// 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3: 							// 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4: 							// 덤프
                    s.dump();
                    break;

                case 5:
                    x = stdIn.nextInt();
                    int idxOfx = s.indexOf(x);
                    if(idxOfx == -1) {
                        System.out.println("해당 값은 없습니다.");
                    }
                    else {
                        System.out.printf("해당 값은 %d번째 인덱스에 있습니다.\n", idxOfx);
                    }
                    break;

                case 6:
                    s.clear();
                    break;

                case 7:
                    System.out.println(s.isEmpty() == false ? "스택은 비어있지않습니다." : "스택은 비어있습니다.");
                    break;

                case 8:
                    System.out.println(s.isFull() == false ? "스택은 가득 차있지않습니다." : "스택은 가득 차있습니다.");
                    break;
            }
        }
    }
}
