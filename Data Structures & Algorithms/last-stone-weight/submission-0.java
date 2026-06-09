class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            pq.offer(s);
        }

        while(pq.size()>1){
            int p1 = pq.poll();
            int p2 = pq.poll();

            if(p1>p2){
                pq.offer(p1-p2);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
