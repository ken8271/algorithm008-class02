class Solution {
    public int search(int[] nums, int target) {
        if(nums == null){
            return -1;
        }

        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = nums.length -1;
        while(left < right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])){
                left = mid + 1;
            } else if(target > nums[mid] && target < nums[0]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left == right && nums[left] == target ?  left : -1;
    }
}