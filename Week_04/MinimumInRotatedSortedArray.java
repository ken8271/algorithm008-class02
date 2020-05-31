class Solution {
    public int findMin(int[] nums) {
        if(nums == null){
            return -1;
        }

        if(nums.length == 1){
            return nums[0];
        }

        if(nums[0] < nums[nums.length - 1]){
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }

            if(nums[mid] > nums[0]){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return -1;
    }
}