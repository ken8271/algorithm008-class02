class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> kvs = new HashMap<Integer,Integer>();

        for(int i=0; i<nums.length; i++){
            int s1 = nums[i];
            int s2 = target - nums[i];
            if(kvs.containsKey(s2)){
                return new int[]{kvs.get(s2), i};
            }

            kvs.put(s1, i);
        }

        return null;
    }
}