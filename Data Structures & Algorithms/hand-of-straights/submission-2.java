class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int key : count.keySet()){
            int freq = count.get(key);
            if (freq > 0){
                for (int i = 0; i < freq; i++) {
                for (int j = key; j < key + groupSize; j++) {
                    if (count.getOrDefault(j, 0) < 1) return false;
                    count.put(j, count.get(j) - 1);
                   }
               }
            }
        }
        return true;
    }
}
