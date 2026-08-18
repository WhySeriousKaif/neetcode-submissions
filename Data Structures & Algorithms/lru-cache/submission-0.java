class LRUCache {
    ArrayList<Pair> cache = new ArrayList<>();
    int n;

    public LRUCache(int capacity) {
        n = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {

            if (cache.get(i).key == key) {

                int val = cache.get(i).val;
                Pair temp = cache.get(i);

                // Remove from current position
                cache.remove(i);

                // Add to end = most recently used
                cache.add(temp);

                return val;
            }
        }

        return -1;
    }

    public void put(int key, int value) {

        // Check if key already exists
        for (int i = 0; i < cache.size(); i++) {

            if (cache.get(i).key == key) {

                // Remove old pair
                cache.remove(i);

                // Add updated pair at end
                cache.add(new Pair(key, value));

                return;
            }
        }

        // Cache is full
        if (cache.size() == n) {

            // Remove least recently used
            cache.remove(0);

            // Add new pair as most recently used
            cache.add(new Pair(key, value));

        } else {

            cache.add(new Pair(key, value));
        }
    }

    class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}