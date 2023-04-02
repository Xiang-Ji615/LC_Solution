class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MAX_VALUE, potions.length);
        for(int i=0;i<potions.length;i++)
            map.putIfAbsent((long)potions[i], i);
        for(int i=0;i<spells.length;i++){
            long target = (success + spells[i] - 1)/spells[i];
            spells[i] = potions.length - map.ceilingEntry(target).getValue();
        }
        return spells;
    }
}