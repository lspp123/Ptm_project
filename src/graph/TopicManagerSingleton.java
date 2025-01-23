package graph;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicManagerSingleton {

    public static class TopicManager{
        private static final TopicManager instance = new TopicManager();
        Map<String, Topic> topics;

        private TopicManager() {
            topics = new ConcurrentHashMap<>();
        }

        public Topic getTopic(String topicName) {
            if (!topics.containsKey(topicName))
                topics.put(topicName, new Topic(topicName));
            return topics.get(topicName);
        }

        public Collection<Topic> getTopics() {
            return topics.values();
        }

        public void clear() {
            topics.clear();
        }

    }

    public static TopicManager get() {
        return TopicManager.instance;
    }

}