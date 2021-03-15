package Chap02.Practice;

class YMD {
    int y, m, d;

    // 각 달의 일수
    static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
    };

    // 서기 year년은 윤년인가? (윤년：1／평년：0)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    YMD(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public YMD YMDAfter(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        temp.d += n;
        while(temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
            if(temp.m + 1 > 12) {
                temp.y++;
                temp.m = 1;
            }
            else {
                temp.m++;
            }
        }

        return temp;
    }

    public YMD YMDBefore(int n) {
        YMD temp = new YMD(this.y, this.m, this.d);
        temp.d -= n;
        while(temp.d <= 0) {
            if(temp.m - 1 < 1) {
                temp.y--;
                temp.m = 12;
            }
            else {
                temp.m--;
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1];
        }

        return temp;
    }
}

public class Practice11 {
    public static void main(String[] args) {
        YMD today = new YMD(2021, 3, 16);
        System.out.printf("%d, %d, %d\n", today.y, today.m, today.d);
        YMD after = today.YMDAfter(45);
        System.out.printf("%d, %d, %d\n", after.y, after.m, after.d);
        YMD before = today.YMDBefore(16);
        System.out.printf("%d, %d, %d\n", before.y, before.m, before.d);
    }
}
