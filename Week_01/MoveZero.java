class MoveZero {
    public static void main(){
        int[] arr = new int[]{0,1,0,3,8};
        moveZero(arr);
    }

    public static void moveZero(int[] nums) {
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) {
                nums[k] = nums[i];
                if(i != k) {
                    nums[i] = 0;
                }
                k++;
            }
        }
    }
}