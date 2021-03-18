package Chap03.Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice07 {
    // 신체검사 데이터를 정의합니다.
    static class PhyscData {
        private String name;			// 이름
        private int    height;			// 키
        private double vision;			// 시력

        // 생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;  this.height = height;  this.vision = vision;
        }

        // 문자열을 반환하는 메서드(정보 확인용)
        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 오름차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.height > d2.height) ?  1 : (d1.height < d2.height) ? -1 : 0;
            }
        }

        // 내림차순으로 정렬하기 위한 comparator
        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData d1, PhyscData d2) {
                // 양수일 때 자리 바꿈
                return (d1.vision < d2.vision) ? 1 : (d1.vision > d2.vision) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {					// 키의 오름차순으로 정렬되어 있습니다.
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이나령", 162, 0.3),
        };
        System.out.print("시력이 몇인 사람을 찾고 있나요?：");
        double vision = stdIn.nextDouble();
        int idx = Arrays.binarySearch(
                x,									// 배열x에서
                new PhyscData("", 0, vision),
                PhyscData.VISION_ORDER
        );

        if (idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터：" + x[idx]);
        }
    }
}
