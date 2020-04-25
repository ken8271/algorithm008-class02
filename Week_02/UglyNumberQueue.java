class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> s = new HashSet<>();

        long[] nums = new long[]{2,3,5};

        for(int i=0; i<nums.length; i++){
            queue.offer(nums[i]);
            s.add(nums[i]);
        }

        long num = 1;
        for(int i=1;i<n;i++){
            num = queue.poll();

            for(int j=0; j<nums.length; j++){
                long res = num * nums[j];

                if(!s.contains(res)){
                    queue.offer(res);
                    s.add(res);
                }
            }
        }

        return (int)num;
    }
}