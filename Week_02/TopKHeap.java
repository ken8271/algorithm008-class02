//1.统计个数
//2.按个数放入堆
//3.从堆中取出
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counts = new HashMap();

        for(int num : nums){
            Integer count = counts.get(num);

            if(count != null){
                counts.put(num, count+1);
            } else {
                counts.put(num, 1);
            }
        }

        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> counts.get(n1) - counts.get(n2));

        for(Integer num : counts.keySet()){
            heap.offer(num);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] results = new int[k];
        int i=k-1;
        while(!heap.isEmpty()){
            results[i--] = heap.poll();
        }

        return results;
    }
}