class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null){
            return 0;
        }

        int length = beginWord.length();

        //预处理，找出所有单词的通用态
        Map<String, List<String>> dicts = new HashMap();
        for(String word : wordList){
            for(int i=0; i<length; i++){
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, length);
                
                List<String> transforms = dicts.getOrDefault(newWord, new ArrayList());

                transforms.add(word);

                dicts.put(newWord, transforms);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList();
        Set<String> visits = new HashSet();

        queue.add(new Pair(beginWord, 1));
        visits.add(beginWord);

        //遍历队列
        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.remove();
            String w = pair.getKey();
            Integer level = pair.getValue();

            for(int i=0; i<length; i++){
                String newWord = w.substring(0,i) + "*" + w.substring(i+1, length);

                List<String> transforms = dicts.getOrDefault(newWord, new ArrayList());

                for(String transform : transforms){
                    if(transform.equals(endWord)){
                        return level + 1;
                    }

                    if(!visits.contains(transform)){
                        visits.add(transform);
                        queue.add(new Pair(transform, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}