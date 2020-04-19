class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int i = 0;
        int n = nums[i];
        for(int j=1; j<nums.length && i<nums.length; j++){
            if(nums[j] != n){
                nums[++i] = nums[j];
                n = nums[j];
            }
        }
        return i + 1;
    }
}