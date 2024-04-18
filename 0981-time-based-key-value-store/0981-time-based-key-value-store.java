class TimeMap {
    Map<String, List<Pair>> hashMap = new HashMap<>(); 
    class Pair {
        int timestamp;
        String value;
        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> listPair;
        if (!hashMap.containsKey(key)) {
            listPair = new ArrayList<>();
        }
        else {
            listPair = hashMap.get(key);
        }
        listPair.add(new Pair(timestamp, value));
        hashMap.put(key, listPair);
    }
    
    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key)) return "";
        
        List<Pair> listPair = hashMap.get(key);
        for (int i = listPair.size() - 1; i >= 0; i--) {
            if (listPair.get(i).timestamp <= timestamp) {
                return listPair.get(i).value;
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */