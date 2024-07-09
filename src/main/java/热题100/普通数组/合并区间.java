package 热题100.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][2];
        }
        // Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[] > res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            int[] last = res.get(res.size()-1);
            if (last[1] < tmp[0]) {
                res.add(tmp);
            } else {
                last[1] = Math.max(tmp[1], last[1]);
                res.set(res.size()-1, last);
            }
        }
        int[][] arr = new int[res.size()][];
        return res.toArray(arr);

    }


}
