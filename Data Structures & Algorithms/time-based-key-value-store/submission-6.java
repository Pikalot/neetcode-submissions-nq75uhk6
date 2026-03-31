class TimeMap {
    Map<String, Map<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {      
        map.putIfAbsent(key, new HashMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> keyMap = map.get(key);
        if (keyMap == null) return "";
        List<Integer> keys = new ArrayList<>(keyMap.keySet());
        keys.sort((a, b) -> a - b);
        if (timestamp < keys.get(0)) return "";
        int time = binSearch(keys, timestamp);
        return map.get(key).get(time);
    }

    private static int binSearch(List<Integer> set, int target) {
        int l = 0, r = set.size() - 1, res = set.get(l);
        while (l <= r) {
            int m = (l + r) / 2;
            int value = set.get(m);
            if (value == target) return value;
            else if (value < target) {
                res = value;
                l = m + 1;
            }
            else r = m - 1;
        }
        return res;
    }
}
