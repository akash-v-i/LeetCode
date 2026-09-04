class RandomizedSet {

    Map<Integer, Integer> hs;
    List<Integer> li;
    Random rand;

    public RandomizedSet() {
        hs = new HashMap<>();
        li = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (hs.containsKey(val))
            return false;
        li.add(val);
        hs.put(val, li.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!hs.containsKey(val))
            return false;
        int index = hs.get(val);
        int last = li.get(li.size() - 1);
        hs.put(last, index);
        li.set(index, last);
        li.removeLast();
        hs.remove(val);
        return true;
    }

    public int getRandom() {
        int ind = rand.nextInt(li.size());
        return li.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */