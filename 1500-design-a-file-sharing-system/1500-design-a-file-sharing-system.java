class FileSharing {
    
    PriorityQueue<Integer> minHeap;
    Map<Integer, Set<Integer>> userToChunks;

    public FileSharing(int m) {
        this.minHeap = new PriorityQueue<>();
        this.userToChunks = new HashMap<>();
        minHeap.add(1);
    }
    
    public int join(List<Integer> ownedChunks) {
        int id = minHeap.poll();
        if (minHeap.isEmpty()) {
            minHeap.add(id + 1);
        }
        userToChunks.put(id, new HashSet<>(ownedChunks));
        return id;        
    }
    
    public void leave(int userID) {
        minHeap.add(userID);
        userToChunks.remove(userID);
    }
    
    public List<Integer> request(int userID, int chunkID) {
        List<Integer> res = new ArrayList<>();
        for (Integer user : userToChunks.keySet()) {
            if (userToChunks.get(user).contains(chunkID)) {
                res.add(user);
            }
        }
        if (res.size() != 0) {
            userToChunks.get(userID).add(chunkID);
        }
        return res;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */