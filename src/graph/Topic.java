package graph;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    public final String name;
    ArrayList<Agent> subs;
    ArrayList<Agent> pubs;

    Topic(String name){
        this.name=name;
    }

    public void subscribe(Agent a){
        subs.add(a);
    }

    public void unsubscribe(Agent a){
        subs.remove(a);
    }

    public void publish(Message m){
        pubs.forEach(a -> a.callback(this.name, m));
    }

    public void addPublisher(Agent a){
        pubs.add(a);
    }

    public void removePublisher(Agent a){
        pubs.remove(a);
    }


}
