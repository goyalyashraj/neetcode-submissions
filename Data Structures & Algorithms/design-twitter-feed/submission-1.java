class Twitter {
    HashMap<Integer, HashSet<Integer>> follow;
    HashMap<Integer, List<int[]>> tweet;
    int time = 0;
    public Twitter() {
        follow = new HashMap<>();
        tweet = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweet.computeIfAbsent(userId, k -> new ArrayList());
        tweet.get(userId).add(new int[] {time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        if (tweet.containsKey(userId)) {
            for (int[] t : tweet.get(userId)) {
                q.offer(t);
            }
        }

        Set<Integer> followee = follow.getOrDefault(userId, new HashSet());
        for (int f : followee) {
            if (tweet.containsKey(f)) {
                for (int[] a : tweet.get(f)) q.offer(a);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty() && list.size() < 10) {
            list.add(q.poll()[1]);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        follow.computeIfAbsent(followerId, k -> new HashSet());
        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}
