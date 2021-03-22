package Chap04.Practice;

// 이름을 Gstack<E> 대신 Practice02<E>로 하겠습니다.
public class Practice02<E> {
    private int max;
    private int ptr;
    private E[] stk;

    // 왜 static 메소드여야 하는가??(Q)
    public static class EmptyGstackException extends RuntimeException {
        public EmptyGstackException() {}
    }

    // 실행할 때 예외：스택이 가득 참
    public static class OverflowGstackException extends RuntimeException {
        public OverflowGstackException() {}
    }

    // 생성자
    public Practice02(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            // E 배열 생성하는 법(Q)
            stk = (E[]) new Object[max]; // 스택 본체용 배열을 생성
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 푸시
    public E push(E x) throws OverflowGstackException {
        if(ptr >= max) {
            throw new OverflowGstackException();
        }
        return stk[ptr++] = x;
    }

    // 팝
    public E pop() throws EmptyGstackException {
        if(ptr <= 0) {
            throw new EmptyGstackException();
        }
        return stk[--ptr];
    }

    // 피크
    public E peek() throws EmptyGstackException {
        if(ptr <= 0) {
            throw new EmptyGstackException();
        }
        return stk[ptr - 1];
    }

    // indexOf
    public int indexOf(E x) {
        for(int i = ptr-1; i >= 0; i--) {
            if(stk[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // clear
    public void clear() {
        ptr = 0;
    }

    // capacity
    public int capacity() {
        return max;
    }

    // size
    public int size() {
        return ptr;
    }

    // isEmpty
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // isFull
    public boolean isFull() {
        return ptr >= max;
    }

    // dump
    public void dump() {
        if(ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        }
        else {
            for(int i = 0; i < ptr; i++) {
                System.out.println(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
