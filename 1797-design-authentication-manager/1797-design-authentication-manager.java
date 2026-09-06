class AuthenticationManager {

    int timeToLive;

    Map<String, Integer> map;


    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();

    }
    
    public void generate(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) return;
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            if (map.get(tokenId) > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer expireTime : map.values()) {
            if (expireTime > currentTime) {
                count++;
            }
        }
        return count;
        
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */