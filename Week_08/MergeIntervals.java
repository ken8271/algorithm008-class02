class Solution {
    public int[][] merge(int[][] intervals) {
        //校验
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> res = new ArrayList();

        //排序
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        //遍历
        int i = 0;
        while(i < intervals.length){
            //获取左右值
            int left = intervals[i][0];
            int right = intervals[i][1];

            //依次向后遍历看右值是否在区间内，再则重设该区间右边界值
            while(i < intervals.length - 1 && intervals[i+1][0] <= right){
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }

            res.add(new int[]{left, right});

            i++;
        }

        return res.toArray(new int[0][]);
    }
}