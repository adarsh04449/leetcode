class Twitter {

    private class Tweet{
        int time;
        int id;

        Tweet(int time, int id){
            this.time = time;
            this.id = id;
        }
    }

    private int time;
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Tweet>> userTweets;

    public Twitter() {
        time = 0;
        follows = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(time, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1]-a[1]));

        if(userTweets.containsKey(userId)){
            for(Tweet tweet : userTweets.get(userId)){
                pq.offer(new int[]{tweet.id, tweet.time});
            }
        }

        if(follows.containsKey(userId)){
            for(int followee : follows.get(userId)){
                if(userTweets.containsKey(followee)){
                    for(Tweet tweet : userTweets.get(followee)){
                        pq.offer(new int[]{tweet.id, tweet.time});
                    }
                }
            }
        }

        List<Integer> feedList = new ArrayList<>();
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            feedList.add(pq.poll()[0]);
            count++;
        }

        return feedList;  
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }

        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(follows.containsKey(followerId) && follows.get(followerId).contains(followeeId)){
            follows.get(followerId).remove(followeeId);
        }
    }
}
