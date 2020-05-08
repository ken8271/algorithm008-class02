class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null) {
            return new ArrayList();
        }

        List<List<Integer>> results = new ArrayList();
        List<Integer> list = new ArrayList();
        for(Integer num : nums){
            list.add(num);
        }

        doPermute(list, 0, nums.length, results);

        return results;
    }

    private void doPermute(List<Integer> nums, int first, int size, List<List<Integer>> results){
        if(first == size){
            results.add(new ArrayList(nums));
            return ;
        }

        for(int i=first; i<size; i++){
            Collections.swap(nums, i, first);
            doPermute(nums, first+1, size, results);
            Collections.swap(nums, first, i);
        }
    }
}