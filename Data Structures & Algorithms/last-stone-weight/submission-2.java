class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int stone : stones) {
            arr.add(stone);
        }

        while (arr.size() > 1) {
            Collections.sort(arr);

            int a = arr.remove(arr.size() - 1);
            int b = arr.remove(arr.size() - 1);

            if (a != b) {
                arr.add(a - b);
            }
        }

        if (arr.size() == 0) {
            return 0;
        }

        return arr.get(0);
    }
}