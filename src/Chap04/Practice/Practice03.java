package Chap04.Practice;

public class Practice03 {
    private int max;
    private int ptr1, ptr2;
    private int[] stk;

    public enum leftOrRight {
        Stack1, Stack2
    };

    // 실행 시 예외 : 스택이 비어 있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    // 생성자
    public Practice03(int capacity) {
        ptr1 = 0;
        ptr2 = capacity - 1;
        max = capacity;
        try {
            stk = new int[max];				// 스택 본체용 배열을  생성
        } catch (OutOfMemoryError e) {		// 생성할 수 없음
            max = 0;
        }
    }

    // push
    public int push(leftOrRight st, int x) throws EmptyIntStackException {
        if(ptr1 >= ptr2 + 1) {
            throw new EmptyIntStackException();
        }
        // if(st == Stack1) 은 왜 안되는지?(Q)
        switch (st) {
            case Stack1:
                stk[ptr1++] = x;
                break;
            case Stack2:
                stk[ptr2--] = x;
                break;
        }
        return x;
    }

    // pop
    public int pop(leftOrRight st) throws OverflowIntStackException {
        int x = 0;
        switch (st) {
            case Stack1:
                if(ptr1 <= 0) {
                    throw new OverflowIntStackException();
                }
                x = stk[--ptr1];
                break;

            case Stack2:
                if(ptr2 + 1 >= max) {
                    throw new OverflowIntStackException();
                }
                x = stk[++ptr2];
                break;
        }
        return x;
    }

    // 피크
    public int peek(leftOrRight st) throws EmptyIntStackException {
        int x = 0;
        switch (st) {
            case Stack1:
                if (ptr1 <= 0)
                    throw new EmptyIntStackException();
                x = stk[ptr1 - 1];
                break;
            case Stack2:
                if (ptr2 + 1 >= max)
                    throw new EmptyIntStackException();
                x = stk[ptr2 + 1];
                break;
        }
        return x;
    }

    // indexOf
    public int indexOf(leftOrRight st, int x) {
        switch (st) {
            case Stack1:
                for (int i = ptr1 - 1; i >= 0; i--) {
                    if (stk[i] == x) {
                        return i;
                    }
                }
                break;
            case Stack2:
                for (int i = ptr2 + 1; i < max; i++) {
                    if (stk[i] == x) {
                        return i;
                    }
                }
                break;
        }
        return -1;
    }

    // clear
    public void clear(leftOrRight st) {
        switch (st) {
            case Stack1:
                ptr1 = 0;
                break;
            case Stack2:
                ptr2 = max - 1;
                break;
        }
    }

    // capacity
    public int capacity() {
        return max;
    }

    // size
    public int size(leftOrRight st) {
        switch (st) {
            case Stack1:
                return ptr1;
            case Stack2:
                return max - 1 - ptr2;
        }
        return 0;
    }

    // isEmpty
    public boolean isEmpty(leftOrRight st) {
        switch (st) {
            case Stack1:
                return ptr1 <= 0;
            case Stack2:
                return ptr2 >= max - 1;
        }
        return true;
    }

    // isFull
    public boolean isFull() {
        return ptr1 >= ptr2 + 1;
    }

    // dump
    public void dump(leftOrRight st) {
        switch (st) {
            case Stack1:
                if (ptr1 <= 0) {
                    System.out.println("스택이 비었습니다.");
                }
                else {
                    for (int i = 0; i < ptr1; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
            case Stack2:
                if (ptr2 + 1 >= max) {
                    System.out.println("스택이 비었습니다.");
                }
                else {
                    for (int i = max - 1; i > ptr2; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
        }
    }
}
