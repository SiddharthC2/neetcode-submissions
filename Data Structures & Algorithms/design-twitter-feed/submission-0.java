class Twitter {

    private final Map<Integer, List<int[]>> userTweets;
    private final Map<Integer, Set<Integer>> userFollowees;
    private int time;

    public Twitter() {
        userTweets = new HashMap<>();
        userFollowees = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>())
            .add(new int[] {time--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        this.follow(userId, userId);

        for (Integer followee: userFollowees.get(userId)) {
            List<int[]> tweetDetailList = userTweets.get(followee);
            if (tweetDetailList == null) continue;
            int idx = tweetDetailList.size()-1;
            int[] tweetDetail = tweetDetailList.get(idx);
            maxHeap.offer(new int[] {tweetDetail[0], tweetDetail[1], followee, idx});
        }

        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            int[] heapPeek = maxHeap.poll();
            newsFeed.add(heapPeek[1]);
            int followee = heapPeek[2];
            int idx = heapPeek[3];
            if (idx > 0) {
                List<int[]> tweetDetailList = userTweets.get(followee);
                int[] tweetDetail = tweetDetailList.get(idx-1);
                maxHeap.offer(new int[] {tweetDetail[0], tweetDetail[1], followee, idx-1});
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowees.computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = userFollowees.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
