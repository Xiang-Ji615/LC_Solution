class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int l = 0, r = skill.length - 1;
        long sum = skill[0] + skill[skill.length - 1];
        long res = 0;
        while(l < r) {
            if(skill[l] + skill[r] != sum)
                return -1;
            else
                res += skill[l] * skill[r];
            l++;r--;
        }
        return res;
    }
}