//从后向前遍历，
//如果nums[i]+1 < 10，则加1,跳出循环
//如果nums[i]+1 >= 10，则重置为0，继续下一遍历
class Solution {
    public int[] plusOne(int[] digits) {

        int i=0;
        for(i=digits.length - 1; i>=0; i--){
            if(digits[i] + 1 < 10){
                digits[i] = digits[i] + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if(i+1 ==0 && digits[i+1] == 0){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        
        return digits;
    }
