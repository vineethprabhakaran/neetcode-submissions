class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        if(visit.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visit.add("0000");
        int turns = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String node = q.poll();
                if(node.equals(target)) return turns;
                for(String lock : children(node)){
                    if(!visit.contains(lock)){
                        q.add(lock);
                        visit.add(lock);
                    }
                }
            }
            turns++;
        }
        return -1;
    }

    public List<String> children(String node){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            char[] arr = node.toCharArray();
            arr[i] = (char)(((arr[i] - '0' + 1) % 10) + '0');
            result.add(new String(arr));
            arr = node.toCharArray();
            arr[i] = (char)(((arr[i] - '0' -1 + 10) % 10) + '0');
            result.add(new String(arr));
        }
         return result;
    }
}