class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        TreeMap<Integer, String> keyMap = map.get(key);
        // Binary search the tree map for an entry
        Map.Entry<Integer, String> entry = keyMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
