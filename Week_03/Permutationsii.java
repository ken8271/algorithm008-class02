class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null){
            return new ArrayList();
        }

        List<List<Integer>> results = new ArrayList();
        List<Integer> list = new ArrayList();
        for(Integer num : nums){
            list.add(num);
        }

        Collections.sort(list);

        doPermute(list, 0, nums.length, results);

        return results;
    }

    private void doPermute(List<Integer> nums, int first, int size, List<List<Integer>> results){
        if(first == size){
            results.add(new ArrayList(nums));
            return ;
        }

        for(int i=first; i<size; i++){
            if(!isVisited(nums, first, i)){
                Collections.swap(nums, i, first);
                doPermute(nums, first+1, size, results);
                Collections.swap(nums, first, i);
            }
        }
    }

    private boolean isVisited(List<Integer> nums, int first, int n){
        int temp = nums.get(n);
        for (int i=first; i<n; i++){
            if (nums.get(i) == temp){
                return true;
            }
        }
        return false;
    }
}