class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList();
        }

        int[] count = new int[26];

        Map<String,List<String>> results = new HashMap();
        for(String s : strs){
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuffer buffer = new StringBuffer();

            for(int i=0; i<count.length; i++){
                buffer.append(count[i]);
                buffer.append("#");
            }

            if(!results.containsKey(buffer.toString())){
               results.put(buffer.toString(), new ArrayList());
            } 

             results.get(buffer.toString()).add(s);
        }

        return new ArrayList(results.values());
    }
}