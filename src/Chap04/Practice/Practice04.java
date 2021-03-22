package Chap04.Practice;

// IntAryQueue -> Practice04
public class Practice04 {
    private int max;
    private int num;
    private int[] que;

    public class EmptyP04Exception extends RuntimeException {
        public EmptyP04Exception() {}
    }

    public class OverflowP04Exception extends RuntimeException {
        public OverflowP04Exception() {}
    }

    public Practice04(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // enque
    public int enque(int x) throws OverflowP04Exception {
        if(num >= max) {
            throw new OverflowP04Exception();
        }
        return que[num++] = x;
    }

    // deque
    public int deque() throws EmptyP04Exception {
        if(num <= 0) {
            throw new EmptyP04Exception();
        }
        int x = que[0];
        for(int i = 1; i < num; i++) {
            que[i-1] = que[i];
        }
        num--;
        return x;
    }

    // peek
    public int peek() throws EmptyP04Exception {
        if(num <= 0) {
            throw new EmptyP04Exception();
        }
        return que[num - 1];
    }

    // indexOf
    public int indexOf(int x) {
        for(int i = 0; i < num; i++) {
            if(que[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // clear
    public void clear() {
        num = 0;
    }

    // capacity
    public int capacity() {
        return max;
    }

    // size
    public int size() {
        return num;
    }

    // isEmpty
    public boolean isEmpty() {
        return num <= 0;
    }

    // isFull
    public boolean isFull() {
        return num >= max;
    }

    // dump
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
