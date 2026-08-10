class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] stoneFreq = new int[101];
        int maxStone = Integer.MIN_VALUE;
        for (int stone: stones) {
            stoneFreq[stone]++;
            maxStone = Math.max(stone, maxStone);
        }
        int stoneCount = stones.length, stone1, stone2;
        while (stoneCount > 1) {
            stone1 = 0;
            stone2 = 0;
            for (int i=maxStone; i>=1; i--) {
                if (stone1 != 0 && stone2 != 0) {
                    break;
                }
                if (stoneFreq[i] == 0) {
                    continue;
                } else if (stoneFreq[i] == 1) {
                    if (stone1 == 0) stone1 = i;
                    else stone2 = i;
                    stoneFreq[i]--;
                    stoneCount--;
                } else {
                    if (stone1 == 0) {
                        stone1 = i;
                        stoneFreq[i]--;
                        stoneCount--;
                    }
                    stone2 = i;
                    stoneFreq[i]--;
                    stoneCount--;
                }
            }
            int diff = stone1-stone2;
            if (diff == 0) {
                continue;
            } else {
                stoneFreq[diff]++;
                stoneCount++;
            }
        }
        if (stoneCount == 0) {
            return 0;
        } else {
            for (int i=maxStone; i>=1; i--) {
                if (stoneFreq[i] != 0) {
                    return i;
                }
            }
            return 0;
        }        
    }
}
