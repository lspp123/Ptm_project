package graph;

import java.util.ArrayList;

public class Topic {
    public final String name;
    ArrayList<Agent> subs;
    ArrayList<Agent> pubs;

    Topic(String name){
        this.name=name;
        subs = new ArrayList<>();
        pubs = new ArrayList<>();
    }

    public void subscribe(Agent a){
        subs.add(a);
    }

    public void unsubscribe(Agent a){
        subs.remove(a);
    }

    public void publish(Message m){
        subs.forEach(a -> a.callback(this.name, m));
    }

    public void addPublisher(Agent a){
        pubs.add(a);
    }

    public void removePublisher(Agent a){
        pubs.remove(a);
    }


}
