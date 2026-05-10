class TimeMap {

    HashMap<String, ArrayList<Pair>> hs;

    public TimeMap() {
        hs = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        hs.putIfAbsent(key, new ArrayList<>());

        hs.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {

        if (!hs.containsKey(key)) {
            return "";
        }

        int st = 0;
        int end = hs.get(key).size() - 1;

        String ans = "";

        while (st <= end) {

            int mid = (st + end) / 2;

            if (hs.get(key).get(mid).time <= timestamp) {

                ans = hs.get(key).get(mid).val;

                st = mid + 1;
            } 
            else {

                end = mid - 1;
            }
        }

        return ans;
    }
}

class Pair {

    int time;
    String val;

    Pair(int time, String val) {

        this.time = time;
        this.val = val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */