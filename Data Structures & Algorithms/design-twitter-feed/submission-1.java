
class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int t, int id) {
        time = t;
        tweetId = id;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time;
    }
}

class User {
    int userId;
    HashSet<Integer> followees;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followees = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t);
    }

    public void addFollower(int followeeId) {
        followees.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        followees.remove(followeeId);
    }
}

class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;

        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);

        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        if (!userMap.containsKey(userId)) {
            return result;
        }

        User user = userMap.get(userId);

        List<Tweet> allTweets = new ArrayList<>();

        // My tweets
        allTweets.addAll(user.tweets);

        // Tweets of people I follow
        for (int followeeId : user.followees) {
            User followee = userMap.get(followeeId);
            allTweets.addAll(followee.tweets);
        }

        Collections.sort(allTweets);

        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i).tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }

        userMap.get(followerId).addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId)) {
            return;
        }

        userMap.get(followerId).removeFollower(followeeId);
    }
}