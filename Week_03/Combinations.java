class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || n < k){
            return new ArrayList();
        }

        List<List<Integer>> result = new ArrayList();

        doCombine(n, k, 1, new Stack(), result);

        return result;
    }

    private void doCombine(int n, int k , int start, Stack<Integer> stack, List<List<Integer>> result){
        if(stack.size() == k){
            result.add(new ArrayList(stack));
            return ;
        }

        for(int i=start; i<=n; i++){
            stack.add(i);
            doCombine(n, k, i+1, stack, result);
            stack.pop();
        }
    }
}