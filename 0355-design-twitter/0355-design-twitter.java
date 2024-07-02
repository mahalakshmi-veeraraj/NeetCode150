import java.time.*;
class Twitter {
    class Tweet implements Comparable<Tweet> {
        int tweetId;
        LocalDateTime tweetDateTime;
        public Tweet(int tweetId, LocalDateTime tweetDateTime) {
            this.tweetId = tweetId;
            this.tweetDateTime = tweetDateTime;
        }
        @Override
        public int compareTo(Tweet tweet) {
            if (tweetDateTime.isAfter(tweet.tweetDateTime)) return -1;
            else if (tweetDateTime.isBefore(tweet.tweetDateTime)) return 1;
            else return 0;
        }
    }
    class User {
        int userId;
        List<Tweet> listTweet;
        Set<Integer> setFollowers;
        public User(int userId, List<Tweet> listTweet) {
            this.userId = userId;
            this.listTweet = listTweet;
            this.setFollowers = new HashSet<>();
        }
    }
    Map<Integer, User> hashMap;
    public Twitter() {
        hashMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, LocalDateTime.now());
        if (hashMap.containsKey(userId)) {
            List<Tweet> listTweet = hashMap.get(userId).listTweet;
            listTweet.add(tweet);
        }
        else {
            List<Tweet> listTweet = new ArrayList<>();
            listTweet.add(tweet);
            User user = new User(userId, listTweet);
            hashMap.put(userId, user);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!hashMap.containsKey(userId)) return new ArrayList<>();
        List<Tweet> listTweet = new ArrayList<>(); 
        listTweet.addAll(hashMap.get(userId).listTweet);
        for (Integer follower : hashMap.get(userId).setFollowers) {
            if (!hashMap.containsKey(follower)) continue;
            for (Tweet followerTweet : hashMap.get(follower).listTweet) {
                listTweet.add(followerTweet);
            }
        }
        Collections.sort(listTweet);
        List<Integer> listNewsFeed = new ArrayList<>();
        for (int i = 0; i < (listTweet.size() > 10 ? 10 : listTweet.size()); i++) 
            listNewsFeed.add(listTweet.get(i).tweetId);
        return listNewsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!hashMap.containsKey(followerId)) hashMap.put(followerId, new User(followerId, new ArrayList<>()));
        
        hashMap.get(followerId).setFollowers.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (hashMap.containsKey(followerId)) {
            hashMap.get(followerId).setFollowers.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */